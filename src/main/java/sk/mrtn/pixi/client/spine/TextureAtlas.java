package sk.mrtn.pixi.client.spine;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeUri;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.BaseTexture;

import java.util.Map;

/**
 * Main purpose of Atlas is to bind image with it's data sheet.
 * <p>
 * a) Data sheet = rawAtlasData should contain description of each part of given spine
 * <p>
 * file: example of skeleton.atlas content
 * <p>
 * skeleton.png
 * size: 1024,1024
 * format: RGBA8888
 * filter: Linear,Linear
 * repeat: none
 * in_back
 * rotate: false
 * xy: 402, 2
 * size: 455, 238
 * orig: 455, 238
 * offset: 0, 0
 * index: -1
 * <p>
 * <p>
 * b) Image = rawAtlasDataImage containing appropriate visual parts
 * <p>
 * - URI to skeleton.png
 * <p>
 * Atlas is needed for {@link AtlasAttachmentLoader} production
 * AtlasAttachmentParser atlasAttachmentParser = AtlasAttachmentParser.Statics.create(atlas);
 *
 * @author Tomas Ecker
 */
@JsType(isNative = true, namespace = "PIXI.spine.core")
public class TextureAtlas {

    @FunctionalInterface
    @JsFunction
    private interface IOnTextureAtlasLoaded {
        void call(String resourceLine, ICallback callback);
    }

    @FunctionalInterface
    @JsFunction
    private interface ICallback {
        void call(BaseTexture baseTexture);
    }

    @JsConstructor
    public TextureAtlas(String rawAtlasData, IOnTextureAtlasLoaded onTextureLoaded) {}

    @JsOverlay
    public static final TextureAtlas create(final String rawAtlasData, final Map<String, SafeUri> rawAtlasDataImageMap) {
        return Statics.create(rawAtlasData, rawAtlasDataImageMap);
    }

    public static class Statics {

        /**
         * Create Atlas using rawAtlasData what is content of  *.atlas file and list of links to appropriate images that are named in that *.atlas file
         *
         * @param rawAtlasData
         * @param rawAtlasDataImageMap
         * @return TextureAtlas
         */
        public static TextureAtlas create(final String rawAtlasData, final Map<String, SafeUri> rawAtlasDataImageMap) {

            return new TextureAtlas(rawAtlasData, (resourceLine, callback) -> {
                SafeUri safeUri = rawAtlasDataImageMap.get(resourceLine);
                callback.call(BaseTexture.fromImage(safeUri.asString()));
            });
        }
    }
}
