package sk.mrtn.pixi.client.interaction;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.DisplayObject;
import sk.mrtn.pixi.client.Point;

/**
 * Created by klaun on 22/10/2016.
 * Holds all information related to an Interaction event
 */

@JsType(isNative = true)
public class InteractionData {

    /**
     * This point stores the global coords of where the touch/mouse event happened
     */
    @JsProperty
    public Point global;

    /**
     * When passed to an event handler, this will be the original DOM Event that was captured
     */
    @JsProperty
    public elemental.events.Event originalEvent;

    /**
     * The target Sprite that was interacted with
     * TODO: check if display object suits better
     */
    @JsProperty
    public DisplayObject target;

    /**
     * This will return the local coordinates of the specified displayObject for this InteractionData
     * @param displayObject The DisplayObject that you would like the local coords off
     * @param point (optional) A Point object in which to store the value, optional (otherwise will create a new point)
     * @param globalPos (optional) A Point object containing your custom global coords, optional (otherwise will use the current global coords)
     * @return A point containing the coordinates of the InteractionData
     *         position relative to the DisplayObject
     */
    @JsMethod
    public native Point getLocalPosition(DisplayObject displayObject, Point point, Point globalPos);


}
