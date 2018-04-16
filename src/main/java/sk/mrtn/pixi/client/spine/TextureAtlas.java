package sk.mrtn.pixi.client.spine;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.safehtml.shared.SafeUri;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.BaseTexture;

import java.util.Map;
import java.util.logging.Logger;

@JsType(isNative = true, namespace = "PIXI.spine.core")
public class TextureAtlas {

    @FunctionalInterface
    @JsFunction
    public interface IOnTextureAtlasLoaded {
        void call(String resourceLine, ICallback callback);
    }

    @FunctionalInterface
    @JsFunction
    private interface ICallback {
        void call(BaseTexture o);
    }

    @JsConstructor
    public TextureAtlas(String rawAtlasData, IOnTextureAtlasLoaded onTextureLoaded){}

    @JsOverlay
    public static final TextureAtlas create(final String rawAtlasData, final Map<String, SafeUri> rawAtlasDataImageMap) {
        return Statics.create(rawAtlasData, rawAtlasDataImageMap);
    }
    public static class Statics {

        /**
         * Create Atlas using rawAtlasData what is content of  *.atlas file and list of links to appropriate images that are named in that *.atlas file
         * @param rawAtlasData
         * @param rawAtlasDataImageMap
         * @return
         */
        public static TextureAtlas create(final String rawAtlasData, final Map<String, SafeUri> rawAtlasDataImageMap) {


            return new TextureAtlas(rawAtlasData, new IOnTextureAtlasLoaded() {
                @Override
                public void call(String resourceLine, ICallback callback) {
                    SafeUri safeUri = rawAtlasDataImageMap.get(resourceLine);
                    Logger.getLogger("test").severe("Spine Atlas resource line: "+ resourceLine + " res: " + safeUri);
                    callback.call(BaseTexture.fromImage(safeUri.asString()));
                }
            });



//            return create(rawAtlasData, toJsObject(rawAtlasDataImageMap));
        }

        private static native TextureAtlas create(final String rawAtlasData, final JavaScriptObject rawAtlasDataImageList) /*-{

        var functionTest = function(line, callback) {

                var resourceUrl = rawAtlasDataImageList[line];
//                $wnd.console.log("Spine Atlas resource line: "+ line + " res: " + resourceUrl);
                callback($wnd.PIXI.BaseTexture.fromImage(resourceUrl));
            }
            $wnd.console.log("Test", functionTest);


            return new $wnd.PIXI.spine.core.TextureAtlas(rawAtlasData, functionTest);
        }-*/;

        private static JavaScriptObject toJsObject(Map<String, SafeUri> input) {
            JSONObject jsonObject = new JSONObject();

            for ( String imageKey : input.keySet() ) {
                JSONString jsonString = new JSONString(input.get(imageKey).asString());
                jsonObject.put(imageKey, jsonString);
            }
            return jsonObject.getJavaScriptObject();
        }
    }
}
