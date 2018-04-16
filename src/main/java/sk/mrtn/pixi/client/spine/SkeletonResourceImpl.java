package sk.mrtn.pixi.client.spine;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.safehtml.shared.SafeUri;
import jsinterop.annotations.JsMethod;
import sk.mrtn.pixi.client.parsers.InterfaceReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SkeletonResourceImpl implements SkeletonResource {

    private final String name;
    private final String skeletonSource;
    private final String atlasSource;
    private final Map<String, SafeUri> images;

//    private SkeletonData skeletonData;
    private TextureAtlas textureAtlas;
    private List<SafeUri> urisOfAtlasImages;

    public SkeletonResourceImpl(final String name, final String skeletonSource, final String atlasSource, final Map<String, SafeUri> images) {
        this.name = name;
        this.skeletonSource = skeletonSource;
        this.atlasSource = atlasSource;

        this.images = new HashMap<>();

        this.urisOfAtlasImages = images.values().stream().collect(Collectors.toList());
        this.images.putAll(images);
    }

    @Override
    public List<SafeUri> getUrisOfAtlasImages() {
//        GWT.log("SKELETON SOURCE: " + skeletonSource);
//        GWT.log("\n\n\n\n");
//        GWT.log("ATLAS SOURCE: " + atlasSource);
        return this.urisOfAtlasImages;
    }

    @Override
    public Map<String, SafeUri> getImagesMap() {
        return this.images;
    }

    @Override
    public String getName() {
        return this.name;
    }

//    @Override
//    public SkeletonData getSkeletonData() {
//        if (this.skeletonData == null) {
//        }
//        return this.skeletonData;
//    }

    @Override
    public TextureAtlas getTextureAtlas() {
        if (this.textureAtlas == null) {
            textureAtlas = TextureAtlas.Statics.create(atlasSource, images);
//
            JSONValue jsonValue = JSONParser.parseStrict(skeletonSource);
            final JavaScriptObject rawSkeletondata = jsonValue.isObject().getJavaScriptObject();
            log(rawSkeletondata);

            log(textureAtlas);
            SkeletonJson spineJsonParser = new SkeletonJson(new AtlasAttachmentLoader(textureAtlas));

            SkeletonData data = spineJsonParser.readSkeletonData(rawSkeletondata);
            log(data);
//            InterfaceReader.parseObjectAndOutputToConsole(data, "");
        }
        return this.textureAtlas;
    }

    private static JavaScriptObject toJsObject(Map<String, SafeUri> input) {
        JSONObject jsonObject = new JSONObject();

        for (String imageKey : input.keySet()) {
            JSONString jsonString = new JSONString(input.get(imageKey).asString());
            jsonObject.put(imageKey, jsonString);
        }
        return jsonObject.getJavaScriptObject();
    }

    public static native void log(Object object) /*-{
        $wnd.console.log(object);
    }-*/;

}
