package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 12/09/16.
 * The Point object represents a location in a two-dimensional
 * coordinate system, where x represents the horizontal axis
 * and y represents the vertical axis.
 * An observable point is a point that triggers a callback when
 * the point's position is changed.
 * @see <a href="https://pixijs.github.io/docs/PIXI.ObservablePoint.html">ObservablePoint</a>
 * TODO: create test for callback and scope
 */
@JsType(isNative = true, namespace = "PIXI")
public class ObservablePoint {

    /**
     * The position of the displayObject on the x axis
     * relative to the local coordinates of the parent.
     */
    @JsProperty
    public double x;

    /**
     * The position of the displayObject on the x axis
     * relative to the local coordinates of the parent.
     */
    @JsProperty
    public double y;

    /**
     *
     * @param callback - callback when changed
     * @param scope - owner of callback
     * @param x - position of the point on the x axis
     * @param y - position of the point on the y axis
     */
    @JsConstructor
    public ObservablePoint(Object callback, Object scope, double x, double y){}

    /**
     * Copies the data from another point
     * @param point - point to copy from
     * @return
     */
    @JsMethod
    public native Point copy(Point point);

    /**
     * Copies the data from another point
     * @param point - point to copy from
     * @return
     */
    @JsMethod
    public native Point copy(ObservablePoint point);

    /**
     * Sets the point to a new x and y position.
     * If y is omitted, both x and y will be set to x.
     * @param x - position of the point on the x axis
     * @param y - position of the point on the y axis
     */
    @JsMethod
    public native void set(double x, double y);

}
