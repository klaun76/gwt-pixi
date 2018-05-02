package sk.mrtn.pixi.client.spine.events;

import jsinterop.annotations.JsFunction;
import sk.mrtn.pixi.client.spine.TrackEntry;

@FunctionalInterface
@JsFunction
public interface IOnSpineEventFired {
    void call(TrackEntry trackEntry, Event event, int count);
}