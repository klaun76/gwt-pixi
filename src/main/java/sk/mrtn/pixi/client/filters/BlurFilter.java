package sk.mrtn.pixi.client.filters;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.Filter;

/**
 * Created by klaun on 27/08/16.
 * The BlurFilter applies a Gaussian blur to an object.
 * The strength of the blur can be set for x- and y-axis separately.
 */

@JsType(isNative = true, namespace = "PIXI.filters")
public class BlurFilter extends Filter {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    @JsConstructor
    public BlurFilter(){}

    /**
     * Sets the strength of both the blur.
     * Default value 16
     */
    @JsProperty
    public double blur;

    /**
     * Sets the strength of the blurX property
     */
    @JsProperty
    public double blurX;
    /**
     * Sets the strength of the blurY property
     */
    @JsProperty
    public double blurY;

    /**
     * Sets the quality of the blur by modifying the number of passes. More passes means higher quaility bluring but the lower the performance.
     * Default value 4
     */
    @JsProperty
    public double quality;





}
