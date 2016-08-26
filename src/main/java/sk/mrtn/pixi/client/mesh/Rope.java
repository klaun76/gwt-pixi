package sk.mrtn.pixi.client.mesh;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.Point;
import sk.mrtn.pixi.client.Texture;

/**
 * Created by klaun on 21/08/16.
 */

@JsType(isNative = true, namespace = "PIXI.mesh")
public class Rope {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    @JsConstructor
    public Rope(Texture texture, Point[] points){};

}
