package sk.mrtn.pixi.client.particles.config;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 22/08/16.
 */
@JsType(isNative = true)
public class StartRotation {

    @JsProperty
    public Double min;

    @JsProperty
    public Double max;

}
