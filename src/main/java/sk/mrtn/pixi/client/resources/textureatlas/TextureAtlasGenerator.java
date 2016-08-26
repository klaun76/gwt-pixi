package sk.mrtn.pixi.client.resources.textureatlas;

import com.google.common.io.ByteStreams;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.dev.json.*;
import com.google.gwt.dev.util.Util;
import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.resources.ext.AbstractResourceGenerator;
import com.google.gwt.resources.ext.ResourceContext;
import com.google.gwt.resources.ext.ResourceGeneratorUtil;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.user.rebind.SourceWriter;
import com.google.gwt.user.rebind.StringSourceWriter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;

/**
 * designed for resources generated from TexturePacker
 * (https://www.codeandweb.com/texturepacker)
 * Special thanks goes to fishi for showing me
 * how to do this litlle piece of magic :-)
 * @author klaun
 */

public class TextureAtlasGenerator extends AbstractResourceGenerator {

    private List<String> outputUrlExpressions;
    private Set<String> frameNames;

    @Override
    public String createAssignment(
            TreeLogger treeLogger,
            ResourceContext resourceContext,
            JMethod method
    ) throws UnableToCompleteException {
        this.outputUrlExpressions = new ArrayList<>();
        this.frameNames = new HashSet<>();
        // retrieving valid resources
        URL[] resources = ResourceGeneratorUtil.findResources(treeLogger, resourceContext, method);
        // all resources with possible siblings
        List<URL> jsonUrls = getJsonUrls(treeLogger, resources);

        while (!jsonUrls.isEmpty()) {
            URL url = jsonUrls.remove(0);

            // filename of image described in json
            String imageSourceFilenameString;
            JsonObject jsonObject;
            JsonObject metaJson;
            try {
                jsonObject = JsonObject.parse(new InputStreamReader(url.openStream()));
                metaJson = jsonObject.get("meta").asObject();
                final JsonString imageJson = metaJson.get("image").asString();
                imageSourceFilenameString = imageJson.getString();
                if (imageSourceFilenameString == null || imageSourceFilenameString.isEmpty()) {
                    treeLogger.log(TreeLogger.ERROR, "Could not parse image path");
                    throw new UnableToCompleteException();
                }
            } catch (JsonException | IOException | NullPointerException e) {
                treeLogger.log(TreeLogger.ERROR, "Unable to parse source image path", e);
                throw new UnableToCompleteException();
            }
            // full path to filename of image specified in json
            URL imageUrl;
            try {
                imageUrl = new URL(url, imageSourceFilenameString);
            } catch (MalformedURLException e) {
                treeLogger.log(TreeLogger.ERROR, "Unable to read source image url", e);
                throw new UnableToCompleteException();
            }
            // reading image for upcoming generation of image resources
            byte[] imageBytes;
            try {
                imageBytes = ByteStreams.toByteArray(imageUrl.openStream());
            } catch (IOException e) {
                treeLogger.log(TreeLogger.ERROR, "Unable to read source image", e);
                throw new UnableToCompleteException();
            }
            // filename of image specified in json after compilation
            String imageDeployFileNameString;
            // deploying images and getting filename of image for replacement in original json
            imageDeployFileNameString = deploy(treeLogger, resourceContext.getGeneratorContext(), imageSourceFilenameString, imageBytes);

            // replacing original image name for deployed filename
            metaJson.put("image", imageDeployFileNameString);

            StringWriter jsonStringWriter = new StringWriter();

            try {
                jsonObject.write(jsonStringWriter);
            } catch (IOException e) {
                treeLogger.log(TreeLogger.ERROR, "Unable to write json", e);
                throw new UnableToCompleteException();
            }
            // creates actual resource for json file
            String deploy = resourceContext.deploy(
                    url.getPath().substring(url.getPath().lastIndexOf("/") + 1),
                    "application/json",
                    jsonStringWriter.toString().getBytes(Charset.defaultCharset()),
                    true);

            this.outputUrlExpressions.add(deploy);

            // saves frames to be accesible from resource interface
            JsonObject frameNames = jsonObject.get("frames").asObject();
            if (frameNames == null) {
                final JsonArray framesArray = jsonObject.get("frames").asArray();
                for (int i = 0, n = framesArray.getLength(); i < n; i++) {
                    final JsonObject frame = framesArray.get(i).asObject();
                    this.frameNames.add(frame.get("filename").asString().getString());
                }
            } else {
                // fallback for older version of texture packer file
                for (Pair<String, JsonValue> frameName : frameNames) {
                    this.frameNames.add(frameName.getA());
                }
            }
        }

        return generateResourceClass(method, resources);
    }

    /**
     * generates source class
     * @param method
     * @param urls
     * @return
     */
    private String generateResourceClass(JMethod method, URL[] urls) {
        SourceWriter sw = new StringSourceWriter();
        if (!AbstractResourceGenerator.STRIP_COMMENTS) {
            for (URL resource : urls) {
                sw.println("// " + resource.toExternalForm());
            }
        }
        sw.println("new " + TextureAtlasImpl.class.getName() + "(");
        sw.indent();
        sw.println('"' + method.getName() + "\",");

        sw.println("new com.google.gwt.safehtml.shared.SafeUri[] {");
        sw.indent();
        for (String outputUrlExpression : this.outputUrlExpressions) {
            sw.println(UriUtils.class.getName() + ".fromTrustedString(" + outputUrlExpression + "),");
        }

        sw.outdent();
        sw.println("}, ");

        sw.print("new String[] {");

        for (String frameName : this.frameNames) {
            sw.print("\"" + frameName + "\", ");
        }

        sw.println("} ");
        sw.outdent();
        sw.print(")");
        return sw.toString();
    }

    /**
     * at first method gets urls of resource.
     * then searches for sequential siblings that may be
     * provided when generated from TexturePacker
     * example resource file name * <resourceName>_0.json
     * @param treeLogger
     * @param urls
     * @return
     * @throws UnableToCompleteException
     */
    private List<URL> getJsonUrls(
            TreeLogger treeLogger,
            URL[] urls
    ) throws UnableToCompleteException {
        List<URL> jsonUrls = new ArrayList<>();
        for (URL url : urls) {

            jsonUrls.add(url);

            /**
             * check if filename is in format that could indicate that we have
             * url series <resourceName>_0.json
             */
            final RegExp compile = RegExp.compile("(.+)_(\\d+)\\.(\\w+)");
            final MatchResult exec = compile.exec(url.getPath().substring(url.getPath().lastIndexOf("/") + 1));
            if (exec != null) {
                final String filePrefix = exec.getGroup(1);
                int fileSequenceIndex = Integer.valueOf(exec.getGroup(2));
                final String fileExtension = exec.getGroup(3);
                URL siblingUrl = null;

                try {
                    while (true) {
                        String siblingUri = filePrefix + "_" + (++fileSequenceIndex) + "." + fileExtension;
                        siblingUrl = new URL(url, siblingUri);
                        siblingUrl.openStream();
                        if (!jsonUrls.contains(siblingUrl)) {
                            jsonUrls.add(siblingUrl);
                        }
                    }
                } catch (MalformedURLException e) {
                    treeLogger.log(TreeLogger.ERROR, "Reading of sibling texture atlas failed ", e);
                    throw new UnableToCompleteException();
                } catch (IOException e) {
                    if (Objects.equals(siblingUrl, url)) {
                        treeLogger.log(TreeLogger.ERROR, "Reading of sibling texture atlas failed ", e);
                        throw new UnableToCompleteException();
                    } else {
                        // all siblings found process is finished
                    }
                }
            }
        }
        return jsonUrls;
    }

    /**
     * method determines image output filename and generates resource
     * for image (or omits file, if its already created)
     * @param treeLogger
     * @param generatorContext
     * @param suggestedFileName
     * @param data
     * @return
     * @throws UnableToCompleteException
     */
    private String deploy(
            final TreeLogger treeLogger,
            final GeneratorContext generatorContext,
            final String suggestedFileName,
            final byte[] data) throws UnableToCompleteException {

        // Determine the final filename for the resource's file
        String outputName;
        String strongName = Util.computeStrongName(data);

        // Determine the extension of the original file
        String extension;
        int lastIdx = suggestedFileName.lastIndexOf('.');
        if (lastIdx != -1) {
            extension = suggestedFileName.substring(lastIdx + 1);
        } else {
            extension = "noext";
        }

        // The name will be MD5.cache.ext
        outputName = strongName + ".cache." + extension;
        // Ask the generatorContext for an OutputStream into the named resource
        OutputStream out = generatorContext.tryCreateResource(treeLogger, outputName);

        // This would be null if the resource has already been created in the
        // output (because two or more resources had identical content).
        if (out != null) {
            try {
                out.write(data);

            } catch (IOException e) {
                treeLogger.log(TreeLogger.ERROR, "Unable to write data to output name " + outputName, e);
                throw new UnableToCompleteException();
            }

            // If there's an error, this won't be called and there will be nothing
            // created in the output directory.
            generatorContext.commitResource(treeLogger, out);

            if (treeLogger.isLoggable(TreeLogger.DEBUG)) {
                treeLogger.log(TreeLogger.DEBUG, "Copied " + data.length + " bytes to " + outputName, null);
            }
        }
        return outputName;
    }
}
