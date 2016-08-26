package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 21/08/16.
 */
@JsType(isNative = true, namespace = "PIXI")
public class Shader {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    @JsConstructor
    public Shader(ShaderManager shaderManager){};
    @JsConstructor
    public Shader(ShaderManager shaderManager, String vertexSrc, String fragmentSrc, Object uniforms, Object attributes){};

}
