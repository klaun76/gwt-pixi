package sk.mrtn.pixi.client.spine;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.Container;
import sk.mrtn.pixi.client.spine.animation.AnimationState;
import sk.mrtn.pixi.client.spine.animation.AnimationStateData;

/**
 * @author Tomas Ecker
 */
@JsType(isNative = true, namespace = "PIXI.spine")
public class Spine extends Container {

    /**
     * This very usefull thing how to stop all animations on all tracks
     * @param autoUpdate <code>true</code> will update animation during render phase. Delta time is automatically
     *                   computed and you could miss out on cool effects like slow motion, pause, skip ahead and the sorts.
     *                   <code>false</code> it's up to animator to update frames in right time about right time by calling {@link #update(double)}
     */
    @JsProperty
    public boolean autoUpdate;

    @JsProperty
    public Skeleton skeleton;

    @JsProperty
    public AnimationStateData stateData;

    @JsProperty
    public AnimationState state;

    @JsConstructor
    public Spine(SkeletonData spineData){};

    /**
     * Setup updating interval.
     * Time by which the animation should be updated
     * @param deltaTime - updating delta (small amount of time for redrawing, [redraw step])
     */
    @JsMethod
    public native void update(double deltaTime);

    //region AUTOGENERATED METHODS AND FIELDS - not used

    // PUBLIC STATIC FIELDS
    @JsProperty
    public static boolean globalAutoUpdate;

    // PUBLIC STATIC METHODS



    // PUBLIC FIELDS
    @JsProperty
    public Object tempDisplayObjectParent;
    @JsProperty
    public Object transform;
    @JsProperty
    public int alpha;
    @JsProperty
    public boolean visible;
    @JsProperty
    public boolean renderable;
    @JsProperty
    public Object parent;
    @JsProperty
    public int worldAlpha;
    @JsProperty
    public Object filterArea;
    @JsProperty
    public Object children;
    @JsProperty
    public Object spineData;
    @JsProperty
    public Object slotContainers;
    @JsProperty
    public Object tempClipContainers;
    @JsProperty
    public Object tintRgb;
    @JsProperty
    public int tint;

    // PUBLIC METHODS
    @JsMethod
    public native Object updateTransform();
    @JsMethod
    public native Object constructor(Object spineData);
    @JsMethod
    public native Object setSpriteRegion(Object attachment, Object sprite, Object region);
    @JsMethod
    public native Object setMeshRegion(Object attachment, Object mesh, Object region);
    @JsMethod
    public native Object autoUpdateTransform();
    @JsMethod
    public native Object createSprite(Object slot, Object attachment, Object defName);
    @JsMethod
    public native Object createMesh(Object slot, Object attachment);
    @JsMethod
    public native Object createGraphics(Object slot, Object clip);
    @JsMethod
    public native Object updateGraphics(Object slot, Object clip);
    @JsMethod
    public native Object hackTextureBySlotIndex(Object slotIndex, Object texture, Object size);
    @JsMethod
    public native Object hackTextureBySlotName(Object slotName, Object texture, Object size);
    @JsMethod
    public native Object newContainer();
    @JsMethod
    public native Object newSprite(Object tex);
    @JsMethod
    public native Object newGraphics();
    @JsMethod
    public native Object newMesh(Object texture, Object vertices, Object uvs, Object indices, Object drawMode);
    @JsMethod
    public native Object transformHack();
    //endregion

}