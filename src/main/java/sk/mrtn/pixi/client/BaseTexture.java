package sk.mrtn.pixi.client;

import elemental.html.CanvasElement;
import elemental.html.ImageElement;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 19/08/16.
 */
@JsType(isNative = true, namespace = "PIXI")
public class BaseTexture {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    @JsMethod
    public static native BaseTexture fromImage(String  imageUrl, boolean crossorigin, Double scaleMode);
    @JsMethod
    public static native BaseTexture fromCanvas(CanvasElement canvas, Double scaleMode);

    @JsConstructor
    public BaseTexture(CanvasElement source){};

    @JsConstructor
    public BaseTexture(ImageElement source){};

    @JsConstructor
    public BaseTexture(CanvasElement source, Double scaleMode, Double resolution){};

    @JsConstructor
    public BaseTexture(ImageElement source, Double scaleMode, Double resolution){};

}