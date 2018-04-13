package sk.mrtn.pixi.client.spine;

import com.google.gwt.resources.client.ResourcePrototype;
import com.google.gwt.resources.ext.ResourceGeneratorType;
import com.google.gwt.safehtml.shared.SafeUri;
import sk.mrtn.pixi.client.resources.spine.SkeletonResourceGenerator;

import java.util.List;
import java.util.Map;

@ResourceGeneratorType(SkeletonResourceGenerator.class)
public interface SkeletonResource extends ResourcePrototype {
    List<SafeUri> getUrisOfAtlasImages();

    Map<String, SafeUri> getImagesMap();

//    SkeletonData getSkeletonData();

//    TextureAtlas getTextureAtlas();
}
