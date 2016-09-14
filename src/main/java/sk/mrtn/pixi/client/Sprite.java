package sk.mrtn.pixi.client;

import jsinterop.annotations.*;

/**
 * Created by klaun on 20/08/16.
 * @see <a href="https://pixijs.github.io/docs/PIXI.Sprite.html">Sprite</a>
 */

@JsType(isNative = true, namespace = "PIXI")
public class Sprite extends Container {

    /**
     * constructor forced by descendant
     * TODO:check if necesary
     */
    protected Sprite() {
    }

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    /**
     * TODO: test
     * Helper function that creates a new sprite based on the source you provide.
     * The source can be - frame id, image url, video url,
     * canvas element, video element, base texture
     * @param source number | string | PIXI.BaseTexture |
     *               HTMLCanvasElement | HTMLVideoElement
     *               Source to create texture from
     * @return
     */
    @JsMethod
    public static native Texture from(Object source);

    /**
     * Helper function that creates a sprite that will contain a
     * texture from the TextureCache based on the frameId
     * The frame ids are created when a Texture packer file has been loaded
     * @param frameId The frame Id of the texture in the cache
     * @return A new Sprite using a texture from the texture cache matching the frameId
     */
    @JsMethod
    public static native Sprite fromFrame(String frameId);

    /**
     * Helper function that creates a sprite that will contain
     * a texture based on an image url
     * If the image is not in the texture cache it will be loaded
     * @param imageId - The image url of the texture
     * @return A new Sprite using a texture from the texture cache matching the image id
     */
    @JsMethod
    public static native Sprite fromImage(String imageId);

    /**
     * Helper function that creates a sprite that will contain
     * a texture based on an image url
     * If the image is not in the texture cache it will be loaded
     * @param imageId
     * @param crossorigin - if you want to specify the cross-origin parameter
     * @param scaleMode - if you want to specify the scale mode,
     *                    {@link sk.mrtn.pixi.client.ScaleModes} for possible values
     * @return A new Sprite using a texture from the texture cache matching the image id
     */
    @JsMethod
    public static native Sprite fromImage(String imageId, Boolean crossorigin, Integer scaleMode);

    @JsConstructor
    public Sprite(Texture texture){}

    // PUBLIC FIELDS

    /**
     * The anchor sets the origin point of the texture.
     * The default is 0,0 this means the texture's origin is the top left
     * Setting the anchor to 0.5,0.5 means the texture's origin is centered
     * Setting the anchor to 1,1 would mean the texture's origin point
     * will be the bottom right corner
     */
    @JsProperty
    public Point anchor;

    /**
     * The tint applied to the sprite. This is a hex value.
     * A value of 0xFFFFFF will remove any tint effect.
     * TODO: check if should be _tint or tint
     */
    @JsProperty
    public int _tint;

    /**
     * The blend mode to be applied to the sprite.
     * Apply a value of PIXI.BLEND_MODES.NORMAL to reset the blend mode.
     * {@link sk.mrtn.pixi.client.BlendModes}
     * TODO:test functionality
     */
    @JsProperty
    public int blendMode;

    /**
     * The shader that will be used to render the
     * sprite. Set to null to remove a current shader.
     * TODO:solve Filter vs Shader issue
     */
    @JsProperty
    public Shader shader;

    /**
     * The texture that the sprite is using
     */
    @JsProperty
    public Texture texture;

    /**
     * this is used to store the vertex data of the sprite (basically a quad)
     * TODO: test
     */
    @JsProperty
    public Double[] vertexData;

    /**
     * this is used to calculate the bounds of the object IF it is a trimmed sprite
     * TODO: test
     */
    @JsProperty
    public Double[] vertexTrimmedData;

    // PUBLIC METHODS

    /**
     * calculates worldTransform * vertices for a non texture with a trim.
     * store it in vertexTrimmedData
     * This is used to ensure that the true width and height of
     * a trimmed texture is respected
     */
    @JsMethod
    public native void calculateTrimmedVertices();

    /**
     * calculates worldTransform * vertices, store it in vertexData
     */
    @JsMethod
    public native void calculateVertices();

    /**
     * Tests if a point is inside this sprite
     * @param point the point to test
     * @return 	the result of the test
     */
    @JsMethod
    public native boolean containsPoint(Point point);

    /**
     * Destroys this sprite and optionally its texture and children
     * TODO: create and test options
     * @param options
     */
    @JsMethod
    public native void destroy(Object options);

    /**
     * overlay extra methods
     */
    @JsOverlay
    public final void clearFilters() {
        filters = null;
    }

    /**
     * Just first try how to work with typed filters and manage
     * adding/removing
     * TODO: create fully functional Typed manipulation of filters
     * @param filter
     */
    @JsOverlay
    public final void addFilter(Filter filter) {
        Filter[] nFilters = new Filter[getFilters().length+1];
        for (int i = 0; i < getFilters().length; i++) {
            nFilters[i] = getFilters()[i];
        }
        nFilters[nFilters.length-1]=filter;
        this.filters = nFilters;
    }

    @JsOverlay
    public final Filter[] getFilters() {
        if (filters == null) {
            filters = new Filter[0];
        }
        return this.filters;
    }

}
