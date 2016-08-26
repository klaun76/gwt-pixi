package sk.mrtn.pixi.client.extras;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 19/08/16.
 */
@JsType(isNative = true, namespace = "PIXI.extras")
public class TilingSprite {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS
    @JsMethod
    public static native Object fromFrame(Object frameId, Object width, Object height);
    @JsMethod
    public static native Object fromImage(Object imageId, Object width, Object height, Object crossorigin, Object scaleMode);

    @JsConstructor
    public TilingSprite(Object texture, Object width, Object height){};

}