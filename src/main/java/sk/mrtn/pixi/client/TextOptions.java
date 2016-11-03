package sk.mrtn.pixi.client;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by martinliptak on 19/09/16.
 */

public class TextOptions {

    /**
     * Alignment for multiline text ('left', 'center' or 'right'), does not affect single line text
     * default 'left'
     */
    @JsProperty
    public String align;

    /**
     * Indicates if lines can be wrapped within words, it needs wordWrap to be set to true
     * default false
     */
    @JsProperty
    public boolean breakWords;

    /**
     * Set a drop shadow for the text
     * default false
     */
    @JsProperty
    public boolean dropShadow;

    /**
     * Set a angle of the drop shadow
     * default Math.PI/6
     */
    @JsProperty
    public Double dropShadowAngle;

    /**
     * Set a shadow blur radius
     * default '0'
     */
    @JsProperty
    public double dropShadowBlur;

    /**
     * A fill style to be used on the dropshadow e.g 'red', '#00FF00'
     * default '#000000'
     */
    @JsProperty
    public String dropShadowColor;

    /**
     * Set a distance of the drop shadow
     * default 5
     */
    @JsProperty
    public double dropShadowDistance;

    /**
     * A canvas fillstyle that will be used on the
     * text e.g 'red', '#00FF00'. Can be an array to create
     * a gradient eg ['#000000','#FFFFFF'] @see MDN
     * default 'black'
     * string | Array.<string> | number | Array.<number> | CanvasGradient | CanvasPattern
     * TODO: tomi consult multiple values handling
     */
    @JsProperty
    public String[] fill;

    /**
     * If fills styles are supplied, this can change the type/direction of
     * the gradient. See PIXI.TEXT_GRADIENT for possible values
     * default PIXI.TEXT_GRADIENT.LINEAR_VERTICAL
     */
    @JsProperty
    public double fillGradientType;

    /**
     * The font family
     * default 'Arial'
     */
    @JsProperty
    public String fontFamily;

    /**
     * The font size (as a number it converts to px, but as a string, equivalents are '26px','20pt','160%' or '1.6em')
     * default 26
     * FIXME: multiple types number | string 26
     */
    @JsProperty
    public double fontSize;

    /**
     * The font style ('normal', 'italic' or 'oblique')
     * default 'normal'
     */
    @JsProperty
    public String fontStyle;

    /**
     * The font variant ('normal' or 'small-caps')
     * default 'normal'
     */
    @JsProperty
    public String fontVariant;

    /**
     * The font weight ('normal', 'bold', 'bolder', 'lighter' and '100', '200', '300', '400', '500', '600', '700', 800' or '900')
     * default 'normal'
     */
    @JsProperty
    public String fontWeight;

    /**
     * The amount of spacing between letters, default is 0
     */
    @JsProperty
    public double letterSpacing;

    /**
     * The line height, a number that represents the vertical space that a letter uses
     */
    @JsProperty
    public double lineHeight;

    /**
     * The lineJoin property sets the type of corner created, it can resolve
     * spiked text issues. Default is 'miter' (creates a sharp corner).
     * default 'miter'
     */
    @JsProperty
    public String lineJoin;

    /**
     * The miter limit to use when using the 'miter' lineJoin mode. This can reduce
     * or increase the spikiness of rendered text.
     * default 10
     */
    @JsProperty
    public double miterLimit;

    /**
     * Occasionally some fonts are cropped on top or bottom. Adding some padding will
     * prevent this from happening by adding padding to the top and bottom of text height.
     * default 0
     */
    @JsProperty
    public double padding;

    /**
     * A canvas fillstyle that will be used on the text stroke e.g 'blue', '#FCFF00'
     * default 'black'
     * FIXME: typed string | number
     */
    @JsProperty
    public double stroke;

    /**
     * A number that represents the thickness of the stroke.
     * Default is 0 (no stroke)
     */
    @JsProperty
    public double strokeThickness;

    /**
     * The baseline of the text that is rendered.
     * default 'alphabetic'
     */
    @JsProperty
    public String textBaseline;

    /**
     * Indicates if word wrap should be used
     * default false
     */
    @JsProperty
    public boolean wordWrap;

    /**
     * The width at which text will wrap, it needs {@link TextOptions#wordWrap}} to be set to true
     * default 100
     */
    @JsProperty
    public double wordWrapWidth;

}
