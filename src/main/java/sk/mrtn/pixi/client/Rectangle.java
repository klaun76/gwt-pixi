package sk.mrtn.pixi.client;

import jsinterop.annotations.*;

/**
 * Created by klaun on 20/08/16.
 * the Rectangle object is an area defined by its position,
 * as indicated by its top-left corner point (x, y) and by its width and its height.
 * @see <a href="https://pixijs.github.io/docs/PIXI.Rectangle.html">Rectangle</a>
 */

@JsType(isNative = true, namespace = "PIXI")
public class Rectangle implements IShape {

    /**
     * A constant empty rectangle.
     */
    @JsProperty
    public static Rectangle EMPTY;
    // PUBLIC FIELDS
    @JsProperty
    public int x;
    @JsProperty
    public int y;
    @JsProperty
    public int width;
    @JsProperty
    public int height;
    /**
     * The type of the object, mainly used to avoid instanceof checks
     * default CONST.SHAPES.RECT
     */
    @JsProperty
    public int type;

    /**
     * @param x The X coordinate of the upper-left corner of the rectangle
     * @param y The Y coordinate of the upper-left corner of the rectangle
     * @param width The overall width of this rectangle
     * @param height The overall height of this rectangle
     */
    @JsConstructor
    public Rectangle(double x, double y, double width, double height){}

    // PUBLIC METHODS

    /**
     * Creates a clone of this Rectangle
     * @return a copy of the rectangle
     */
    @JsMethod
    public native Rectangle clone();

    /**
     * Checks whether the x and y coordinates given are contained within this Rectangle
     * @param x The X coordinate of the point to test
     * @param y The Y coordinate of the point to test
     * @return Whether the x/y coordinates are within this Rectangle
     */
    @JsMethod
    public native boolean contains(double x, double y);

    @JsOverlay
    public final String toString() {
        return "Rectangle {x: "+x+", y: "+y+", width: "+width+", height: "+height+"}";
    }
}
