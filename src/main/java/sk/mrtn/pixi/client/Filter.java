package sk.mrtn.pixi.client;

import com.google.gwt.core.client.JavaScriptObject;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 27/08/16.
 * TODO: should extend shader
 */

@JsType(isNative = true, namespace = "PIXI")
public class Filter {

    // PUBLIC STATIC FIELDS
    /**
     * The default fragment shader source
     */
    @JsProperty
    public static String defaultVertexSrc;
    /**
     * The default vertex shader source
     */
    @JsProperty
    public static String defaultFragmentSrc;

    @JsConstructor
    public Filter(){}

    /**
     *
     * @param vertexSrc The source of the vertex shader.
     * @param fragmentSrc Custom uniforms to use to augment the built-in ones.
     * @param uniforms The source of the fragment shader.
     */
    @JsConstructor
    public Filter(String vertexSrc, JavaScriptObject fragmentSrc, String uniforms){}

    // PUBLIC FIELDS described in documentation

    /**
     * If enabled is true the filter is applied, if false it will not.
     */
    @JsProperty
    public boolean enabled;

    /**
     * The fragment shader.
     */
    @JsProperty
    public String fragmentSrc;

    /**
     * The padding of the filter. Some filters require extra space
     * to breath such as a blur. Increasing this will add extra
     * width and height to the bounds of the object that the filter
     * is applied to.
     */
    @JsProperty
    public int padding;

    /**
     * The resolution of the filter. Setting this to be lower
     * will lower the quality but increase the performance of the filter.
     */
    @JsProperty
    public double resolution;

    /**
     * The vertex shader.
     */
    @JsProperty
    public String vertexSrc;
    // PUBLIC FIELDS found when tested object
    @JsProperty
    public int blendMode;
    @JsProperty
    public Object uniformData;
    @JsProperty
    public Object uniforms;
    @JsProperty
    public Object glShaders;
    @JsProperty
    public int glShaderKey;

    // PUBLIC METHODS
    @JsMethod
    public native Object apply(Object filterManager, Object input, Object output, Object clear);

}
