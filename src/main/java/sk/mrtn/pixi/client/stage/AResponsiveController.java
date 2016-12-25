package sk.mrtn.pixi.client.stage;

import sk.mrtn.pixi.client.Container;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martinliptak on 02/10/16.
 */
public abstract class AResponsiveController implements IResponsiveController {

    private List<IResponsiveController> responsiveControllers;
    protected final Container container;

    public AResponsiveController(
            final Container container
    ){
        this.container = container;
        this.responsiveControllers = new ArrayList<>();
    }

    @Override
    public void onResized(double width, double height) {
        for (IResponsiveController responsiveController : this.responsiveControllers) {
            responsiveController.onResized(width, height);
        }
    }

    @Override
    public Container getContainer() {
        return this.container;
    }

    @Override
    public void onDetached() {

    }

    @Override
    public void addResponsiveController(IResponsiveController responsiveController) {
        this.responsiveControllers.add(responsiveController);
        this.container.addChild(responsiveController.getContainer());
    }

    @Override
    public void removeResponsiveController(IResponsiveController responsiveController) {
        if (!this.responsiveControllers.contains(responsiveController)) {
            throw new NullPointerException("controller does not exist");
        } else {
            this.responsiveControllers.remove(responsiveController);
            this.container.removeChild(responsiveController.getContainer());
        }
    }
}
