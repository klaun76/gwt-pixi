package sk.mrtn.pixi.client.stage;

import elemental.dom.Node;

/**
 * Created by martinliptak on 22/09/16.
 */
public interface IStage {

    void initialize(int width, int height);

    void render();

    void setResponsiveStage(IResponsiveController responsiveStage);

    int getWidth();

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
