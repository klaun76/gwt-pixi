package sk.mrtn.pixi.client.mesh;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.Container;
import sk.mrtn.pixi.client.Texture;

/**
 * Created by klaun on 21/08/16.
 * TODO: controll and fix all fields and methods
 */
@JsType(isNative = true, namespace = "PIXI.mesh")
public class Mesh extends Container {

    @JsType(isNative = true)
    public class DrawMode {
        @JsProperty
        public int TRIANGLE_MESH;
        @JsProperty
        public int TRIANGLES;

    }

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    @JsConstructor
    public Mesh(Texture texture, Object vertices, Object uvs, Object indices, int drawMode){};

}