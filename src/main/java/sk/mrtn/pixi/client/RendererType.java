package sk.mrtn.pixi.client;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 20/08/16.
 */
@JsType(isNative = true)
public class RendererType {

    // PUBLIC FIELDS
    @JsProperty
    public int UNKNOWN;
    @JsProperty
    public int WEBGL;
    @JsProperty
    public int CANVAS;

    // PUBLIC METHODS

}