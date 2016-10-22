package sk.mrtn.pixi.client.interaction;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.DisplayObject;
import sk.mrtn.pixi.client.Point;

/**
 * Created by klaun on 22/08/16.
 */

@JsType(isNative = true, namespace = "PIXI.interaction")
public class InteractionManager {

    /**
     * Should default browser actions automatically be prevented. (default true)
     */
    @JsProperty
    public boolean autoPreventDefault;
    /**
     * The css style of the cursor that is being used
     */
    @JsProperty
    public String currentCursorStyle;
    /**
     * Every update cursor will be reset to this value,
     * if some element wont override it in its hitTest
     */
    @JsProperty
    public String defaultCursorStylestring;
    /**
     * An event data object to handle all the event tracking/dispatching
     */
    @JsProperty
    public Object eventData;
    /**
     * As this frequency increases the interaction events will be checked more often.
     * default 10
     */
    @JsProperty
    public double interactionFrequency;
    /**
     * Tiny little interactiveData pool !
     */
    @JsProperty
    public InteractionData[] interactiveDataPoolArray;
    /**
     * The mouse data
     */
    @JsProperty
    public InteractionData mouse;
    /**
     * The renderer this interaction manager works for.
     */
    @JsProperty
    public Object renderer;
    /**
     * The current resolution / device pixel ratio.
     */
    @JsProperty
    public double resolution;

    @JsConstructor
    public InteractionManager(Object renderer, Object options){}

    /**
     * Destroys the interaction manager
     */
    @JsMethod
    public native void destroy();

    /**
     * Maps x and y coords from a DOM object and maps them
     * correctly to the pixi view. The resulting value is stored in the point.
     * This takes into account the fact that the DOM element could
     * be scaled and positioned anywhere on the screen.
     * @param point the point that the result will be stored in
     * @param x the x coord of the position to map
     * @param y the y coord of the position to map
     */
    @JsMethod
    public native void mapPositionToPoint(Point point, double x, double y);

    /**
     * TODO: test and create appropriate callback
     * This function is provides a neat way of crawling through the scene graph
     * and running a specified function on all interactive objects it finds.
     * It will also take care of hit testing the interactive objects and passes the hit across in the function.
     * @param point the point that is tested for collision
     * @param displayObject the displayObject that will be hit test (recurcsivly crawls its children)
     * @param func the function that will be called on each interactive object. The displayObject and hit will be passed to the function
     * @param hitTest (optional) this indicates if the objects inside should be hit test against the point
     * @param interactive (optional) Whether the displayObject is interactive
     * @return
     */
    public native boolean processInteractive(Point point, DisplayObject displayObject, Object func, Boolean hitTest, Boolean interactive);

    /**
     * Updates the state of interactive objects.
     * Invoked by a throttled ticker update from
     * PIXI.ticker.shared.
     * @param deltaTime time delta since last tick
     */
    public native void update(double deltaTime);
}
