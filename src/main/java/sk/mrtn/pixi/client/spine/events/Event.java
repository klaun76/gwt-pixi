package sk.mrtn.pixi.client.spine.events;

import jsinterop.annotations.JsType;

/**
 * @author Tomas Ecker
 */
@JsType(isNative = true, namespace = "PIXI.spine.core")
public class Event {

    public double time;

    public EventData data;

    public Event(double time, EventData data) {};

}
