package sk.mrtn.pixi.client.spine;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * BoneData stores the hierarchy of bones in the setup pose and their SRT.
 *
 * @author Tomas Ecker
 */
@JsType(isNative = true, namespace = "PIXI.spine.core")
public class BoneData {

    /**
     * Parent bone data
     * @return
     */
    @JsProperty
    public BoneData parent;

    /**
     * The name of the bone as it appears in Spine.
     * @return
     */
    @JsProperty
    public String name;

    /**
     * The local position of the bone relative to the parent bone.
     * X coordinate of given bone in default pose
     * @return x coordinate
     */
    @JsProperty
    public double x;

    /**
     * The local position of the bone relative to the parent bone.
     * Y coordinate of given bone in default pose
     * @return y coordinate
     */
    @JsProperty
    public double y;

    /**
     * The local rotation of the bone.
     * Provides rotation in degrees
     * @return rotation in degrees
     */
    @JsProperty
    public double rotation;

    /**
     * The local scale of the bone.
     * Scale coefficient in X axis
     * @return scale coefficient in X
     */
    @JsProperty
    public double scaleX;

    /**
     * The local scale of the bone.
     * Scale coefficient in Y axis
     * @return scale coefficient in Y
     */
    @JsProperty
    public double scaleY;

    /**
     * Shear factor for given bone. Does a shaar transformation in X axis. Sometimes called skewing.
     * @return shear coefficient on X
     */
    @JsProperty
    public double shearX;

    /**
     * Shear factor for given bone. Does a shaar transformation in Y axis. Sometimes called skewing.
     * @return shear coefficient on Y
     */
    @JsProperty
    public double shearY;

    /**
     *
     * @return <code>true</code> if the local scale is relative to the parent bone.
     */
    @JsProperty
    public boolean inheritScale;

    /**
     *
     * @return <code>true</code> if the local rotation is relative to the parent bone.
     */
    @JsProperty
    public boolean inheritRotation;

    @JsConstructor
    public BoneData(int index, String name, BoneData parent){};
}
