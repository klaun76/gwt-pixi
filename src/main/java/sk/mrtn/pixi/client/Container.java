package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import javax.inject.Inject;

/**
 * Created by klaun on 20/08/16.
 * A Container represents a collection of display objects.
 * It is the base class of all display objects that act as a container for other objects.
 * @see <a href="https://pixijs.github.io/docs/PIXI.Container.html">Container</a>
 */

@JsType(isNative = true, namespace = "PIXI")
public class Container extends DisplayObject {

    /**
     * The array of children of this container.
     */
    @JsProperty
    public DisplayObject[] children;

    /**
     * The height of the Container, setting this will actually
     * modify the scale to achieve the value set
     */
    @JsProperty
    public double height;

    /**
     * The width of the Container, setting this will actually
     * modify the scale to achieve the value set
     */
    @JsProperty
    public double width;

    @Inject
    @JsConstructor
    public Container(){}

    // PUBLIC METHODS
    @JsMethod
    public native void onChildrenChange();

    /**
     * Adds a child or multiple children to the container.
     * Multple items can be added like so:
     * myContainer.addChild(thinkOne, thingTwo, thingThree)
     * @param child - repeatable, The DisplayObject(s) to add to the container
     * @return The first child that was added.
     */
    @JsMethod
    public native DisplayObject addChild(DisplayObject... child);

    /**
     * Adds a child to the container at a specified index.
     * If the index is out of bounds an error will be thrown
     * @param child The child to add
     * @param index The index to place the child in
     * @return The child that was added.
     */
    @JsMethod
    public native DisplayObject addChildAt(DisplayObject child, int index);


    /**
     * Swaps the position of 2 Display Objects within this container.
     * @param child - First display object to swap
     * @param child2 - Second display object to swap
     */
    @JsMethod
    public native void swapChildren(DisplayObject child, DisplayObject child2);

    /**
     * TODO:check if can be null
     * Returns the index position of a child DisplayObject instance
     * @param child The DisplayObject instance to identify
     * @return The index position of the child display object to identify
     */
    @JsMethod
    public native Integer getChildIndex(DisplayObject child);

    /**
     * Changes the position of an existing child in the display object container
     * @param child - The child DisplayObject instance for which you want to change the index number
     * @param index - The resulting index number for the child display object
     */
    @JsMethod
    public native void setChildIndex(DisplayObject child, int index);

    /**
     * Returns the child at the specified index
     * @param index The index to get the child at
     * @return The child at the given index, if any.
     */
    @JsMethod
    public native DisplayObject getChildAt(int index);

    /**
     * Removes a child from the container.
     * @param child - The DisplayObject to remove
     * @return The child that was removed.
     */
    @JsMethod
    public native DisplayObject removeChild(DisplayObject child);

    /**
     * Removes a child from the specified index position.
     * @param index - The index to get the child from
     * @return The child that was removed.
     */
    @JsMethod
    public native DisplayObject removeChildAt(int index);

    /**
     * TODO:check behavior when parameters omitted, add overload methods
     * Removes all children from this container that are within the begin and end indexes.
     * @param beginIndex (default 0) The beginning position.
     * @param endIndex (this.children.length) The ending position. Default value is size of the container.
     */
    @JsMethod
    public native void removeChildren(Integer beginIndex, Integer endIndex);
    @JsMethod
    public native Texture generateTexture(Renderer renderer, int resolution, int scaleMode);

    /**
     * Removes all internal references and listeners as well
     * as removes children from the display list.
     * Do not use a Container after calling destroy.
     * TODO: test actual functionality and add Typed variable
     * @param options
     */
    @JsMethod
    public native void destroy(Object options);

    @JsMethod
    public native DisplayObject getChildByName(String  name);

}
