package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import javax.inject.Inject;

/**
 * Created by klaun on 20/08/16.
 */

@JsType(isNative = true, namespace = "PIXI")
public class Container extends DisplayObject {

    @Inject
    @JsConstructor
    public Container(){};

    // PUBLIC FIELDS
    @JsProperty
    public DisplayObject[] children;

    // PUBLIC METHODS
    @JsMethod
    public native void onChildrenChange();
    @JsMethod
    public native DisplayObject addChild(DisplayObject child);
    @JsMethod
    public native DisplayObject addChildAt(DisplayObject child, int index);
    @JsMethod
    public native void swapChildren(DisplayObject child, DisplayObject child2);
    @JsMethod
    public native int getChildIndex(DisplayObject child);
    @JsMethod
    public native void setChildIndex(DisplayObject child, int index);
    @JsMethod
    public native DisplayObject getChildAt(int index);
    @JsMethod
    public native DisplayObject removeChild(DisplayObject child);
    @JsMethod
    public native DisplayObject removeChildAt(int index);
    @JsMethod
    public native void removeChildren(int beginIndex, int endIndex);
    @JsMethod
    public native Texture generateTexture(Renderer renderer, int resolution, int scaleMode);
    @JsMethod
    public native Rectangle getBounds();
    @JsMethod
    public native void destroy(boolean destroyChildren);
    @JsMethod
    public native DisplayObject getChildByName(String  name);
}
