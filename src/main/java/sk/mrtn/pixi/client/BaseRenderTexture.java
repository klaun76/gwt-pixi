package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 19/08/16.
 */
@JsType(isNative = true, namespace = "PIXI")
public class BaseRenderTexture {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    // PUBLIC FIELDS
    @JsProperty
    public int uid;
    @JsProperty
    public int touched;
    @JsProperty
    public int resolution;
    @JsProperty
    public int width;
    @JsProperty
    public int height;
    @JsProperty
    public double realWidth;
    @JsProperty
    public double realHeight;
    @JsProperty
    public int scaleMode;
    @JsProperty
    public boolean hasLoaded;
    @JsProperty
    public boolean isLoading;
    @JsProperty
    public Object source;
    @JsProperty
    public boolean premultipliedAlpha;
    @JsProperty
    public Object imageUrl;
    @JsProperty
    public boolean isPowerOfTwo;
    @JsProperty
    public boolean mipmap;
    @JsProperty
    public int wrapMode;
    @JsProperty
    public boolean valid;

    // PUBLIC METHODS
    @JsMethod
    public native void resize(Double width, Double height);
    @JsMethod
    public native void destroy();

    @JsConstructor
    public BaseRenderTexture(Double width, Double height){};

}