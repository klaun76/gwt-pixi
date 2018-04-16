package sk.mrtn.pixi.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

import java.util.logging.Logger;

/**
 * Created by klaun on 21/04/16.
 */
public interface PixiLoader {

    class Statics {

        private static boolean injected;
        static final Resources res = GWT.create(Resources.class);

        public static void ensureInjected() {
            if (injected) {
                return;
            }

            injected = true;

            ScriptInjector.FromString pixi = ScriptInjector.fromString(res.pixi().getText());
            pixi.setWindow(ScriptInjector.TOP_WINDOW);
            pixi.inject();

            ScriptInjector.FromString pixiParticles = ScriptInjector.fromString(res.pixiParticles().getText());
            pixiParticles.setWindow(ScriptInjector.TOP_WINDOW);
            pixiParticles.inject();

            ScriptInjector.FromString pixiAnimatedParticle = ScriptInjector.fromString(res.animatedParticle().getText());
            pixiAnimatedParticle.setWindow(ScriptInjector.TOP_WINDOW);
            pixiAnimatedParticle.inject();

            ScriptInjector.FromString pathParticle = ScriptInjector.fromString(res.pathParticle().getText());
            pathParticle.setWindow(ScriptInjector.TOP_WINDOW);
            pathParticle.inject();

            ScriptInjector.FromString instance = ScriptInjector.fromString(res.pixiSpine_1_5_9().getText());
            instance.setWindow(ScriptInjector.TOP_WINDOW);
            instance.inject();

            Logger.getLogger("common").fine("PIXI loaded");
        }

        protected interface Resources extends ClientBundle {
//            @Source("pixi.min.js")
            @Source("pixi.js")
            TextResource pixi();

//            @Source("pixi-particles.min.js")
            @Source("pixi-particles.js")
            TextResource pixiParticles();

//            @Source("modules/animated-particle.min.js")
            @Source("modules/animated-particle.js")
            TextResource animatedParticle();

//            @Source("modules/path-particle.min.js")
            @Source("modules/path-particle.js")
            TextResource pathParticle();

            @Source("spine.1.5.9/pixi-spine.min.js")
            TextResource pixiSpine_1_5_9();
        }

    }

}
