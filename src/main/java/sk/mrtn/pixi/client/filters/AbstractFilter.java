package sk.mrtn.pixi.client.filters;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.RenderTarget;

/**
 * Created by klaun on 20/08/16.
 */

@JsType(isNative = true, namespace = "PIXI.filters")
public abstract class AbstractFilter {

    @JsProperty
    public Double padding;

    @JsProperty
    public Integer type;

    @JsProperty
    public Object uniforms;

    @JsMethod
    public native void applyFilter(Object renderer, RenderTarget input, RenderTarget output, Boolean clear);

    @JsOverlay
    public final FilterType getType() {
        return FilterType.valueOf(type);
    }

}
