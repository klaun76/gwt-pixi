package sk.mrtn.pixi.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * Created by klaun on 21/08/16.
 */
@JsType(isNative = true, namespace = "PIXI")
public class GraphicsData {

    // PUBLIC STATIC FIELDS

    // PUBLIC STATIC METHODS

    @JsConstructor
    public GraphicsData(double lineWidth, double lineColor, double lineAlpha, double fillColor, double fillAlpha, boolean fill, IShape shape){};

}