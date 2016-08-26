package sk.mrtn.pixi.client.ticker;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 20/08/16.
 */

@JsType(isNative = true, namespace = "PIXI.ticker")
public class Ticker {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    @JsConstructor
    public Ticker(){}

    // PUBLIC FIELDS
    @JsProperty
    public boolean autoStart;
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
    public native Ticker add(Object fn, Object context);
    @JsMethod
    public native Ticker addOnce(Object fn, Object context);
    @JsMethod
    public native Ticker remove(Object fn, Object context);
    @JsMethod
    public native void start();
    @JsMethod
    public native void stop();
    @JsMethod
    public native void update(double currentTime);

}
