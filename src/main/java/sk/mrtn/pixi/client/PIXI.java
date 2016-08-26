package sk.mrtn.pixi.client;

import jsinterop.annotations.*;
import sk.mrtn.pixi.client.ticker.Ticker;

/**
 * Created by klaun on 20/08/16.
 */

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class PIXI {

    // PUBLIC FIELDS
    @JsProperty
    public String VERSION;
    @JsProperty
    public double PI_2;
    @JsProperty
    public double RAD_TO_DEG;
    @JsProperty
    public double DEG_TO_RAD;
    @JsProperty
    public double TARGET_FPMS;
    @JsProperty
    public RendererType RENDERER_TYPE;
    @JsProperty
    public BlendModes BLEND_MODES;
    @JsProperty
    public DrawModes DRAW_MODES;
    @JsProperty
    public ScaleModes SCALE_MODES;
    @JsProperty
    public String RETINA_PREFIX;
    @JsProperty
    public int RESOLUTION;
    @JsProperty
    public int FILTER_RESOLUTION;
    @JsProperty
    public DefaultRendererOptions DEFAULT_RENDER_OPTIONS;
    @JsProperty
    public Shapes SHAPES;
    @JsProperty
    public int SPRITE_BATCH_SIZE;
    @JsProperty
    public GroupD8 GroupD8;
    @JsProperty
    public Ticker ticker;
    @JsProperty
    public CanvasGraphics CanvasGraphics;
    @JsProperty
    public Object mesh;
    @JsProperty
    public Object accessibility;
    @JsProperty
    public Object loader;

    // PUBLIC METHODS
    @JsMethod
    public native Renderer autoDetectRenderer(double width, double height);
    @JsMethod
    public native Renderer autoDetectRenderer(double width, double height, Options options);
    @JsMethod
    public native Renderer autoDetectRenderer(double width, double height, Options options, boolean noWebGL);

}
