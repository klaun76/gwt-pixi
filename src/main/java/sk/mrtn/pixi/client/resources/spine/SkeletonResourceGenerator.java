package sk.mrtn.pixi.client.resources.spine;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.dev.util.Util;
import com.google.gwt.resources.ext.AbstractResourceGenerator;
import com.google.gwt.resources.ext.ResourceContext;
import com.google.gwt.resources.ext.ResourceGeneratorUtil;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.user.rebind.SourceWriter;
import com.google.gwt.user.rebind.StringSourceWriter;
import sk.mrtn.pixi.client.spine.SkeletonResourceImpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Tomas Ecker
 */
public class SkeletonResourceGenerator extends AbstractResourceGenerator {

    @Override
    public String createAssignment(TreeLogger logger, ResourceContext context, JMethod method) throws UnableToCompleteException {
        URL[] resources = ResourceGeneratorUtil.findResources(logger, context, method);

        URL skeletonResourceUrl = resources[0];
        URL atlasResourceUrl = null;

        try {
            String source = resources[0].toURI().toString();
            String[] sourceSplits = source.split(Pattern.quote("."));
            if (sourceSplits.length > 1) {
                atlasResourceUrl = new URL(resources[0], sourceSplits[0].concat(".atlas"));
            }
        } catch (MalformedURLException | URISyntaxException e) {
            logger.log(TreeLogger.ERROR, "Can't create atlas resource URL.");
            throw new UnableToCompleteException();
        }

        SourceWriter sw = new StringSourceWriter();
        // Write the expression to create the subtype.
        sw.println("new " + SkeletonResourceImpl.class.getName() + "(");
        sw.indent();

        sw.println("\"" + method.getName() + "\", ");

        if (!AbstractResourceGenerator.STRIP_COMMENTS) {
            // Convenience when examining the generated code.
            sw.println("// " + skeletonResourceUrl.toExternalForm());
        }
        String skeletonSource = Util.readURLAsString(skeletonResourceUrl);
        String atlasSource = Util.readURLAsString(atlasResourceUrl);
        sw.println("\"" + Generator.escape(skeletonSource) + "\", ");
        if (!AbstractResourceGenerator.STRIP_COMMENTS) {
            sw.println("// " + atlasResourceUrl.toExternalForm());
        }
        sw.println("\"" + Generator.escape(atlasSource) + "\", ");

        List<String> imageNames;
        try (Stream<String> stream = Files.lines(Paths.get(atlasResourceUrl.toURI()))) {
            imageNames = stream.map(String::trim)
                    .filter(line -> !line.isEmpty() && (line.endsWith(".png") || line.endsWith(".bmp") || line.endsWith(".gif") || line.endsWith(".jpg")))
                    .collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            logger.log(TreeLogger.ERROR, "Problem during atlas source reading.");
            throw new UnableToCompleteException();
        }

        sw.println("new java.util.HashMap<String, com.google.gwt.safehtml.shared.SafeUri>() {{");
        sw.indent();
        imageNames.forEach(imageName -> {
                    try {
                        String[] imageNameSplited = imageName.split(Pattern.quote("."));
                        String imageNameExtension = imageNameSplited[imageNameSplited.length - 1];
                        String mimeType = "image/" + (imageNameExtension.equals("jpg") ? "jpeg" : imageNameExtension);
                        String imageUrlRetrievalExpression = context.deploy(new URL(skeletonResourceUrl, imageName), mimeType, true);
                        sw.println("put(\"" + imageName + "\"," + UriUtils.class.getName() + ".fromTrustedString(" + imageUrlRetrievalExpression + "));");
                    } catch (MalformedURLException | UnableToCompleteException e) {
                        logger.log(TreeLogger.ERROR, "Can't retrieve image URL expression.");
                    }
                }
        );

        sw.outdent();
        sw.println("}}");
        sw.outdent();
        sw.print(")");

        return sw.toString();
    }
}