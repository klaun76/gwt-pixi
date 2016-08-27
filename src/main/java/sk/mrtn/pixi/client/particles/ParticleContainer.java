package sk.mrtn.pixi.client.particles;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.Container;

import javax.inject.Inject;

/**
 * Created by klaun on 20/08/16.
 */

@JsType(isNative = true, namespace = "PIXI.particles")
public class ParticleContainer extends Container {

    @Inject
    @JsConstructor
    public ParticleContainer(){}

    // PUBLIC FIELDS
    @JsProperty
    public int blendMode;
    @JsProperty
    public boolean roundPixels;

    // PUBLIC METHODS
    @JsMethod
    public native void setProperties(ParticleContainerProperties particleContainerProperties);


}
