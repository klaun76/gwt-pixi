package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 20/08/16.
 */

@JsType(isNative = true, namespace = "PIXI")
public class Rectangle implements IShape {

    @JsProperty
    public static Rectangle EMPTY;

    @JsConstructor
    public Rectangle(double x, double y, double width, double height){};

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
    public native Rectangle clone();
    @JsMethod
    public native boolean contains(double x, double y);


}
