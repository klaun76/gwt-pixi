package sk.mrtn.pixi.client.particles;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.Texture;

/**
 * Created by klaun on 23/08/16.
 */

public class AnimatedArticleArtTextures {

    @JsProperty
    public Integer framerate;

    @JsProperty
    public Boolean loop;

    @JsProperty
    public Texture[] textures;
}
