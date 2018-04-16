package sk.mrtn.pixi.client.spine;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Tomas Ecker
 */
@JsType(isNative = true, namespace = "PIXI.spine.core")
public class SlotData {

    /**
     * The name of the slot as it appears in Spine.
     * Unique Slot Name
     * @return
     */
    @JsProperty
    public String name;

    /**
     * The bone the slot belongs to
     * @return
     */
    @JsProperty
    public BoneData boneData;

    @JsConstructor
    public SlotData(int index, String name, BoneData boneData){};
}
