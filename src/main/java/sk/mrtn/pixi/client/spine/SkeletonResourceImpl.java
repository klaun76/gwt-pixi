package sk.mrtn.pixi.client.spine;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeUri;

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
//    private TextureAtlas textureAtlas;
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
        GWT.log("SKELETON SOURCE: " + skeletonSource);
        GWT.log("\n\n\n\n");
        GWT.log("ATLAS SOURCE: " + atlasSource);
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
//            TextureAtlasAttachmentLoader textureAtlasAttachmentLoader = TextureAtlasAttachmentLoader.Statics.create(getTextureAtlas());
//            final SkeletonJson skeletonJson = SkeletonJson.Statics.create(textureAtlasAttachmentLoader);
//            //SKELETON RAW DATA
//            JSONValue jsonValue = JSONParser.parseStrict(skeletonSource);
//            final JavaScriptObject rawSkeletondata = jsonValue.isObject().getJavaScriptObject();
//            //SKELETON DATA for Spine
//            this.skeletonData = skeletonJson.readSkeletonData(rawSkeletondata);
//        }
//        return this.skeletonData;
//    }
//
//    @Override
//    public TextureAtlas getTextureAtlas() {
//        if (this.textureAtlas == null) {
//            this.textureAtlas = new TextureAtlas(atlasSource, skeletonSource, null);//.Statics.create(atlasSource, images);
//        }
//        return this.textureAtlas;
//    }
}
