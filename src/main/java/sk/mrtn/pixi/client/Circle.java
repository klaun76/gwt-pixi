package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 20/08/16.
 */

@JsType(isNative = true, namespace = "PIXI")
public class Circle implements IShape{

    @JsConstructor
    public Circle(double x, double y, double radius){};

    // PUBLIC FIELDS
    @JsProperty
    public int x;
    @JsProperty
    public int y;
    @JsProperty
    public int radius;
    @JsProperty
    public int type;

    // PUBLIC METHODS
    @JsMethod
    public native Circle clone();
    @JsMethod
    public native boolean contains(double x, double y);
    @JsMethod
    public native Rectangle getBounds();

}
