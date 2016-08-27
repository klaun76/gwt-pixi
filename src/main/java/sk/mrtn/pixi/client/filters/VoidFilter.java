package sk.mrtn.pixi.client.filters;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.Filter;

/**
 * Created by klaun on 27/08/16.
 * Does nothing. Very handy.
 */

@JsType(isNative = true, namespace = "PIXI.filters")
public class VoidFilter extends Filter {

    @JsConstructor
    public VoidFilter(){}

}
