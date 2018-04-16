package sk.mrtn.pixi.client.spine;

import com.google.gwt.resources.client.ResourcePrototype;
import com.google.gwt.resources.ext.ResourceGeneratorType;
import com.google.gwt.safehtml.shared.SafeUri;
import sk.mrtn.pixi.client.resources.spine.SkeletonResourceGenerator;

import java.util.List;

/**
 * @author Tomas Ecker
 */
@ResourceGeneratorType(SkeletonResourceGenerator.class)
public interface SkeletonResource extends ResourcePrototype {
    List<SafeUri> getUrisOfAtlasImages();

    SkeletonData getSkeletonData();
}
