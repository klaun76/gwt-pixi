package sk.mrtn.pixi.client;

import jsinterop.annotations.*;
import sk.mrtn.pixi.client.interaction.EventListener;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by klaun on 20/08/16.
 * @see <a href="https://pixijs.github.io/docs/PIXI.DisplayObject.html">DisplayObject</a>
 * FIXME: PIXI.Point or PIXI.ObservablePoint
 */
@JsType(isNative = true, namespace = "PIXI")
public abstract class DisplayObject {

    // PUBLIC FIELDS
    /**
     * The coordinate of the object relative to the local coordinates of the parent.
     * Assignment by value since pixi-v4.
     * FIXME: PIXI.Point or PIXI.ObservablePoint
     */
    @JsProperty
    public Point position;

    /**
     * The position of the displayObject on the x axis
     * relative to the local coordinates of the parent.
     * An alias to position.x
     */
    @JsProperty
    public double x;

    /**
     * The position of the displayObject on the y axis
     * relative to the local coordinates of the parent.
     * An alias to position.y
     */
    @JsProperty
    public double y;

    /**
     * The scale factor of the object.
     * Assignment by value since pixi-v4.
     * FIXME: PIXI.Point or PIXI.ObservablePoint
     */
    @JsProperty
    public Point scale;

    /**
     * The pivot point of the displayObject that it rotates around
     * Assignment by value since pixi-v4.
     * FIXME: PIXI.Point or PIXI.ObservablePoint
     */
    @JsProperty
    public Point pivot;

    /**
     * The skew factor for the object in radians.
     * Assignment by value since pixi-v4.
     */
    @JsProperty
    public ObservablePoint skew;
    /**
     * The rotation of the object in radians.
     */
    @JsProperty
    public int rotation;

    /**
     * The opacity of the object.
     */
    @JsProperty
    public double alpha;

    /**
     * Current transform of the object based on local factors: position, scale, other stuff
     * readonly
     */
    @JsProperty
    public Matrix localTransform;

    /**
     * Sets the filters for the displayObject.
     * IMPORTANT: This is a webGL only feature and will be ignored by the canvas renderer.
     * To remove filters simply set this property to 'null'
     * TODO: test because in documentation referred as AbstractFilter
     */
    @JsProperty
    public Filter[] filters;

    /**
     * Set this to true if you want this display object to be cached as a bitmap.
     * This basically takes a snap shot of the display object as it is at that moment.
     * It can provide a performance benefit for complex static displayObjects.
     * To remove simply set this property to 'false'
     */
    @JsProperty
    public boolean cacheAsBitmap;

    /**
     * The visibility of the object. If false the object will not be drawn, and
     * the updateTransform function will not be called.
     */
    @JsProperty
    public boolean visible;

    /**
     * Can this object be rendered, if false the object
     * will not be drawn but the updateTransform
     * methods will still be called.
     */
    @JsProperty
    public boolean renderable;

    /**
     * The display object container that contains this display object.
     * readonly
     */
    @JsProperty
    public Container parent;

    /**
     * The multiplied alpha of the displayObject
     * readonly
     */
    @JsProperty
    public int worldAlpha;

    /**
     * Current transform of the object based on world (parent) factors
     */
    @JsProperty
    public Matrix worldTransform;

    /**
     * Indicates if the sprite is globally visible.
     * readonly
     */
    @JsProperty
    public boolean worldVisible;

    /**
     * The area the filter is applied to. This is used as more of an optimisation
     * rather than figuring out the dimensions of the displayObject each frame you can set this rectangle
     * Also works as an interaction mask
     */
    @JsProperty
    public Rectangle filterArea;

    /**
     * Sets a mask for the displayObject. A mask is an object that
     * limits the visibility of an object to the shape of the mask applied to it.
     * In PIXI a regular mask must be a PIXI.Graphics or a PIXI.Sprite object.
     * This allows for much faster masking in canvas as it utilises shape clipping.
     * To remove a mask, set this property to null.
     * FIXME: Sprite or Graphic
     */
    @JsProperty
    public Sprite mask;

    /**
     * World transform and local transform of this object.
     * This will be reworked in v4.1, please do not use
     * it yet unless you know what are you doing!
     */
    @JsProperty
    public TransformBase transform;

    @JsProperty
    public String name;

    /**
     * enable the DisplayObject to be interactive... this will
     * allow it to respond to mouse and touch events
     */
    @JsProperty
    public boolean interactive;

    /**
     * this button mode will mean the hand cursor appears when
     * you roll over the bunny with your mouse
     */

    @JsProperty
    public boolean buttonMode;

    // UNDOCUMENTED

    @JsProperty
    public boolean interactiveChildren;
    @JsProperty
    public String defaultCursor;
    @JsProperty
    public boolean accessible;
    @JsProperty
    public Object accessibleTitle;
    @JsProperty
    public int tabIndex;

    @JsConstructor
    public DisplayObject(){}

    // PUBLIC METHODS

    /**
     * recursively updates transform of all objects from the root to this one
     * internal function for toLocal()
     */
    @JsMethod
    public native void _recursivePostUpdateTransform();

    /**
     * Retrieves the bounds of the displayObject as a rectangle object.
     * @param skipUpdate - setting to true will stop the transforms of the scene graph from being updated.
     *                   This means the calculation returned MAY be out of date BUT will give you a nice performance boost
     * @param matrix - Optional rectangle to store the result of the bounds calculation
     * @return
     */
    @JsMethod
    public native Rectangle getBounds(boolean skipUpdate, Rectangle matrix);

    @JsMethod
    public native Rectangle getBounds(boolean skipUpdate);

    /**
     * in this overload skipUpdate is set to false, and matrix unused
     * @return
     */
    @JsMethod
    public native Rectangle getBounds();

    /**
     * Retrieves the local bounds of the displayObject as a rectangle object
     * @return the rectangular bounding area
     */
    @JsMethod
    public native Rectangle getLocalBounds();

    /**
     * Retrieves the local bounds of the displayObject as a rectangle object
     * @param rect - Optional rectangle to store the result of the bounds calculation
     * @return
     */
    @JsMethod
    public native Rectangle getLocalBounds(Rectangle rect);

    /**
     * Calculates the global position of the display object
     * @param position The world origin to calculate from
     * @return A point object representing the position of this object
     */
    @JsMethod
    public native Point toGlobal(Point position);

    /**
     * Calculates the local position of the display object relative to another point
     * @param position - The world origin to calculate from
     * @param from - optional, The DisplayObject to calculate the global position from
     * @param point - optional, A Point object in which to store the value, optional (otherwise will create a new Point)
     * @return A point object representing the position of this object
     */
    @JsMethod
    public native Point toLocal(Point position, DisplayObject from, Point point);

    /**
     * Renders the object using the WebGL renderer
     * @param renderer
     */
    @JsMethod
    public native void renderWebGL(Renderer renderer);

    /**
     * Renders the object using the Canvas renderer
     * @param renderer
     */
    @JsMethod
    public native void renderCanvas(Renderer renderer);

    /**
     * Set the parent Container of this DisplayObject
     * @param container - The Container to add this DisplayObject to
     * @return The Container that this DisplayObject was added to
     */
    @JsMethod
    public native Container setParent(Container container);

    /**
     * Convenience function to set the postion, scale, skew and pivot at once.
     * @param x
     * @param y
     * @param scaleX
     * @param scaleY
     * @param rotation
     * @param skewX
     * @param skewY
     * @param pivotX
     * @param pivotY
     * @return
     */
    @JsMethod
    public native boolean setTransform(double x, double y, double scaleX, double scaleY, double rotation, double skewX, double skewY, double pivotX, double pivotY);

    /**
     * Base destroy method for generic display objects. This will automatically
     * remove the display object from its parent Container as well as remove
     * all current event listeners and internal references. Do not use a DisplayObject
     * after calling destroy.
     */
    @JsMethod
    public native void destroy();

    @JsMethod
    public native Point getGlobalPosition(Point point);

    @JsMethod
    public native Texture generateTexture(Renderer renderer, double scaleMode, double resolution);

    /**
     * method allows to add interaction for object
     * @param eventType
     * @param eventListener
     */
    @JsMethod
    public native void on(String eventType, EventListener eventListener);

    /**
     * method allows to remove interaction of given type for object
     * @param eventType
     */
    @JsMethod
    public native void off(String eventType);

    /**
     * method allows to remove interaction for object
     */
    @JsMethod
    public native void off();

    /**
     * Collection tags, and associated methods are not part
     * of pixi code. I decided to add tagging for display objects
     * because I had good experience with this logic in previous
     * projects.
     * Tags should allow to search within display tree for
     * tagged objects create specified collections and
     * work with them.
     */
    protected Collection<Integer> tags;

    /**
     * method adds tag to object
     * @param tag
     */
    @JsOverlay
    public final void addTag(final int tag) {
        safeGetTags().add(tag);
    }

    /**
     * method returns if object has specified tag
     * @param tag
     * @return
     */
    @JsOverlay
    public final boolean hasTag(final int tag) {
        return safeGetTags().contains(tag);
    }

    /**
     * method returns all tags of object
     * @return
     */
    @JsOverlay
    public final Collection<Integer> getTags() {
        return Collections.unmodifiableCollection(safeGetTags());
    }

    /**
     * method resets new tag collection
     * @param tags
     */
    @JsOverlay
    public final void setTags(final Collection<Integer> tags) {
        safeGetTags().clear();
        safeGetTags().addAll(tags);
    }

    /**
     * method exists just because,
     * Native JsType field 'Collection DisplayObject.tags' cannot have initializer.
     * and i was too lazy to search for better solution
     * @return
     */
    @JsOverlay
    private final Collection<Integer> safeGetTags() {
        if (this.tags == null) {
            this.tags = new HashSet<>();
        }
        return this.tags;
    }
}
