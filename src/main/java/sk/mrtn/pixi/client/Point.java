package sk.mrtn.pixi.client;

import jsinterop.annotations.*;

/**
 * Created by klaun on 20/08/16.
 */

@JsType(isNative = true, namespace = "PIXI")
public class Point {

    @JsConstructor
    public Point(double x, double y){};

    // PUBLIC FIELDS
    @JsProperty
    public double x;
    @JsProperty
    public double y;

    // PUBLIC METHODS
    @JsMethod
    public native Point clone();
    @JsMethod
    public native Point copy(Point point);
    @JsMethod
    public native boolean equals(Point point);
    @JsMethod
    public native void set(double x, double y);

    @JsOverlay
    public final String toString() {
        return "Point {x: "+x+", y: "+y+"}";
    }
}
