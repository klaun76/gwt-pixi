package sk.mrtn.pixi.client.ticker;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 22/08/16.
 */
@JsFunction
public interface ITickable {

    // in milliseconds
    void tick(double deltaTime);
}
