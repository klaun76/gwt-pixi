package sk.mrtn.pixi.client.spine;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = "PIXI.spine.core")
public class SkeletonJson {

    // PUBLIC FIELDS
    @JsProperty
    public int scale;
    @JsProperty
    public Object linkedMeshes;
    @JsProperty
    public Object attachmentLoader;

    // PUBLIC STATIC FIELDS


    // PUBLIC STATIC METHODS
    @JsMethod
    public static native Object blendModeFromString(Object str);

    @JsMethod
    public static native Object positionModeFromString(Object str);

    @JsMethod
    public static native Object spacingModeFromString(Object str);

    @JsMethod
    public static native Object rotateModeFromString(Object str);

    @JsMethod
    public static native Object transformModeFromString(Object str);

    @JsConstructor
    public SkeletonJson(Object attachmentLoader) {};

    // PUBLIC METHODS
    @JsMethod
    public native SkeletonData readSkeletonData(Object json);
    @JsMethod
    public native Object readAttachment(Object map, Object skin, Object slotIndex, Object name, Object skeletonData);
    @JsMethod
    public native Object readVertices(Object map, Object attachment, Object verticesLength);
    @JsMethod
    public native Object readAnimation(Object map, Object name, Object skeletonData);
    @JsMethod
    public native Object readCurve(Object map, Object timeline, Object frameIndex);
    @JsMethod
    public native Object getValue(Object map, Object prop, Object defaultValue);
}
