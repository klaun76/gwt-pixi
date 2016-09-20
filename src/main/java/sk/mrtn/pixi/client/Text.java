package sk.mrtn.pixi.client;

import elemental.html.CanvasElement;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 20/08/16.
 * @see <a href="https://pixijs.github.io/docs/PIXI.Sprite.html">Sprite</a>
 */
@JsType(isNative = true, namespace = "PIXI")
public class Text extends Sprite {

    /**
     * The canvas element that everything is drawn to
     */
    @JsProperty
    public CanvasElement canvas;

    /**
     * The canvas 2d context that everything is drawn with
     * TODO: check if true, seems like type in documentation
     */
    @JsProperty
    public CanvasElement context;

    /**
     * The resolution / device pixel ratio of the canvas. This is set automatically by the renderer.
     */
    @JsProperty
    public double resolution;

    /**
     * Set the style of the text. Set up an event listener
     * to listen for changes on the style object and mark the text as dirty.
     */
    @JsProperty
    public TextStyle style;

    /**
     * Set the copy for the text object. To split a line you can use '\n'.
     */
    @JsProperty
    public String text;

    @JsConstructor
    public Text(String text) {}

    @JsConstructor
    public Text(String text, TextStyle style) {}

    /**
     * calculates the bounds of the Text as a rectangle.
     * The bounds calculation takes the worldTransform into account.
     */
    @JsMethod
    public native void _calculateBounds();

}
