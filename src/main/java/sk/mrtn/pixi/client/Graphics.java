package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 21/08/16.
 */

@JsType(isNative = true, namespace = "PIXI")
public class Graphics extends Container {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    @JsConstructor
    public Graphics(){};


    // PUBLIC FIELDS
    @JsProperty
    public int fillAlpha;
    @JsProperty
    public int lineWidth;
    @JsProperty
    public int lineColor;
    @JsProperty
    public GraphicsData graphicsData;
    @JsProperty
    public int tint;
    @JsProperty
    public int blendMode;
    // UNDOCUMENTED
    @JsProperty
    public String currentPath;
    @JsProperty
    public boolean isMask;
    @JsProperty
    public int boundsPadding;
    @JsProperty
    public boolean dirty;
    @JsProperty
    public boolean glDirty;
    @JsProperty
    public boolean boundsDirty;
    @JsProperty
    public boolean cachedSpriteDirty;

    // PUBLIC METHODS
    @JsMethod
    public native Graphics clone();
    @JsMethod
    public native Graphics lineStyle(double lineWidth, double color, double alpha);
    @JsMethod
    public native Graphics moveTo(double x, double y);
    @JsMethod
    public native Graphics lineTo(double x, double y);
    @JsMethod
    public native Graphics quadraticCurveTo(double cpX, double cpY, double toX, double toY);
    @JsMethod
    public native Graphics bezierCurveTo(double cpX, double cpY, double cpX2, double cpY2, double toX, double toY);
    @JsMethod
    public native Graphics arcTo(double x1, double y1, double x2, double y2, double radius);
    @JsMethod
    public native Graphics arc(double cx, double cy, double radius, double startAngle, double endAngle, boolean anticlockwise);
    @JsMethod
    public native Graphics beginFill(double color, double alpha);
    @JsMethod
    public native Graphics endFill();
    @JsMethod
    public native Graphics drawRect(double x, double y, double width, double height);
    @JsMethod
    public native Graphics drawRoundedRect(double x, double y, double width, double height, double radius);
    @JsMethod
    public native Graphics drawCircle(double x, double y, double radius);
    @JsMethod
    public native Graphics drawEllipse(double x, double y, double width, double height);
    @JsMethod
    public native Graphics drawPolygon(Object path);
    @JsMethod
    public native Graphics clear();
    @JsMethod
    public native Rectangle getBounds(Matrix matrix);
    @JsMethod
    public native boolean containsPoint(Point point);
    @JsMethod
    public native void updateLocalBounds();
    @JsMethod
    public native GraphicsData drawShape(IShape shape);

}
