package sk.mrtn.pixi.client.ticker;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import javax.inject.Inject;

/**
 * Created by klaun on 20/08/16.
 */

@JsType(isNative = true, namespace = "PIXI.ticker")
public class Ticker {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    @Inject
    @JsConstructor
    public Ticker(){}

    // PUBLIC FIELDS
    @JsProperty
    public boolean autoStart;
    // in milliseconds
    @JsProperty
    public int deltaTime;
    @JsProperty
    public double elapsedMS;
    @JsProperty
    public int lastTime;
    @JsProperty
    public int speed;
    @JsProperty
    public boolean started;

    // PUBLIC METHODS
    @JsMethod
    public native Ticker add(ITickable tickable);
    @JsMethod
    public native Ticker addOnce(ITickable tickable);
    @JsMethod
    public native Ticker remove(ITickable tickable);
    @JsMethod
    public native void start();
    @JsMethod
    public native void stop();
    @JsMethod
    public native void update(double currentTime);

}
