package sk.mrtn.pixi.client.interaction;

import jsinterop.annotations.JsFunction;

/**
 * Created by klaun on 22/08/16.
 */
@JsFunction
public interface EventListener {
    void handleEvent(Event event);
}
