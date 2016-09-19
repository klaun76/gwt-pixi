package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 21/08/16.
 * The Graphics class contains methods used to draw primitive shapes such as lines, circles and
 * rectangles to the display, and to color and fill them.
 * @see <a href="https://pixijs.github.io/docs/PIXI.Graphics.html">Graphics</a>
 */

@JsType(isNative = true, namespace = "PIXI")
public class Graphics extends Container {

    @JsConstructor
    public Graphics(){};

    /**
     * The alpha value used when filling the Graphics object. (Default 1)
     */
    @JsProperty
    public double fillAlpha;

    /**
     * The width (thickness) of any lines drawn. (Default 0)
     */
    @JsProperty
    public int lineWidth;

    /**
     * The color of any lines drawn.
     */
    @JsProperty
    public String lineColor;

    /**
     * The tint applied to the graphic shape. This is a hex value.
     * Apply a value of 0xFFFFFF to reset the tint.
     */
    @JsProperty
    public int tint;

    /**
     * The blend mode to be applied to the sprite.
     * Apply a value of PIXI.BLEND_MODES.NORMAL to reset the blend mode.
     * {@link sk.mrtn.pixi.client.BlendModes}
     * TODO:test functionality
     */
    @JsProperty
    public int blendMode;

    /**
     * Whether this shape is being used as a mask.
     */
    @JsProperty
    public boolean isMask;

    /**
     * The bounds' padding used for bounds calculation.
     */
    @JsProperty
    public int boundsPadding;

    /**
     * Used to detect if we we need to recalculate local bounds
     * TOTO: check if boolean or number, according to docs its number
     */
    @JsProperty
    public boolean boundsDirty;

    /**
     * Used to detect if we clear the graphics webGL data
     */
    @JsProperty
    public double clearDirty;

    /**
     * Used to detect if we need to do a fast rect check using the id compare method
     */
    @JsProperty
    public double fastRectDirty;

    // PUBLIC METHODS

    /**
     * Retrieves the bounds of the graphic shape as a rectangle object
     * @param matrix The world transform matrix to use, defaults to this
     *               object's worldTransform.
     * @return the rectangular bounding area
     */
    @JsMethod
    public native Rectangle _calculateBounds(Rectangle matrix);

    /**
     * Retrieves the bounds of the graphic shape as a rectangle object
     * @return the rectangular bounding area
     */
    @JsMethod
    public native Rectangle _calculateBounds();

    /**
     * Creates a new Graphics object with the same values as this one.
     * Note that the only the properties of the object are cloned, not its transform (position,scale,etc)
     * @return 	A clone of the graphics object
     */
    @JsMethod
    public native Graphics clone();

    /**
     * Specifies the line style used for subsequent calls to
     * Graphics methods such as the lineTo() method or the drawCircle() method.
     * @param lineWidth width of the line to draw, will update the objects stored style
     * @param color color of the line to draw, will update the objects stored style
     * @param alpha alpha of the line to draw, will update the objects stored style
     * @return
     */
    @JsMethod
    public native Graphics lineStyle(Double lineWidth, Double color, Double alpha);
    @JsMethod
    public native Graphics lineStyle(Double lineWidth);

    /**
     * Moves the current drawing position to x, y.
     * @param x the X coordinate to move to
     * @param y the Y coordinate to move to
     * @return
     */
    @JsMethod
    public native Graphics moveTo(double x, double y);

    /**
     * Draws a line using the current line style from the current drawing position to (x, y);
     * The current drawing position is then set to (x, y).
     * @param x the X coordinate to draw to
     * @param y the Y coordinate to draw to
     * @return
     */
    @JsMethod
    public native Graphics lineTo(double x, double y);

    /**
     * Calculate the points for a quadratic bezier curve and then draws it.
     * Based on: https://stackoverflow.com/questions/785097/how-do-i-implement-a-bezier-curve-in-c
     * @param cpX Control point x
     * @param cpY Control point y
     * @param toX Destination point x
     * @param toY Destination point y
     * @return
     */
    @JsMethod
    public native Graphics quadraticCurveTo(double cpX, double cpY, double toX, double toY);

    /**
     * Calculate the points for a bezier curve and then draws it.
     * @param cpX Control point x
     * @param cpY Control point y
     * @param cpX2 Second Control point x
     * @param cpY2 Second Control point y
     * @param toX Destination point x
     * @param toY Destination point y
     * @return This Graphics object. Good for chaining method calls
     */
    @JsMethod
    public native Graphics bezierCurveTo(double cpX, double cpY, double cpX2, double cpY2, double toX, double toY);

    /**
     * The arcTo() method creates an arc/curve between two tangents on the canvas.
     * "borrowed" from https://code.google.com/p/fxcanvas/ - thanks google!
     * @param x1 The x-coordinate of the beginning of the arc
     * @param y1 The y-coordinate of the beginning of the arc
     * @param x2 The x-coordinate of the end of the arc
     * @param y2 The y-coordinate of the end of the arc
     * @param radius The radius of the arc
     * @return This Graphics object. Good for chaining method calls
     */
    @JsMethod
    public native Graphics arcTo(double x1, double y1, double x2, double y2, double radius);

    /**
     * The arc method creates an arc/curve (used to create circles, or parts of circles).
     * @param cx The x-coordinate of the center of the circle
     * @param cy The y-coordinate of the center of the circle
     * @param radius The radius of the circle
     * @param startAngle The starting angle, in radians (0 is at the 3 o'clock position of the arc's circle)
     * @param endAngle The ending angle, in radians
     * @param anticlockwise Specifies whether the drawing should be counterclockwise or clockwise.
     *                      False is default, and indicates clockwise, while true indicates counter-clockwise.
     * @return This Graphics object. Good for chaining method calls
     */
    @JsMethod
    public native Graphics arc(double cx, double cy, double radius, double startAngle, double endAngle, Boolean anticlockwise);

    /**
     * Specifies a simple one-color fill that subsequent calls to other Graphics methods
     * (such as lineTo() or drawCircle()) use when drawing.
     * @param color the color of the fill
     * @param alpha the alpha of the fill
     * @return This Graphics object. Good for chaining method calls
     */
    @JsMethod
    public native Graphics beginFill(double color, double alpha);

    /**
     * Applies a fill to the lines and shapes that were added since the last call to the beginFill() method.
     * @return
     */
    @JsMethod
    public native Graphics endFill();

    /**
     * @param x The X coord of the top-left of the rectangle
     * @param y The Y coord of the top-left of the rectangle
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     * @return
     */
    @JsMethod
    public native Graphics drawRect(double x, double y, double width, double height);

    /**
     * @param x The X coord of the top-left of the rectangle
     * @param y The Y coord of the top-left of the rectangle
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     * @param radius Radius of the rectangle corners
     * @return
     */
    @JsMethod
    public native Graphics drawRoundedRect(double x, double y, double width, double height, double radius);

    /**
     * Draws a circle.
     * @param x The X coordinate of the center of the circle
     * @param y The Y coordinate of the center of the circle
     * @param radius
     * @return
     */
    @JsMethod
    public native Graphics drawCircle(double x, double y, double radius);

    /**
     * Draws an ellipse.
     * @param x The X coordinate of the center of the ellipse
     * @param y The Y coordinate of the center of the ellipse
     * @param width The half width of the ellipse
     * @param height The half height of the ellipse
     * @return
     */
    @JsMethod
    public native Graphics drawEllipse(double x, double y, double width, double height);

    /**
     * Draws a polygon using the given path.
     * @param path The path data used to construct the polygon.
     * @return
     */
    @JsMethod
    public native Graphics drawPolygon(Point[] path);

    @JsMethod
    public native Graphics drawPolygon(Double[] path);

    /**
     * Clears the graphics that were drawn to this Graphics object,
     * and resets fill and line style settings.
     * @return
     */
    @JsMethod
    public native Graphics clear();

    /**
     * Tests if a point is inside this graphics object
     * @param point the point to test
     * @return the result of the test
     */
    @JsMethod
    public native boolean containsPoint(Point point);

    /**
     * Update the bounds of the object
     */
    @JsMethod
    public native void updateLocalBounds();

    /**
     * True if graphics consists of one rectangle, and thus, can
     * be drawn like a Sprite and masked with gl.scissor
     * @return
     */
    @JsMethod
    public native boolean isFastRect();

    /**
     * Draws the given shape to this Graphics object. Can be any
     * of Circle, Rectangle, Ellipse, Line or Polygon.
     * @param shape
     * @return
     */
    @JsMethod
    public native GraphicsData drawShape(IShape shape);

}
