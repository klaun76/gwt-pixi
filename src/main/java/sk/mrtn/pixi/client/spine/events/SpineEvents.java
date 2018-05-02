package sk.mrtn.pixi.client.spine.events;

import jsinterop.annotations.JsType;

@JsType
public class SpineEvents {

    public IOnSpineEventFired event;
    public IOnSpineEventFired complete;
    public IOnSpineEventFired start;
    public IOnSpineEventFired end;
    public IOnSpineEventFired dispose;
    public IOnSpineEventFired interrupted;
}
