package sk.mrtn.pixi.client.particles;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 23/08/16.
 */

@JsType()
public class AnimatedArticleArtTextureNames {

    @JsProperty
    public Integer framerate;

    @JsProperty
    public Boolean loop;

    @JsProperty
    public String[] textures;
}
