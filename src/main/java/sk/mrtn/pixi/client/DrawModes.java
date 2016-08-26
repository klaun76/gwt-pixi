package sk.mrtn.pixi.client;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 20/08/16.
 */
@JsType(isNative = true)
public class DrawModes {

    // PUBLIC FIELDS
    @JsProperty
    public int POINTS;
    @JsProperty
    public int LINES;
    @JsProperty
    public int LINE_LOOP;
    @JsProperty
    public int LINE_STRIP;
    @JsProperty
    public int TRIANGLES;
    @JsProperty
    public int TRIANGLE_STRIP;
    @JsProperty
    public int TRIANGLE_FAN;

    // PUBLIC METHODS

}