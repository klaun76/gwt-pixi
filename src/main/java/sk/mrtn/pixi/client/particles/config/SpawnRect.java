package sk.mrtn.pixi.client.particles.config;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 22/08/16.
 */
@JsType(isNative = true)
public class SpawnRect extends Position {

    @JsProperty
    public Double w;

    @JsProperty
    public Double h;

}
