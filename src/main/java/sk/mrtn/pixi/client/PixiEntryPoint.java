package sk.mrtn.pixi.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import jsinterop.annotations.JsMethod;
import sk.mrtn.pixi.client.parsers.InterfaceReader;

/**
 * Created by klaun on 11/08/16.
 */
public class PixiEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
    }

    public static PIXI getPixi() {
        PixiLoader.Statics.ensureInjected();
        return getPixi0();
    }

    public static native PIXI getPixi0() /*-{
        return $wnd.PIXI;
    }-*/;

}
