package sk.mrtn.pixi.client.loaders;

import jsinterop.annotations.*;

/**
 * Created by klaun on 22/08/16.
 * TODO: do some more tests try to add not native method
 */

@JsType(isNative = true, namespace = "PIXI.loaders")
public class Loader {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS
    @JsMethod
    public static native void addPixiMiddleware(Object fn);

    @JsConstructor
    public Loader(String baseUrl, Integer concurrency){};

    @JsConstructor
    public Loader(){};

    // PUBLIC FIELDS
    @JsProperty
    public String baseUrl;
    @JsProperty
    public int progress;
    @JsProperty
    public boolean loading;
    @JsProperty
    public Object resources;

    // PUBLIC METHODS
    @JsMethod
    public native void add(String name, String url);

    @JsMethod
    public native void add(String url);

    @JsMethod
    public native void load();
    @JsMethod
    public native void load(CompleteEventHandler completeEventHandler);
    // possible values progress, error, load, complete
    @JsMethod
    protected native void on(String eventName, Object eventHandler);

    @JsOverlay
    public final void onProgress(ProgressEventHandler progressEventHandler) {
        on("progress", progressEventHandler);
    }

    @JsOverlay
    public final void onLoad(ProgressEventHandler progressEventHandler) {
        on("load", progressEventHandler);
    }

    @JsOverlay
    public final void onError(ErrorEventHandler errorEventHandler) {
        on("error", errorEventHandler);
    }

    @JsOverlay
    public final void onComplete(CompleteEventHandler completeEventHandler) {
        on("complete", completeEventHandler);
    }

}
