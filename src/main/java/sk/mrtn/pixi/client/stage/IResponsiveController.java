package sk.mrtn.pixi.client.stage;

import sk.mrtn.pixi.client.Container;

/**
 * Created by martinliptak on 02/10/16.
 * Main purpose of this class/object is to wrap {@link Container}
 * react to resizing of parent controllers. and sending
 * resize behavior to added children
 */
public interface IResponsiveController {

    void onResized(double width, double height);

    Container getContainer();

    void onDetached();

    void addResponsiveController(IResponsiveController responsiveController);

    void removeResponsiveController(IResponsiveController responsiveController);

}
