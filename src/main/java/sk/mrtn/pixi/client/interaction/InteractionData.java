package sk.mrtn.pixi.client.interaction;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 22/08/16.
 */

@JsType(isNative = true, namespace = "PIXI.interaction")
public class InteractionData {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    @JsConstructor
    public InteractionData(){};

    // PUBLIC FIELDS
    @JsProperty
    public Object global;
    @JsProperty
    public Object target;
    @JsProperty
    public Object originalEvent;

    // PUBLIC METHODS
    @JsMethod
    public native Object getLocalPosition(Object displayObject, Object point, Object globalPos);

}
