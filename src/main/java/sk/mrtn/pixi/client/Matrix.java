package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 21/08/16.
 */

@JsType(isNative = true, namespace = "PIXI")
public class Matrix {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    @JsConstructor
    public Matrix(){};

    // PUBLIC FIELDS
    @JsProperty
    public int a;
    @JsProperty
    public int b;
    @JsProperty
    public int c;
    @JsProperty
    public int d;
    @JsProperty
    public int tx;
    @JsProperty
    public int ty;

    // PUBLIC METHODS
    @JsMethod
    public native Matrix fromArray(int[] array);

    // UNDOCUMENTED
    @JsMethod
    public native Matrix set(int a, int b, int c, int d, int tx, int ty);
    @JsMethod
    public native int[] toArray(boolean transpose);
    @JsMethod
    public native Point apply(Point pos, Point newPos);
    @JsMethod
    public native Point applyInverse(Point pos, Point newPos);
    @JsMethod
    public native Matrix translate(double x, double y);
    @JsMethod
    public native Matrix scale(double x, double y);
    @JsMethod
    public native Matrix rotate(double angle);
    @JsMethod
    public native Matrix append(Matrix matrix);
    // UNDOCUMENTED
    @JsMethod
    public native Matrix setTransform(double x, double y, double pivotX, double pivotY, double scaleX, double scaleY, double rotation, double skewX, double skewY);
    @JsMethod
    public native Matrix prepend(Matrix matrix);
    @JsMethod
    public native Matrix invert();
    @JsMethod
    public native Matrix identity();
    @JsMethod
    public native Matrix clone();
    @JsMethod
    public native Matrix copy(Matrix matrix);

}
