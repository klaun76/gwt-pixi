package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import javax.inject.Inject;

/**
 * Created by klaun on 20/08/16.
 */

@JsType(isNative = true, namespace = "PIXI")
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
