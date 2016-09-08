package sk.mrtn.pixi.client.particles;

import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsProperty;
import sk.mrtn.pixi.client.Texture;

/**
 * Created by Patrik on 8. 9. 2016.
 *
 * Object that contains information about specific repetitive texture that represents animation frame
 * of PIXI animated particle art object (see {@link sk.mrtn.pixi.client.particles.AnimatedParticleArtTextureNames} for more information).
 * Repetitive means that this texture will be usent "count" - times sequentially in given animation.
 */
public class RepetitiveTexture {

    @JsProperty
    private Object texture;

    @JsProperty
    private int count;

    /**
     * Constructor using Texture specified by its name.
     * @param texture
     * @param count
     */
    @JsIgnore
    RepetitiveTexture(String texture, int count){
        this.texture = texture;
        this.count = count;
    }

    /**
     * Constructor using Texture specified directly by Texture object
     * @param texture
     * @param count
     */
    @JsIgnore
    public RepetitiveTexture(Texture texture, int count){
        this.texture = texture;
        this.count = count;
    }
}
