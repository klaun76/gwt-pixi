package sk.mrtn.pixi.client;

import jsinterop.annotations.*;
import sk.mrtn.pixi.client.filters.AbstractFilter;
import sk.mrtn.pixi.client.filters.BlurXFilter;
import sk.mrtn.pixi.client.filters.FilterType;
import sk.mrtn.pixi.client.filters.GrayFilter;
import sk.mrtn.pixi.client.interaction.ClickEventHandler;
import sk.mrtn.pixi.client.interaction.MouseDownEventHandler;

import java.util.logging.Logger;

/**
 * Created by klaun on 20/08/16.
 */

@JsType(isNative = true, namespace = "PIXI")
public class Sprite extends Container {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS
    @JsMethod
    public static native Sprite fromFrame(String frameId);
    @JsMethod
    public static native Sprite fromImage(String imageId);
    @JsMethod
    public static native Sprite fromImage(String imageId, Boolean crossorigin, Integer scaleMode);

    @JsConstructor
    public Sprite(Texture texture){}

    // PUBLIC FIELDS
    @JsProperty
    public Point anchor;
    @JsProperty
    public int tint;
    @JsProperty
    public int blendMode;
    @JsProperty
    public Shader shader;
    @JsProperty
    public int cachedTint;
    @JsProperty
    public AbstractFilter[] filters;

    // PUBLIC METHODS
    @JsMethod
    public native boolean containsPoint(Point point);
    @JsMethod
    public native void destroy(boolean destroyTexture, boolean destroyBaseTexture);
    @JsMethod
    public native void setTexture(Texture texture);

    /**
     * overlay extra methods
     */
    @JsOverlay
    public final void clearFilters() {
        filters = null;
    }

    @JsOverlay
    public final void addFilter(AbstractFilter filter) {
        if (filter instanceof GrayFilter) {
            filter.type = FilterType.GRAY.getType();
        }
        AbstractFilter[] nFilters = new AbstractFilter[getFilters().length+1];
        for (int i = 0; i < getFilters().length; i++) {
            nFilters[i] = getFilters()[i];
        }
        nFilters[nFilters.length-1]=filter;
        this.filters = nFilters;
    }

    @JsOverlay
    public final AbstractFilter[] getFilters() {
        if (filters == null) {
            filters = new AbstractFilter[0];
        }
        return this.filters;
    }

}
