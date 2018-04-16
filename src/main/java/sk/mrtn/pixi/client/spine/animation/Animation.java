package sk.mrtn.pixi.client.spine.animation;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Animation has a list of timelines.
 * Each timeline has a list of times and values which represent keyframes and knows how to apply the values to a skeleton for a given time.
 *
 * @author Tomas Ecker
 */
@JsType(isNative = true, namespace = "PIXI.spine.core")
public class Animation {
    /**
     * Name of animation. It's very important to run single animation.
     * @return animation name
     */
    @JsProperty
    public String name;

    /**
     * Provides full duration of given animation in seconds
     * @return duration in seconds
     */
    @JsProperty
    public double duration;

    @JsConstructor
    public Animation(String name, Object timelines, double duration){};

    //region AUTOGENERATED METHODS AND FIELDS - not used
    @JsMethod
    public static native Object binarySearch(Object values, Object target, Object step);
    @JsMethod
    public static native Object linearSearch(Object values, Object target, Object step);
    //endregion
}

