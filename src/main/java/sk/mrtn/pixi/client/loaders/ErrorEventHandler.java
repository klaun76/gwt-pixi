package sk.mrtn.pixi.client.loaders;

import jsinterop.annotations.JsFunction;

/**
 * Created by klaun on 22/08/16.
 */
@JsFunction()
public interface ErrorEventHandler {
    void onError(Loader loader, Error error);
}
