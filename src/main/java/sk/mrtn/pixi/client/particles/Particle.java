package sk.mrtn.pixi.client.particles;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.*;

/**
 * Created by klaun on 25/04/16.
 * TODO: create interface/class for fields or methods typed as Object
 */

@JsType(isNative = true, namespace = "PIXI.particles")
public class Particle {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS
    // TODO: otestovat vystup a vyhodnotit
    @JsMethod
    public static native Object parseArt(Texture[] textures);

    @JsMethod
    public static native Object parseArt(String [] textureNames);

    @JsMethod
    public static native Object parseData(Object extraData);

    @JsConstructor
    protected Particle(){}

    @JsConstructor
    public Particle(Emitter emitter){}

    // PUBLIC FIELDS
    @JsProperty
    public Point position;
    @JsProperty
    public Point scale;
    @JsProperty
    public Point pivot;
    @JsProperty
    public Point skew;
    @JsProperty
    public int rotation;
    @JsProperty
    public int alpha;
    @JsProperty
    public boolean visible;
    @JsProperty
    public boolean renderable;
    @JsProperty
    public Container parent;
    @JsProperty
    public int worldAlpha;
    @JsProperty
    public Matrix worldTransform;
    @JsProperty
    public Rectangle filterArea;
    @JsProperty
    public DisplayObject[] children;
    @JsProperty
    public Point anchor;
    @JsProperty
    public int tint;
    @JsProperty
    public int blendMode;
    @JsProperty
    public Shader shader;
    @JsProperty
    public int cachedTint;
    @JsProperty
    public Emitter emitter;
    @JsProperty
    public Point velocity;
    @JsProperty
    public int maxLife;
    @JsProperty
    public int age;
    /**
     * A simple easing function to be applied to all
     * properties that are being interpolated. (function)
     * TODO: create interface/class
     */
    @JsProperty
    public Object ease;

    /**
     * Extra data that the emitter passes along for custom particles.
     * TODO: create interface/class
     */
    @JsProperty
    public Object extraData;
    @JsProperty
    public int startAlpha;
    @JsProperty
    public int endAlpha;
    @JsProperty
    public int startSpeed;
    @JsProperty
    public int endSpeed;
    @JsProperty
    public Point acceleration;
    @JsProperty
    public int startScale;
    @JsProperty
    public int endScale;
    @JsProperty
    public int[] startColor;
    @JsProperty
    public int[] endColor;
    // UNDOCUMENTED PROPERTIES
    @JsProperty
    public Object next;
    @JsProperty
    public Object prev;

    // PUBLIC METHODS

    /**
     * Initializes the particle for use, based on the
     * properties that have to have been set already on the particle.
     */
    @JsMethod
    public native void init();

    /**
     * Updates the particle.
     * @param delta - Time elapsed since the previous frame, in seconds.
     * @return - The standard interpolation multiplier (0-1) used for all relevant particle properties.
     * A value of -1 means the particle died of old age instead.
     */
    @JsMethod
    public native double update(double delta);

    /**
     * Sets the texture for the particle.
     * This can be overridden to allow for an animated particle.
     * @param texture
     */
    @JsMethod
    public native void applyArt(Texture texture);

    /**
     * Kills the particle, removing it from the display list
     * and telling the emitter to recycle it.
     */
    @JsMethod
    public native void kill();

    /**
     * Destroys the particle, removing
     * references and preventing future use.
     * @return
     */
    @JsMethod
    public native void destroy();

}
