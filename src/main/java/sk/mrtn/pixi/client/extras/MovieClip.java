package sk.mrtn.pixi.client.extras;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 19/08/16.
 */
@JsType(isNative = true, namespace = "PIXI.extras")
public class MovieClip {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS
    @JsMethod
    public static native Object fromFrames(Object frames);
    @JsMethod
    public static native Object fromImages(Object images);

    @JsConstructor
    public MovieClip(Object textures){};

}
