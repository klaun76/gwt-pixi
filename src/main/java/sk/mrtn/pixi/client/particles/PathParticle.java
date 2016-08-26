package sk.mrtn.pixi.client.particles;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.Point;

/**
 * Created by klaun on 25/04/16.
 */

@JsType(isNative = true, namespace = "PIXI.particles")
public class PathParticle extends Particle {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    @JsConstructor
    public PathParticle(Emitter emitter){}

    // PUBLIC FIELDS

    /**
     * The function representing the path the particle should take.
     */
    @JsProperty
    public Object path;

    /**
     * The initial rotation in degrees of the particle,
     * because the direction of the path is based on that.
     */
    @JsProperty
    public int initialRotation;
    /**
     * The initial position of the particle, as all path movement is added to that.
     */
    @JsProperty
    public Point initialPosition;
    /**
     * Total single directional movement, due to speed.
     */
    @JsProperty
    public double movement;

}
