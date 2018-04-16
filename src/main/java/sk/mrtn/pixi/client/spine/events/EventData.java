package sk.mrtn.pixi.client.spine.events;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Tomas Ecker
 */
@JsType(isNative = true, namespace = "PIXI.spine.core")
public class EventData {

    @JsProperty
    public String name;

    @JsProperty
    public int intValue;

    @JsProperty
    public double floatValue;

    @JsProperty
    public String stringValue;

    @JsConstructor
    public EventData(String name){};

}

