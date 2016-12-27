package sk.mrtn.pixi.client.stage;

import sk.mrtn.pixi.client.Container;

import javax.inject.Inject;

/**
 * Created by martinliptak on 27/12/2016.
 */
public class DefaultResponsiveController extends AResponsiveController {

    @Inject
    public DefaultResponsiveController(Container container) {
        super(container);
    }
}
