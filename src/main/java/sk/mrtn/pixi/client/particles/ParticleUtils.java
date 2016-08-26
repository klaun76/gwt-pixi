package sk.mrtn.pixi.client.particles;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.Point;

/**
 * Created by klaun on 25/04/16.
 */

@JsType(isNative = true, namespace = "PIXI.particles")
public class ParticleUtils {


    // PUBLIC FIELDS
    @JsProperty
    public double DEG_TO_RADS;
    @JsProperty
    public boolean useAPI3;

    // PUBLIC METHODS

    /**
     * Rotates a point by a given angle.
     * @param angle
     * @param point
     */
    @JsMethod
    public native void rotatePoint(double angle, Point point);

    /**
     * Combines separate color components (0-255) into a single uint color.
     * @param red
     * @param green
     * @param blue
     * @return
     */
    @JsMethod
    public native int combineRGBComponents(int red, int green, int blue);

    /**
     * Reduces the point to a length of 1.
     * @param point
     * @return
     */
    @JsMethod
    public native void normalize(Point point);

    /**
     * Multiplies the x and y values of this point by point value.
     * @param point
     * @param value
     * @return
     */
    @JsMethod
    public native void scaleBy(Point point, double value);

    /**
     * Returns the length (or magnitude) of this point.
     * @param point
     * @return
     */
    @JsMethod
    public native double length(Point point);

    /**
     * Converts a hex string from "#AARRGGBB", "#RRGGBB", "0xAARRGGBB", "0xRRGGBB",
     * "AARRGGBB", or "RRGGBB" to an array of ints of 0-255 or Numbers from 0-1, as [r, g, b, (a)].
     * @param color
     * @return
     */
    @JsMethod
    public native Integer[] hexToRGB(String color);

    /**
     * TODO: create interface/class
     * method not tested yet
     * @param segments
     * @return
     */
    @JsMethod
    public native Object generateEase(Object segments);

    /**
     * method not tested yet
     * @param name
     * @return
     */
    @JsMethod
    public native Integer getBlendMode(String name);

}
