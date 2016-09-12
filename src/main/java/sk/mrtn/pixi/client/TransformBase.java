package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 12/09/16.
 * Generic class to deal with traditional 2D matrix transforms
 * @see <a href="https://pixijs.github.io/docs/PIXI.TransformBase.html">TransformBase</a>
 */
@JsType(isNative = true, namespace = "PIXI")
public class TransformBase {

    /**
     * The local matrix transform
     */
    @JsProperty
    public Matrix localTransform;

    /**
     * The global matrix transform. It can be swapped
     * temporarily by some functions like getLocalBounds()
     */
    @JsProperty
    public Matrix worldTransform;

    @JsConstructor
    public TransformBase(){}

    /**
     * TransformBase does not have decomposition,
     * so this function wont do anything
     */
    @JsMethod
    public native void updateLocalTransform();

    /**
     * Updates the values of the object and applies the parent's transform.
     * @param parentTransform - The transform of the parent of this object
     */
    @JsMethod
    public native void updateTransform(TransformBase parentTransform);
}
