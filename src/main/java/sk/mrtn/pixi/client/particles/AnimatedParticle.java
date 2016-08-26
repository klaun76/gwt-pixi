package sk.mrtn.pixi.client.particles;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 25/04/16.
 */

@JsType(isNative = true, namespace = "PIXI.particles")
public class AnimatedParticle extends Particle {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    @JsConstructor
    public AnimatedParticle(Emitter emitter){}

    // PUBLIC FIELDS

    @JsProperty
    public int duration;
    @JsProperty
    public int framerate;
    @JsProperty
    public int elapsed;
    @JsProperty
    public boolean loop;


}
