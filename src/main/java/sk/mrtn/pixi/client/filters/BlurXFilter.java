package sk.mrtn.pixi.client.filters;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.Filter;

/**
 * Created by klaun on 27/08/16.
 * The BlurXFilter applies a horizontal Gaussian blur to an object.
 */

@JsType(isNative = true, namespace = "PIXI.filters")
public class BlurXFilter extends Filter {

    @JsConstructor
    public BlurXFilter(){}

    /**
     * Sets the strength of both the blur.
     */
    @JsProperty
    public double blur;

    /**
     * Sets the quality of the blur by modifying the number of passes. More passes means higher quaility bluring but the lower the performance.
     */
    @JsProperty
    public double quality;
}
