package sk.mrtn.pixi.client.particles;

import com.google.auto.factory.AutoFactory;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.*;
import sk.mrtn.pixi.client.particles.config.EmitterConfig;

/**
 * Created by klaun on 25/04/16.
 * TODO: test and add constructors for PathParticle
 */

@AutoFactory
@JsType(isNative = true, namespace = "PIXI.particles")
public class Emitter {

    @JsConstructor
    public Emitter(Container container){}

    /**
     * suitable for AnimatedParticle
     * @param container
     * @param animatedArticleArtTextures
     */
    @JsConstructor
    public Emitter(Container container, AnimatedArticleArtTextures[] animatedArticleArtTextures, EmitterConfig config){}

    /**
     * suitable for AnimatedParticle
     * @param container
     * @param animatedArticleArtTextureNames
     */
    @JsConstructor
    public Emitter(Container container, AnimatedArticleArtTextureNames[] animatedArticleArtTextureNames, EmitterConfig config){}

    /**
     * suitable for Particle
     * @param container
     * @param textures
     * @param config
     */
    @JsConstructor
    public Emitter(Container container, Texture[] textures, EmitterConfig config){}

    /**
     * suitable for Particle
     * @param container
     * @param textureNames
     * @param config
     */
    @JsConstructor
    public Emitter(Container container, String[] textureNames, EmitterConfig config){}

    // PUBLIC FIELDS
    @JsProperty
    public Texture[] particleImages;
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
    public int minimumScaleMultiplier;
    @JsProperty
    public int[] startColor;
    @JsProperty
    public int[] endColor;
    @JsProperty
    public int minLifetime;
    @JsProperty
    public int maxLifetime;
    @JsProperty
    public int minStartRotation;
    @JsProperty
    public int maxStartRotation;
    @JsProperty
    public boolean noRotation;
    @JsProperty
    public int minRotationSpeed;
    @JsProperty
    public int maxRotationSpeed;
    @JsProperty
    public int particleBlendMode;
    /**
     * An easing function for nonlinear interpolation of values.
     * Accepts a single parameter of time as a value from 0-1, inclusive.
     * Expected outputs are values from 0-1, inclusive.
     * TODO: test to create specific type (Function)
     */
    @JsProperty
    public Object customEase;
    /**
     * Extra data for use in custom particles. The emitter doesn't look inside, but passes it on to the particle to use in init().
     * TODO: test to create specific type (Object)
     */
    @JsProperty
    public Object extraData;
    @JsProperty
    public int maxParticles;
    @JsProperty
    public int emitterLifetime;
    @JsProperty
    public Point spawnPos;
    /**
     * How the particles will be spawned. Valid types are "point", "rectangle", "circle", "burst", "ring".
     */
    @JsProperty
    public String spawnType;
    @JsProperty
    public Rectangle spawnRect;
    @JsProperty
    public Circle spawnCircle;
    @JsProperty
    public int particlesPerWave;
    @JsProperty
    public int particleSpacing;
    @JsProperty
    public int angleStart;
    @JsProperty
    public int rotation;
    /**
     * The world position of the emitter's owner, to add spawnPos to when
     * spawning particles. To change this, use updateOwnerPos().
     * Default: {x:0, y:0}
     */
    @JsProperty
    public Point ownerPos;
    @JsProperty
    public boolean addAtBack;
    @JsProperty
    public int particleCount;

    // PUBLIC METHODS

    /**
     * Recycles an individual particle.
     * @param particle
     * @return
     */
    @JsMethod
    public native void recycle(Particle particle);

    /**
     * Updates all particles spawned by this emitter and emits new ones.
     * @param delta Time elapsed since the previous frame, in seconds.
     * @return
     */
    @JsMethod
    public native void update(double delta);

    /**
     * Sets the rotation of the emitter to a new value.
     * @param newRot - The new rotation, in degrees.
     */
    @JsMethod
    public native void rotate(double newRot);

    /**
     * Changes the spawn position of the emitter.
     * @param x - The new x value of the spawn position for the emitter.
     * @param y - The new y value of the spawn position for the emitter.
     */
    @JsMethod
    public native void updateSpawnPos(double x, double y);

    /**
     * Changes the position of the emitter's owner. You should call
     * this if you are adding particles to the world display
     * object that your emitter's owner is moving around in.
     * @param x - The new x value of the emitter's owner.
     * @param y - The new y value of the emitter's owner.
     * @return
     */
    @JsMethod
    public native void updateOwnerPos(double x, double y);

    /**
     * TODO: create interface/class for config
     * Sets up the emitter based on the config settings.
     * @param textures - A texture or array of textures to use for the particles.
     * @param config - A configuration object containing settings for the emitter.
     */
    @JsMethod
    public native void init(Texture[] textures, EmitterConfig config);

    /**
     * Prevents emitter position interpolation in the next update.
     * This should be used if you made a major position change
     * of your emitter's owner that was not normal movement.
     * @return
     */
    @JsMethod
    public native void resetPositionTracking();

    /**
     * Kills all active particles immediately.
     */
    @JsMethod
    public native void cleanup();

    /**
     * Destroys the emitter and all of its particles.
     * @return
     */
    @JsMethod
    public native void destroy();

}
