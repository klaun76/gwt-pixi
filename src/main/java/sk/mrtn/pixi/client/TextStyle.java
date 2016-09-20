package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 19/09/16.
 * A TextStyle Object decorates a Text Object. It can be shared between
 * multiple Text objects. Changing the style will update all text objects using it.
 * @see <a href="https://pixijs.github.io/docs/PIXI.Sprite.html">Sprite</a>
 */
@JsType(isNative = true, namespace = "PIXI")
public class TextStyle {

    @JsConstructor
    public TextStyle(TextOptions textOptions){}

    /**
     * Creates a new TextStyle object with the same values as this one.
     * Note that the only the properties of the object are cloned.
     * @return
     */
    @JsMethod
    public native TextStyle clone();

    /**
     * Resets all properties to the defaults specified in TextStyle.prototype._default
     */
    @JsMethod
    public native void reset();
}
