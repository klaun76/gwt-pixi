package sk.mrtn.pixi.client.loaders;

import jsinterop.annotations.JsFunction;

/**
 * Created by klaun on 22/08/16.
 */
@JsFunction()
public interface ProgressEventHandler {
    void onProgress(Loader loader, Resource resource);
}
