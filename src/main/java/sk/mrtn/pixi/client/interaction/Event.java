package sk.mrtn.pixi.client.interaction;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.DisplayObject;

/**
 * Created by klaun on 22/10/2016.
 */

@JsType(isNative = true)
public class Event {

    @JsProperty
    public InteractionData data;
    @JsProperty
    public DisplayObject target;
    @JsProperty
    public String type;

    @JsMethod
    public native void stopPropagation();

}
