package sk.mrtn.pixi.client.filters;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.Filter;

/**
 * Created by klaun on 27/08/16.
 * A Noise effect filter.
 */

@JsType(isNative = true, namespace = "PIXI.filters")
public class NoiseFilter extends Filter {

    /**
     * The amount of noise to apply.
     */
    @JsProperty
    public double noise;

    @JsConstructor
    public NoiseFilter(){}

}
