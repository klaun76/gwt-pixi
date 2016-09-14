package sk.mrtn.pixi.client.extras;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import sk.mrtn.pixi.client.FrameObject;
import sk.mrtn.pixi.client.Sprite;
import sk.mrtn.pixi.client.Texture;

/**
 * Created by klaun on 19/08/16.
 *
 * @see <a href="https://pixijs.github.io/docs/PIXI.extras.MovieClip.html">MovieClip</a>
 */
@JsType(isNative = true, namespace = "PIXI.extras")
public class MovieClip extends Sprite {

    // PUBLIC STATIC FIELDS

    /**
     * Whether or not the movie clip repeats after playing. default true
     */
    @JsProperty
    public boolean loop;

    /**
     * The speed that the MovieClip will play at. Higher is faster, lower is slower
     * default 1
     */
    @JsProperty
    public double animationSpeed;

    /**
     * The MovieClips current frame index
     */
    @JsProperty
    public int currentFrame;

    /**
     * Indicates if the MovieClip is currently playing
     */
    @JsProperty
    public boolean playing;

    /**
     * totalFrames is the total number of frames in the MovieClip. This is the
     * same as number of textures assigned to the MovieClip.
     */
    @JsProperty
    public int totalFrames;

    @JsConstructor
    public MovieClip(Texture[] textures) {
    }

    @JsConstructor
    public MovieClip(FrameObject[] textures) {
    }

    // PUBLIC STATIC METHODS

    /**
     * A short hand way of creating a movieclip from an array of frame ids
     *
     * @param frames the array of frames ids the movieclip will use as its texture frames
     * @return
     */
    @JsMethod
    public static native MovieClip fromFrames(String[] frames);

    /**
     * A short hand way of creating a movieclip from an array of image ids
     *
     * @param images - the array of image urls the movieclip will use as its texture frames
     * @return
     */
    @JsMethod
    public static native MovieClip fromImages(String[] images);

    /**
     * Plays the MovieClip
     */
    @JsMethod
    public native void play();

    /**
     * Stops the MovieClip and goes to a specific frame
     *
     * @param frameNumber - frame index to stop at
     */
    @JsMethod
    public native void gotoAndStop(int frameNumber);

    /**
     * Goes to a specific frame and begins playing the MovieClip
     *
     * @param frameNumber - frame index to start at
     */
    @JsMethod
    public native void gotoAndPlay(int frameNumber);

}
