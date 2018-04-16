package sk.mrtn.pixi.client.spine;


public class SpineCrossVersionFix {

    public static native void fix() /*-{
        if (!$wnd.PIXI.loaders.Resource.TYPE) {
            $wnd.PIXI.loaders.Resource.TYPE = {};
        }
        $wnd.PIXI.loaders.Resource.TYPE.JSON = $wnd.PIXI.loaders.Resource.XHR_RESPONSE_TYPE.JSON;
    }-*/;
}
