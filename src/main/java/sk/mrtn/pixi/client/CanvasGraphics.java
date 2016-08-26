package sk.mrtn.pixi.client;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 20/08/16.
 * A set of functions used by the canvas renderer to draw the primitive graphics data.
 * All detected method undocumented
 */
@JsType(isNative = true)
public class CanvasGraphics {

    // PUBLIC FIELDS

    // PUBLIC METHODS
    @JsMethod
    public native Object renderGraphics(Object graphics, Object context);
    @JsMethod
    public native Object renderGraphicsMask(Object graphics, Object context);
    @JsMethod
    public native Object updateGraphicsTint(Object graphics);

}
