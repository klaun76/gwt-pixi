package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 20/08/16.
 */

@JsType(isNative = true, namespace = "PIXI")
public class Texture {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS
    @JsMethod
    public static native Texture fromImage(String imageUrl);
    @JsMethod
    public static native Texture fromImage(String imageUrl, boolean crossorigin);
    @JsMethod
    public static native Texture fromImage(String imageUrl, boolean crossorigin, int scaleMode);
    @JsMethod
    public static native Texture fromFrame(Object frameId);
    @JsMethod
    public static native Texture fromCanvas(Object canvas, Object scaleMode);
    @JsMethod
    public static native Texture fromVideo(Object video, Object scaleMode);
    @JsMethod
    public static native Texture fromVideoUrl(Object videoUrl, Object scaleMode);
    @JsMethod
    public static native Texture addTextureToCache(Object texture, Object id);
    @JsMethod
    public static native Texture removeTextureFromCache(Object id);

    @JsConstructor
    public Texture(Object baseTexture, Object frame, Object crop, Object trim, Object rotate){};

}
