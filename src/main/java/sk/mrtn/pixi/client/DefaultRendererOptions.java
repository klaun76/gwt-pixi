package sk.mrtn.pixi.client;

import elemental.html.CanvasElement;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 20/08/16.
 */
@JsType(isNative = true)
public class DefaultRendererOptions {

    // PUBLIC FIELDS
    @JsProperty
    public CanvasElement view;
    @JsProperty
    public int resolution;
    @JsProperty
    public boolean antialias;
    @JsProperty
    public boolean forceFXAA;
    @JsProperty
    public boolean autoResize;
    @JsProperty
    public boolean transparent;
    @JsProperty
    public int backgroundColor;
    @JsProperty
    public boolean clearBeforeRender;
    @JsProperty
    public boolean preserveDrawingBuffer;
    @JsProperty
    public boolean roundPixels;

    // PUBLIC METHODS

}