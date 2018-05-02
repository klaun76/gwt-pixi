package sk.mrtn.pixi.client.spine;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.spine.animation.Animation;

/**
 * Represents record of running animation set by
 * {@link sk.mrtn.pixi.client.spine.animation.AnimationState#setAnimationWith(int, Animation, boolean)}
 * {@link sk.mrtn.pixi.client.spine.animation.AnimationState#addAnimationWith(int, Animation, boolean, double)}
 * {@link sk.mrtn.pixi.client.spine.animation.AnimationState#setAnimation(int, String, boolean)}
 * {@link sk.mrtn.pixi.client.spine.animation.AnimationState#addAnimation(int, String, boolean, double)}
 * *
 *
 * @author Tomas Ecker
 */
@JsType(isNative = true, namespace = "PIXI.spine.core")
public class TrackEntry {

    @JsProperty
    public native int getTrackIndex();

    @JsConstructor
    public TrackEntry() {};

}

