package sk.mrtn.pixi.client;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 20/08/16.
 * Constants that identify shapes, mainly to prevent instanceof calls.
 * @see <a href="https://pixijs.github.io/docs/PIXI.html#.SHAPES">SHAPES</a>
 */
@JsType(isNative = true)
public class Shapes {

    @JsProperty
    public int POLY;
    @JsProperty
    public int RECT;
    @JsProperty
    public int CIRC;
    @JsProperty
    public int ELIP;
    @JsProperty
    public int RREC;

}