package sk.mrtn.pixi.client.stage;

import elemental.dom.Node;

/**
 * Created by martinliptak on 22/09/16.
 * wrapper for pixi stage. object can
 * be inserted in DOM and react to change of size
 */
public interface IStage {

    /**
     * object is created with default width and height
     * PIXI object is created and renderer chosen
     * ready for use
     * @param width
     * @param height
     */
    void initialize(int width, int height);

    /**
     * updates {@link IResponsiveController}'s size. All child
     * controlers are updated
     * then pixi stage is rendered
     */
    void render();

    /**
     * sets or resets basic {@link sk.mrtn.pixi.client.Container}
     * wrapped in {@link IResponsiveController}
     * @param responsiveStage
     */
    void setResponsiveStage(IResponsiveController responsiveStage);

    /**
     * returns width of stage
     * @return
     */
    int getWidth();

    /**
     * returns height of stage
     * @return
     */
    int getHeight();

    /**
     * method allows parent node to update child on resized
     * @param width - new width of parent
     * @param height - new height of parent
     */
    void onResized(double width, double height);

    /**
     * provides self as node which is attached to parent
     * @return
     */
    Node asNode();

}
