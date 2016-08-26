package sk.mrtn.pixi.client;

import com.google.gwt.core.client.JavaScriptObject;
import sk.mrtn.pixi.client.particles.config.EmitterConfig;

/**
 * Created by klaun on 23/08/16.
 * TODO: Tomi konzultacia
 */
public class PixiUtils {

    // at the time I did not know how to cast extept this cheating :-(
    public static native EmitterConfig castToEmitter(JavaScriptObject jConfig) /*-{
        return jConfig;
    }-*/;
}
