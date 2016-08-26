package sk.mrtn.pixi.client;

import elemental.html.CanvasElement;
import elemental.html.CanvasRenderingContext2D;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 20/08/16.
 * PIXI.CanvasRenderer and PIXI.WebGLRenderer
 * have similar interfaces and functionality
 * TODO: CONTROLL ALL FIELDS AND METHODS
 */

@JsType(isNative = true, namespace = "PIXI")
public class Renderer {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    @JsConstructor
    public Renderer(double width, double height, Options options){};
    @JsConstructor
    public Renderer(double width, double height){};
    @JsConstructor
    public Renderer(){};

    // PUBLIC FIELDS
    @JsProperty
    public int type;
    @JsProperty
    public double width;
    @JsProperty
    public double height;
    @JsProperty
    public CanvasElement view;
    @JsProperty
    public int resolution;
    @JsProperty
    public boolean transparent;
    @JsProperty
    public boolean autoResize;
    @JsProperty
    public BlendModes blendModes;
    @JsProperty
    public boolean preserveDrawingBuffer;
    @JsProperty
    public boolean clearBeforeRender;
    @JsProperty
    public boolean roundPixels;
    @JsProperty
    public CanvasRenderingContext2D context;
    @JsProperty
    public boolean refresh;
    // documented as PIXI.CanvasMaskManager. Not found
    @JsProperty
    public Object maskManager;
    @JsProperty
    public String smoothProperty;
    @JsProperty
    public Object plugins;

    // PUBLIC METHODS
    // UNDOCUMENTED
    @JsMethod
    public native void initPlugins();
    // UNDOCUMENTED
    @JsMethod
    public native void destroyPlugins();

    @JsMethod
    public native void render(DisplayObject object);
    @JsMethod
    public native void destroy(boolean removeView);
    @JsMethod
    public native void renderDisplayObject(DisplayObject displayObject, CanvasRenderingContext2D context);
    @JsMethod
    public native void resize(double w, double h);

}
