package sk.mrtn.pixi.client.filters;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.Filter;
import sk.mrtn.pixi.client.Sprite;
import sk.mrtn.pixi.client.Texture;

/**
 * Created by klaun on 27/08/16.
 * The DisplacementFilter class uses the pixel values from the specified texture
 * (called the displacement map) to perform a displacement of an object.
 * You can use this filter to apply all manor of crazy warping effects
 * Currently the r property of the texture is used to offset the x and the g
 * property of the texture is used to offset the y.
 */

@JsType(isNative = true, namespace = "PIXI.filters")
public class DisplacementFilter extends Filter {

    /**
     * The texture used for the displacement map. Must be power of 2 sized texture.
     */
    @JsProperty
    public Texture  map;

    @JsConstructor
    public DisplacementFilter(Sprite sprite, double scale){}


}
