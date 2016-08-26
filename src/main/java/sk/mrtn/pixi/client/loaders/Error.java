package sk.mrtn.pixi.client.loaders;

/**
 * Created by klaun on 22/08/16.
 * TODO: js property not workink properly fix
 */

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class Error {

    @JsProperty
    public String message;

}
