package sk.mrtn.pixi.client.spine;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.safehtml.shared.SafeUri;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Tomas Ecker
 */
public class SkeletonResourceImpl implements SkeletonResource {

    private final String name;
    private final String rawSkeletonData;
    private final String rawAtlasData;
    private final Map<String, SafeUri> rawAtlasDataImageMap;

    private SkeletonData skeletonData;
    private TextureAtlas textureAtlas;
    private List<SafeUri> urisOfAtlasImages;

    public SkeletonResourceImpl(final String name, final String rawSkeletonData, final String rawAtlasData, final Map<String, SafeUri> rawAtlasDataImageMap) {
        this.name = name;
        this.rawSkeletonData = rawSkeletonData;
        this.rawAtlasData = rawAtlasData;

        this.rawAtlasDataImageMap = new HashMap<>();

        this.urisOfAtlasImages = rawAtlasDataImageMap.values().stream().collect(Collectors.toList());
        this.rawAtlasDataImageMap.putAll(rawAtlasDataImageMap);
    }

    @Override
    public List<SafeUri> getUrisOfAtlasImages() {
        return this.urisOfAtlasImages;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public SkeletonData getSkeletonData() {
        if (this.skeletonData == null) {
            JSONValue jsonValue = JSONParser.parseStrict(this.rawSkeletonData);
            JavaScriptObject rawSkeletondata = jsonValue.isObject().getJavaScriptObject();
            SkeletonJson spineJsonParser = new SkeletonJson(new AtlasAttachmentLoader(getTextureAtlas()));
            this.skeletonData = spineJsonParser.readSkeletonData(rawSkeletondata);
        }
        return this.skeletonData;
    }

    /**
     * Metoda sa nepouziva nikde mimo tejto triedy. Pouziva sa len pre ziskanie objektu TextureAtlas.
     *
     * @return TextureAtlas
     */
    private TextureAtlas getTextureAtlas() {
        if (this.textureAtlas == null) {
            this.textureAtlas = TextureAtlas.create(this.rawAtlasData, this.rawAtlasDataImageMap);
        }
        return this.textureAtlas;
    }
}
