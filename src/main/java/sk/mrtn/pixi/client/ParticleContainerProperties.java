package sk.mrtn.pixi.client;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import javax.inject.Inject;

/**
 * Created by klaun on 20/08/16.
 */

@JsType()
public class ParticleContainerProperties {

    // default false optional When true, scale be uploaded and applied.
    @JsProperty
    public boolean scale = false;

    // default false true optional  When true, position be uploaded and applied.
    @JsProperty
    public boolean position = true;

    // default false false optional When true, rotation be uploaded and applied.
    @JsProperty
    public boolean rotation = false;

    // default false false optional When true, uvs be uploaded and applied.
    @JsProperty
    public boolean uvs = false;

    // default false false optional When true, alpha be uploaded and applied.
    @JsProperty
    public boolean alpha = false;

    @Inject
    public ParticleContainerProperties(){}

    public final ParticleContainerProperties set(boolean scale,boolean position,boolean rotation, boolean uvs, boolean alpha) {
        this.scale = scale;
        this.position = position;
        this.rotation = rotation;
        this.uvs = uvs;
        this.alpha = alpha;
        return this;
    }
}
