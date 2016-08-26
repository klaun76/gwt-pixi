package sk.mrtn.pixi.client.interaction;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.DisplayObject;

/**
 * Created by klaun on 22/08/16.
 * FIXME: controll why is commented out
 */
@JsType(isNative = true)
public class EventData {
    @JsProperty
    public DisplayObject target;
//    @JsProperty
//    boolean isStopped();
//
//    @JsProperty
//    void setStopped(boolean stopped);
//
//    @JsProperty
//    InteractionData getData();
//
//    @JsProperty
//    DisplayObject getTarget();
//
//    @JsProperty
//    String getType();
//
//    void stopPropagation();

}