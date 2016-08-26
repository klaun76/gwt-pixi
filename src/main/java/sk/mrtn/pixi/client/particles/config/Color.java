package sk.mrtn.pixi.client.particles.config;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 22/08/16.
 */
@JsType(isNative = true)
public class Color {

    @JsProperty
    public String start;

    @JsProperty
    public String end;

}
