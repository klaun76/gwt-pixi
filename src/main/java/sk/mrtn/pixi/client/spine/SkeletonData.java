package sk.mrtn.pixi.client.spine;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = "PIXI.spine.core")
public class SkeletonData {

    // PUBLIC FIELDS
    @JsProperty
    public Object bones;
    @JsProperty
    public Object slots;
    @JsProperty
    public Object skins;
    @JsProperty
    public Object events;
    @JsProperty
    public Object animations;
    @JsProperty
    public Object ikConstraints;
    @JsProperty
    public Object transformConstraints;
    @JsProperty
    public Object pathConstraints;
    @JsProperty
    public int fps;

    @JsConstructor
    public SkeletonData(){};

    // PUBLIC METHODS
    @JsMethod
    public native Object findBone(Object boneName);
    @JsMethod
    public native Object findBoneIndex(Object boneName);
    @JsMethod
    public native Object findSlot(Object slotName);
    @JsMethod
    public native Object findSlotIndex(Object slotName);
    @JsMethod
    public native Object findSkin(Object skinName);
    @JsMethod
    public native Object findEvent(Object eventDataName);
    @JsMethod
    public native Object findAnimation(Object animationName);
    @JsMethod
    public native Object findIkConstraint(Object constraintName);
    @JsMethod
    public native Object findTransformConstraint(Object constraintName);
    @JsMethod
    public native Object findPathConstraint(Object constraintName);
    @JsMethod
    public native Object findPathConstraintIndex(Object pathConstraintName);
}
