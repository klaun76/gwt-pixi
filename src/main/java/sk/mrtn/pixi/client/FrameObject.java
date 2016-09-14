package sk.mrtn.pixi.client;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 14/09/16.
 * @see <a href="https://pixijs.github.io/docs/global.html#FrameObject">FrameObject</a>
 */
@JsType(isNative = true)
public class FrameObject {

    /**
     * The PIXI.Texture of the frame
     */
    @JsProperty
    public Texture texture;

    /**
     * the duration of the frame in ms
     */
    @JsProperty
    public double time;
}
