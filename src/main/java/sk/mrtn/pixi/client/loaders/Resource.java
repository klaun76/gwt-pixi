package sk.mrtn.pixi.client.loaders;

/**
 * Created by klaun on 22/08/16.
 */

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class Resource {

    @JsProperty
    public String name;
    @JsProperty
    public String url;

}
