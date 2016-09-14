package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 20/08/16.
 * A texture stores the information that represents an image or part of an image. It cannot be added
 * to the display list directly. Instead use it as the texture for a Sprite.
 * If no frame is provided then the whole image is used.
 * @see <a href="https://pixijs.github.io/docs/PIXI.Texture.html">Texture</a>
 */

@JsType(isNative = true, namespace = "PIXI")
public class Texture {

    @JsProperty
    public static Texture EMPTY;

    /**
     * This is the area of the BaseTexture image to actually copy to the Canvas / WebGL when rendering,
     * irrespective of the actual frame size or placement (which can be influenced by trimmed texture atlases)
     * TODO: check if frame or _frame property is valid
     */
    @JsProperty
    public Rectangle _frame;
    /**
     * The base texture that this texture uses.
     */
    @JsProperty
    public BaseTexture baseTexture;
    /**
     * The frame specifies the region of the base texture that this texture uses.
     */
    @JsProperty
    public Rectangle frame;
    /**
     * Does this Texture have any frame data assigned to it?
     */
    @JsProperty
    public boolean noFrame;
    /**
     * This is the area of original texture, before it was put in atlas
     */
    @JsProperty
    public Rectangle orig;
    /**
     * This will let a renderer know that a texture has been updated (used mainly for webGL uv updates)
     */
    @JsProperty
    public boolean requiresUpdate;
    /**
     * This is the trimmed area of original texture, before it was put in atlas
     */
    @JsProperty
    public Rectangle trim;
    /**
     * This will let the renderer know if the texture is valid. If it's not then it cannot be rendered.
     */
    @JsProperty
    public boolean valid;

    /**
     *
     * @param baseTexture
     * @param frame optional The rectangle frame of the texture to show
     * @param orig	optional The area of original texture
     * @param trim optional Trimmed rectangle of original texture
     * @param rotate indicates how the texture was rotated by texture packer.
     *               {@link sk.mrtn.pixi.client.GroupD8}
     */
    @JsConstructor
    public Texture(BaseTexture baseTexture, Rectangle frame, Rectangle orig,  Rectangle trim, Double rotate){}

    /**
     * Helper function that creates a new Texture based on the source you provide.
     * The soucre can be - frame id, image url, video url, canvae element, video element, base texture
     * @param source number | string | PIXI.BaseTexture | HTMLCanvasElement | HTMLVideoElement
     *               Source to create texture from
     * @return 	The newly created texture
     */
    @JsMethod
    public static native Texture from(Object source);

    /**
     * Helper function that creates a Texture object from the given image url.
     * If the image is not in the texture cache it will be created and loaded.
     * @param imageUrl The image url of the texture
     * @return The newly created texture
     */
    @JsMethod
    public static native Texture fromImage(String imageUrl);

    /**
     * Helper function that creates a Texture object from the given image url.
     * If the image is not in the texture cache it will be created and loaded.
     * @param imageUrl The image url of the texture
     * @param crossorigin Whether requests should be treated as crossorigin
     * @return The newly created texture
     */
    @JsMethod
    public static native Texture fromImage(String imageUrl, boolean crossorigin);

    /**
     * Helper function that creates a Texture object from the given image url.
     * If the image is not in the texture cache it will be created and loaded.
     * @param imageUrl The image url of the texture
     * @param crossorigin Whether requests should be treated as crossorigin
     * @param scaleMode See {@link sk.mrtn.pixi.client.ScaleModes} for possible values
     * @return The newly created texture
     */
    @JsMethod
    public static native Texture fromImage(String imageUrl, boolean crossorigin, int scaleMode);

    /**
     * Helper function that creates a sprite that will contain a texture from the
     * TextureCache based on the frameId The frame ids are created when a
     * Texture packer file has been loaded
     * @param frameId The frame Id of the texture in the cache
     * @return The newly created texture
     */
    @JsMethod
    public static native Texture fromFrame(String frameId);

    /**
     * Helper function that creates a new Texture based on the given canvas element.
     * @param canvas HTMLCanvasElement The canvas element source of the texture
     * @param scaleMode PIXI.SCALE_MODES.DEFAULT optional See {@link sk.mrtn.pixi.client.ScaleModes} for possible values
     * @return The newly created texture
     */
    @JsMethod
    public static native Texture fromCanvas(Object canvas, int scaleMode);

    /**
     * Helper function that creates a new Texture based on the given video element.
     * @param video HTMLVideoElement | string The URL or actual element of the video
     * @param scaleMode See {@link sk.mrtn.pixi.client.ScaleModes} for possible values
     * @return The newly created texture
     */
    @JsMethod
    public static native Texture fromVideo(Object video, int scaleMode);

    /**
     * Helper function that creates a new Texture based on the video url.
     * @param videoUrl URL of the video
     * @param scaleMode See {@link sk.mrtn.pixi.client.ScaleModes} for possible values
     * @return The newly created texture
     */
    @JsMethod
    public static native Texture fromVideoUrl(Object videoUrl, int scaleMode);

    /**
     * Adds a texture to the global utils.TextureCache. This cache is shared across the whole PIXI object.
     * @param texture The Texture to add to the cache.
     * @param id The id that the texture will be stored against.
     * @return
     */
    @JsMethod
    public static native void addTextureToCache(Texture texture, double id);

    /**
     * Remove a texture from the global utils.TextureCache.
     * @param id The id of the texture to be removed
     * @return
     */
    @JsMethod
    public static native Texture removeTextureFromCache(Object id);

    /**
     * Creates a new texture object that acts the same as this one.
     * @return
     */
    @JsMethod
    public native Texture clone();

    /**
     * Destroys this texture
     * @param destroyBase Whether to destroy the base texture as well
     */
    @JsMethod
    public native void destroy(boolean destroyBase);

    /**
     * Updates this texture on the gpu.
     */
    @JsMethod
    public native void update();
}
