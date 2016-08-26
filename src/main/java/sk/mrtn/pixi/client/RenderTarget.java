package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 20/08/16.
 */

@JsType(isNative = true, namespace = "PIXI")
public class RenderTarget {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    @JsConstructor
    public RenderTarget(
            Object gl,
            Double width,
            Double height,
            Double scaleMode,
            Double resolution,
            Boolean root)
    {};

}
