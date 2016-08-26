package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 20/08/16.
 */

@JsType(isNative = true, namespace = "PIXI")
public class Ellipse implements IShape {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    @JsConstructor
    public Ellipse(double x, double y, double width, double height){};

    // PUBLIC FIELDS
    @JsProperty
    public int x;
    @JsProperty
    public int y;
    @JsProperty
    public int width;
    @JsProperty
    public int height;
    @JsProperty
    public int type;

    // PUBLIC METHODS
    @JsMethod
    public native Ellipse clone();
    @JsMethod
    public native boolean contains(double x, double y);
    @JsMethod
    public native Rectangle getBounds();

}
