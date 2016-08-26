package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.interaction.ClickEventHandler;
import sk.mrtn.pixi.client.interaction.MouseDownEventHandler;

/**
 * Created by klaun on 20/08/16.
 */
@JsType(isNative = true, namespace = "PIXI")
public abstract class DisplayObject {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    @JsConstructor
    public DisplayObject(){};

    // PUBLIC FIELDS
    @JsProperty
    public Point position;
    @JsProperty
    public Point scale;
    @JsProperty
    public Point pivot;
    // UNDOCUMENTED
    @JsProperty
    public Point skew;
    @JsProperty
    public int rotation;
    @JsProperty
    public int alpha;
    @JsProperty
    public boolean visible;
    @JsProperty
    public boolean renderable;
    @JsProperty
    public Container parent;
    @JsProperty
    public int worldAlpha;
    @JsProperty
    public Matrix worldTransform;
    @JsProperty
    public Rectangle filterArea;
    // UNDOCUMENTED
    @JsProperty
    public String name;
    @JsProperty
    public boolean interactive;
    @JsProperty
    public boolean buttonMode;
    @JsProperty
    public boolean interactiveChildren;
    @JsProperty
    public String defaultCursor;
    @JsProperty
    public boolean accessible;
    @JsProperty
    public Object accessibleTitle;
    @JsProperty
    public int tabIndex;

    // TODO: skonzultovat s tomaskom co dalej tu
    @JsProperty
    public MouseDownEventHandler mousedown;

    @JsProperty
    public ClickEventHandler click;

    // PUBLIC METHODS
    @JsMethod
    public native void updateTransform();
    @JsMethod
    public native void displayObjectUpdateTransform();
    @JsMethod
    public native Rectangle getBounds(Rectangle matrix);
    @JsMethod
    public native Rectangle getLocalBounds();
    @JsMethod
    public native Point toGlobal(Point position);
    @JsMethod
    public native Point toLocal(Point position, DisplayObject from, Point point);
    @JsMethod
    public native void renderWebGL(Renderer renderer);
    @JsMethod
    public native void renderCanvas(Renderer renderer);
    @JsMethod
    public native Texture generateTexture(Renderer renderer, double scaleMode, double resolution);
    @JsMethod
    public native Container setParent(Container container);
    @JsMethod
    public native boolean setTransform(double x, double y, double scaleX, double scaleY, double rotation, double skewX, double skewY, double pivotX, double pivotY);
    @JsMethod
    public native void destroy();
    @JsMethod
    public native Point getGlobalPosition(Point point);

}
