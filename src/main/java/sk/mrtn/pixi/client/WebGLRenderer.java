package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 20/08/16.
 */

@JsType(isNative = true, namespace = "PIXI")
public class WebGLRenderer {

    // PUBLIC STATIC FIELDS
    @JsProperty
    public static int glContextId;

    // PUBLIC STATIC METHODS
    @JsMethod
    public static native Object registerPlugin(Object pluginName, Object ctor);

    @JsConstructor
    public WebGLRenderer(double width, double height, Object options){};

}
