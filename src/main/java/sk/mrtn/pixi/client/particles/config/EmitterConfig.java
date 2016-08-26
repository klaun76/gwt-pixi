package sk.mrtn.pixi.client.particles.config;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 22/08/16.
 */
@JsType(isNative = true)
public class EmitterConfig {

    @JsProperty
    public Alpha alpha;

    @JsProperty
    public Scale scale;

    @JsProperty
    public Color color;

    @JsProperty
    public Speed speed;

    @JsProperty
    public Acceleration acceleration;

    @JsProperty
    public StartRotation startRotation;

    @JsProperty
    public Boolean noRotation;

    @JsProperty
    public RotationSpeed rotationSpeed;

    @JsProperty
    public LifeTime lifetime;

    /**
     * add, multiply, screen, overlay
     * Canvas only:
     * TODO: Create enum
     */
    @JsProperty
    public String blendMode;

    @JsProperty
    public Boolean frequency;

    @JsProperty
    public Double emitterLifetime;

    @JsProperty
    public Integer maxParticles;

    @JsProperty
    public Position pos;

    @JsProperty
    public Boolean addAtBack;

    /**
     * point, rect, circle, ring, burst
     */
    @JsProperty
    public String spawnType;

    @JsProperty
    public SpawnCircle spawnCircle;

    @JsProperty
    public SpawnRect spawnRect;

    @JsProperty
    public Double particlesPerWave;

    @JsProperty
    public Double particleSpacing;

    @JsProperty
    public Double angleStart;


}
