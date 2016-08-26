package sk.mrtn.pixi.client;

import elemental.html.CanvasElement;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 20/08/16.
 * TODO: check if this solution was good one
 */

@JsType
public class Options {

    @JsProperty
    private final CanvasElement view;
    @JsProperty
    private final boolean transparent;
    @JsProperty
    private final boolean antialias;
    @JsProperty
    private final boolean preserveDrawingBuffer;
    @JsProperty
    private final double resolution;

    Options(
            CanvasElement view,
            boolean transparent,
            boolean antialias,
            boolean preserveDrawingBuffer,
            double resolution
    ){
        this.view = view;
        this.transparent = transparent;
        this.antialias = antialias;
        this.preserveDrawingBuffer = preserveDrawingBuffer;
        this.resolution = resolution;
    }
}
