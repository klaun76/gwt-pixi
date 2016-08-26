package sk.mrtn.pixi.client.filters;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.Sprite;

/**
 * Created by klaun on 20/08/16.
 */

@JsType(isNative = true, namespace = "PIXI.filters")
public class DisplacementFilter extends AbstractFilter {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    @JsConstructor
    public DisplacementFilter(Sprite sprite){};

}
