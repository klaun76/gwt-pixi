package sk.mrtn.pixi.client.particles;

import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.Texture;

/**
 * Created by klaun on 23/08/16.
 * Animated particle art cannot be strictly typed, because of nature of javascript
 * artdata as described in @see <a href="http://pixijs.github.io/pixi-particles/docs/classes/PIXI.particles.AnimatedParticle.html">Pixi site</a>
 *  {
 *      // framerate is required. It is the animation speed of the particle in frames per
 *      // second.
 *      // A value of "matchLife" causes the animation to match the lifetime of an individual
 *      // particle, instead of at a constant framerate. This causes the animation to play
 *      // through one time, completing when the particle expires.
 *      framerate: 6,
 *      // loop is optional, and defaults to false.
 *      loop: true,
 *      // textures is required, and can be an array of any (non-zero) length.
 *      textures: [
 *          // each entry represents a single texture that should be used for one or more
 *          // frames. Any strings will be converted to Textures with Texture.fromImage().
 *          // Instances of PIXI.Texture will be used directly.
 *          "animFrame1.png",
 *          // entries can be an object with a 'count' property, telling AnimatedParticle to
 *          // use that texture for 'count' frames sequentially.
 *          {
 *              texture: "animFrame2.png",
 *              count: 3
 *          },
 *          "animFrame3.png"
 *      ]
 *  }
 *  Thats why i decided to set framerate and textures to protected and allow
 *  access through series getters/setters to get better understanding what
 *  can be done
 *  TODO:consult with tomi for more elegant solution of oveloading methods
 */

@JsType()
public class AnimatedParticleArtTextureNames {

    @JsProperty
    protected Object framerate;

    @JsProperty
    public Boolean loop;

    @JsProperty
    protected Object[] textures;

    public void setFramerate(Integer framerate) {
        this.framerate = framerate;
    }

    /**
     *  A value of "matchLife" causes the animation to match the lifetime of an individual
     *  particle, instead of at a constant framerate. This causes the animation to play
     *  through one time, completing when the particle expires.
     */
    public void setFramerateToMatchLife() {
        framerate = "matchLife";
    }

    /**
     * sets new texture set composed from any object. in fact. check
     * class comment for further information concerning type of textures
     * @param untypedTextures
     */
    @JsIgnore
    public final void setTextures(Object... untypedTextures) {
        if (untypedTextures == null) {
            this.textures = new Object[0];
        } else {
            this.textures = untypedTextures;
        }
    }

    /**
     * sets new texture set composed from {@link sk.mrtn.pixi.client.Texture}
     * @param textures
     */
    @JsIgnore
    public void setTextures(Texture... textures) {
        this.textures = textures;
    }

    /**
     * sets new texture set composed from textureNames, because {@link sk.mrtn.pixi.client.particles.Emitter}
     * automatically converts Strings to {@link sk.mrtn.pixi.client.Texture}
     * @param textureNames
     */
    @JsIgnore
    public void setTextures(String... textureNames) {
        this.textures = textureNames;
    }

    /**
     * add texture as string to existing texture set
     * @param textureName
     */
    @JsIgnore
    public void addTexture(String textureName) {
        updateTextures(textureName);
    }

    /**
     * add texture as texture to existing texture set
     * @param texture
     */
    @JsIgnore
    public void addTexture(Texture texture) {
        updateTextures(texture);
    }

    /**
     * add textureName and count to existing texture set
     * texture will be repeated for count times within animation
     * @param textureName
     * @param count
     */
    @JsIgnore
    public void addTexture(String textureName, int count) {
        TextureWithCount textureWithCount = new TextureWithCount(textureName,count);
        updateTextures(textureWithCount);
    }

    /**
     * add texture and count to existing texture set
     * texture will be repeated for count times within animation
     * @param texture
     * @param count
     */
    @JsIgnore
    public void addTexture(Texture texture, int count) {
        TextureWithCount textureWithCount = new TextureWithCount(texture,count);
        updateTextures(textureWithCount);
    }

    @JsIgnore
    private void updateTextures(Object texture) {
        Object[] updatedTextures = new Object[getTextures().length + 1];
        for (int i = 0; i < updatedTextures.length; i++) {
            updatedTextures[i] = this.textures[i];
        }
        updatedTextures[textures.length] = texture;
        this.textures = updatedTextures;
    }

    @JsIgnore
    private Object[] getTextures() {
        if (this.textures == null) {
            this.textures = new Object[0];
        }
        return this.textures;
    }

    @JsType()
    public class TextureWithCount {
        @JsProperty
        Object texture;
        @JsProperty
        int count;
        @JsIgnore
        TextureWithCount(Object texture, int count){
            this.texture = texture;
            this.count = count;
        }
    }

}
