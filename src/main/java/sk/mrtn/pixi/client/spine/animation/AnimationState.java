package sk.mrtn.pixi.client.spine.animation;

import jsinterop.annotations.*;
import sk.mrtn.pixi.client.spine.Skeleton;
import sk.mrtn.pixi.client.spine.TrackEntry;

/**
 * Since applying animations with crossfading is very common, AnimationState makes it more convenient.
 * First AnimationStateData is configured with the durations to crossfade each pair of animations.
 * AnimationStateData is stateless and can be used with multiple AnimationState instances.
 * Next, AnimationState takes an AnimationStateData and is told what animation to use.
 * When the AnimationState animation changes, it does the mixing automatically.
 * <p>
 * Example:
 * AnimationState state = new AnimationState(stateData);
 * state.setAnimation(0, "walk", false);
 * state.addAnimation(0, "jump", false, 0); * trackIndex, name, loop, delay
 * state.addAnimation(0, "fly", true, 0);
 * In this example, first the "walk" animation is played.
 * After 2.5 seconds, the "jump" animation is played. 0.5 seconds before the end of that animation is reached, the "fly" animation is played.
 * <p>
 * Edit: Martin Liptak 23.Nov.2017 - updated spine js to 1.5.9 + added new way of registering events + added two new events
 *
 * @author Tomas Ecker
 */
@JsType(isNative = true, namespace = "PIXI.spine.core")
public class AnimationState {

    public double timeScale;

    public AnimationState(AnimationStateData data){};

    /**
     * Sets the current animation. Any queued animations are cleared.
     *
     * Starts animation by it's name on given track defined by trackIndex. You can enable animation looping.
     * Appropriate animation names can be retrieved from skeleton.json#animations json object.
     * Imagine as TOYCAR on AUTODROM with THUMB pressed on controller for each LAP if loop is true.
     * Check {@link #clearTrack(int)} to stop animation play
     *
     *
     * @param trackIndex - just a spacetime for animation playback
     * @param animationName - animation name given skeleton.json#animations json object
     * @param loop - looping animation if true
     */
    public native void setAnimation(int trackIndex, String animationName, boolean loop);

    /**
     * Queues an animation to be played after a delay. If delay is <= 0, the duration of previous animation is used plus the negative delay.
     *
     * Starts animation by it's name on given track defined by trackIndex. You can enable animation looping and setup delay.
     * Appropriate animation names can be retrieved from skeleton.json#animations json object.
     * Imagine as TOYCAR on AUTODROM with THUMB pressed on controller for each LAP if loop is true.
     * Check {@link #clearTrack(int)} to stop animation play
     *
     * @param trackIndex - just a spacetime for animation playback
     * @param animationName - animation instance
     * @param loop - looping animation if true
     * @param delay - delay in seconds
     */
    public native void addAnimation(int trackIndex, String animationName, boolean loop, double delay);

    /**
     * Sets the current animation. Any queued animations are cleared.
     *
     * Starts animation instance on given track defined by trackIndex. You can enable animation looping.
     * Appropriate animation names can be retrieved from skeleton.json#animations json object.
     * Imagine as TOYCAR on AUTODROM with THUMB pressed on controller for each LAP if loop is true.
     * Check {@link #clearTrack(int)} to stop animation play
     *
     * @param trackIndex - just a spacetime for animation playback
     * @param animation - animation instance
     * @param loop - looping animation if true
     */
    public native void setAnimationWith(int trackIndex, Animation animation, boolean loop);

    /**
     * Queues an animation to be played after a delay. If delay is <= 0, the duration of previous animation is used plus the negative delay.
     *
     * Starts animation instance on given track defined by trackIndex. You can enable animation looping and setup delay.
     * Appropriate animation names can be retrieved from skeleton.json#animations json object.
     * Imagine as TOYCAR on AUTODROM with THUMB pressed on controller for each LAP if loop is true.
     * Check {@link #clearTrack(int)} to stop animation play
     *
     * @param trackIndex - just a spacetime for animation playback
     * @param animation - animation instance
     * @param loop - looping animation if true
     * @param delay - delay in seconds
     */
    public native void addAnimationWith(int trackIndex, Animation animation, boolean loop, double delay);

    /**
     *  Sets the current animation of a track to null and clears all queued animations.
     *
     * Stops animation playback of given track. Check {@link #setAnimation(int, String, boolean)} to start animation.
     * Animations is finished as is visually.
     * @param trackIndex - just a spacetime for animation playback
     */
    public native void clearTrack(int trackIndex);

    /**
     * Clears all available running track. Registration is done via {@link #setAnimation(int, String, boolean)}
     * Check {@link #clearTrack(int)} for more details.
     */
    public native void clearTracks();

    /**
     * Get entry running on provided trackIndex.
     * @param trackIndex - track index
     * @return track entry instance or null if undefined
     */
    public native TrackEntry getCurrent(int trackIndex);

    /**
     * Increases the animation state's `time` field.
     * @param delta
     */
    public native void update(double delta);

    /**
     * Poses the skeleton using the current animation and time.
     * @param skeleton
     */
    public native void apply(Skeleton skeleton);

    public native void setEmptyAnimation(int trackIndex, double mixDuration);

    public native Object addListener(Object listener);

    //region AUTOGENERATED METHODS AND FIELDS - not used
    // PUBLIC STATIC FIELDS
    @JsProperty
    public static int SUBSEQUENT;
    @JsProperty
    public static int FIRST;
    @JsProperty
    public static int DIP;
    @JsProperty
    public static int DIP_MIX;
    @JsProperty
    public static boolean deprecatedWarning1;
    @JsProperty
    public static boolean deprecatedWarning2;
    @JsProperty
    public static boolean deprecatedWarning3;

    // PUBLIC STATIC METHODS


    // PUBLIC FIELDS
    @JsProperty
    public Object tracks;
    @JsProperty
    public Object events;
    @JsProperty
    public Object listeners;
    @JsProperty
    public Object queue;
    @JsProperty
    public Object propertyIDs;
    @JsProperty
    public Object mixingTo;
    @JsProperty
    public boolean animationsChanged;

    @JsProperty
    public Object trackEntryPool;
    @JsProperty
    public Object data;

    // PUBLIC METHODS

    @JsMethod
    public native Object updateMixingFrom(Object to, Object delta);
    @JsMethod
    public native Object applyMixingFrom(Object to, Object skeleton, Object currentPose);
    @JsMethod
    public native Object applyRotateTimeline(Object timeline, Object skeleton, Object time, Object alpha, Object pose, Object timelinesRotation, Object i, Object firstFrame);
    @JsMethod
    public native Object queueEvents(Object entry, Object animationTime);
    @JsMethod
    public native Object setCurrent(Object index, Object current, Object interrupt);
    @JsMethod
    public native Object addEmptyAnimation(Object trackIndex, Object mixDuration, Object delay);
    @JsMethod
    public native Object setEmptyAnimations(Object mixDuration);
    @JsMethod
    public native Object expandToIndex(Object index);
    @JsMethod
    public native Object trackEntry(Object trackIndex, Object animation, Object loop, Object last);
    @JsMethod
    public native Object disposeNext(Object entry);
    @JsMethod
    public native Object removeListener(Object listener);
    @JsMethod
    public native Object clearListeners();
    @JsMethod
    public native Object clearListenerNotifications();
    @JsMethod
    public native Object setAnimationByName(Object trackIndex, Object animationName, Object loop);
    @JsMethod
    public native Object addAnimationByName(Object trackIndex, Object animationName, Object loop, Object delay);
    @JsMethod
    public native Object hasAnimation(Object animationName);
    @JsMethod
    public native Object hasAnimationByName(Object animationName);
    //endregion
}

