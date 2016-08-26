package sk.mrtn.pixi.client;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.Matrix;

/**
 * Created by klaun on 20/08/16.
 */

@JsType(isNative = true)
public class GroupD8 {


    // PUBLIC FIELDS
    @JsProperty
    public int E;
    @JsProperty
    public int SE;
    @JsProperty
    public int S;
    @JsProperty
    public int SW;
    @JsProperty
    public int W;
    @JsProperty
    public int NW;
    @JsProperty
    public int N;
    @JsProperty
    public int NE;
    @JsProperty
    public int MIRROR_VERTICAL;
    @JsProperty
    public int MIRROR_HORIZONTAL;

    // PUBLIC METHODS
    @JsMethod
    public native int uX(int ind);
    @JsMethod
    public native int uY(int ind);
    @JsMethod
    public native int vX(int ind);
    @JsMethod
    public native int vY(int ind);
    @JsMethod
    public native double inv(double rotation);
    @JsMethod
    public native int add(int rotationSecond, int rotationFirst);
    @JsMethod
    public native int sub(int rotationSecond, int rotationFirst);
    @JsMethod
    public native double rotate180(double rotation);
    @JsMethod
    public native boolean isSwapWidthHeight(double rotation);
    @JsMethod
    public native int byDirection(double dx, double dy);
    @JsMethod
    public native void matrixAppendRotationInv(Matrix matrix, double rotation, double tx, double ty);

}
