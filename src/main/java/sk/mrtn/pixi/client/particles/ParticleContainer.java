package sk.mrtn.pixi.client.particles;

import com.google.auto.factory.AutoFactory;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.Container;

import javax.inject.Inject;

/**
 * Created by klaun on 20/08/16.
 * The ParticleContainer class is a really fast version of the
 * Container built solely for speed, so use when you need a lot
 * of sprites or particles. The tradeoff of the ParticleContainer
 * is that advanced functionality will not work. ParticleContainer
 * implements only the basic object transform (position, scale, rotation).
 * Any other functionality like tinting, masking, etc will not
 * work on sprites in this batch.
 * @see <a href="https://pixijs.github.io/docs/PIXI.particles.ParticleContainer.html">ParticleContainer</a>
 */

@AutoFactory
@JsType(isNative = true, namespace = "PIXI.particles")
public class ParticleContainer extends Container {

    /**
     * The blend mode to be applied to the sprite. Apply a value of
     * PIXI.BLEND_MODES.NORMAL to reset the blend mode.
     * default PIXI.BLEND_MODES.NORMAL
     */
    @JsProperty
    public int blendMode;
    /**
     * Used for canvas renderering. If true then the elements will be
     * positioned at the nearest pixel. This provides a nice speed boost.
     * default value true
     */
    @JsProperty
    public boolean roundPixels;
    @JsProperty
    public boolean interactiveChildren;
    @Inject
    @JsConstructor
    public ParticleContainer(){}

    /**
     * @param maxSize - The maximum number of particles that can be renderer by the container.
     * @param properties - The properties of children that should be uploaded to the gpu and applied.
     * @param batchSize - Number of particles per batch.
     */
    @JsConstructor
    public ParticleContainer(
            double maxSize,
            ParticleContainerProperties properties,
            double batchSize
    ){}

    // PUBLIC METHODS
    @JsMethod
    public native void setProperties(ParticleContainerProperties particleContainerProperties);


}
