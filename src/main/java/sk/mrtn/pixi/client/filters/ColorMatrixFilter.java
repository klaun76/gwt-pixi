package sk.mrtn.pixi.client.filters;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.Filter;

/**
 * Created by klaun on 27/08/16.
 * The ColorMatrixFilter class lets you apply a 5x4 matrix transformation on the RGBA
 * color and alpha values of every pixel on your displayObject to produce a result
 * with a new set of RGBA color and alpha values. It's pretty powerful!
 */

@JsType(isNative = true, namespace = "PIXI.filters")
public class ColorMatrixFilter extends Filter {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    @JsConstructor
    public ColorMatrixFilter(){}


    /**
     * Create a Float32 Array and normalize the offset component to 0-1
     * @param matrix
     * @return
     */
    @JsMethod
    public native int[] _colorMatrix(int[] matrix);

    /**
     * Transforms current matrix and set the new one
     * @param matrix
     * @param multiply
     * @return
     */
    @JsMethod
    public native int[] _colorMatrix(int[] matrix, boolean multiply);

    /**
     * Multiplies two mat5's
     * @param out - (mat 5x4) the receiving matrix
     * @param a   - (mat 5x4) the first operand
     * @param b   - (mat 5x4) the second operand
     */
    @JsMethod
    public native void _multiply(int[] out, int[] a, int[] b);

    /**
     * Adjusts brightness
     * @param b value of the brigthness (0 is black)
     * @param multiply refer to ._loadMatrix() method
     */
    @JsMethod
    public native void brightness(double b, boolean multiply);

    /**
     * Set the matrices in grey scales
     * @param scale value of the grey (0 is black)
     * @param multiply
     * @return
     */
    @JsMethod
    public native void greyscale(double scale, boolean multiply);

    /**
     * is here probably due to human mistake, or i'm to wise 8-)
     * @param scale
     * @param multiply
     */
    @JsMethod
    public native void grayscale(double scale, boolean multiply);

    /**
     * Set the black and white matrice
     * @param multiply - Multiply the current matrix
     */
    @JsMethod
    public native void blackAndWhite(boolean multiply);

    /**
     * Set the hue property of the color
     * @param rotation in degrees
     * @param multiply
     */
    @JsMethod
    public native void hue(double rotation, boolean multiply);

    /**
     * Set the contrast matrix, increase the separation between dark and bright
     * Increase contrast : shadows darker and highlights brighter
     * Decrease contrast : bring the shadows up and the highlights down
     * @param amount value of the contrast
     * @param multiply
     */
    @JsMethod
    public native void contrast(double amount, boolean multiply);

    /**
     * Set the saturation matrix, increase the separation between colors
     * Increase saturation : increase contrast, brightness, and sharpness
     * @param amount
     * @param multiply
     */
    @JsMethod
    public native void saturate(double amount, boolean multiply);

    /**
     * Desaturate image (remove color)
     * @return
     */
    @JsMethod
    public native void desaturate();

    /**
     * Negative image (inverse of classic rgb matrix)
     * @param multiply
     */
    @JsMethod
    public native void negative(boolean multiply);

    /**
     * Sepia image
     * @param multiply
     */
    @JsMethod
    public native void sepia(boolean multiply);

    /**
     * Color motion picture process invented in 1916 (thanks Dominic Szablewski)
     * @param multiply
     */
    @JsMethod
    public native void technicolor(boolean multiply);

    /**
     * Polaroid filter
     * @param multiply
     */
    @JsMethod
    public native void polaroid(boolean multiply);

    /**
     * Filter who transforms : Red -> Blue and Blue -> Red
     * @param multiply
     */
    @JsMethod
    public native void toBGR(boolean multiply);

    /**
     * Color reversal film introduced by Eastman Kodak in 1935. (thanks Dominic Szablewski)
     * @param multiply
     * @return
     */
    @JsMethod
    public native void kodachrome(boolean multiply);

    /**
     * Brown delicious browni filter (thanks Dominic Szablewski)
     * @param multiply
     * @return
     */
    @JsMethod
    public native void browni(boolean multiply);

    // rest of filters are not docummented but found in objects when created for testing purpose
    @JsMethod
    public native void vintage(boolean multiply);
    @JsMethod
    public native void colorTone(double desaturation, double toned, double lightColor, double darkColor, boolean multiply);
    @JsMethod
    public native void night(double intensity, boolean multiply);
    @JsMethod
    public native void predator(double amount, boolean multiply);
    @JsMethod
    public native void lsd(boolean multiply);
    @JsMethod
    public native void reset();

}
