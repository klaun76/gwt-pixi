package sk.mrtn.pixi.client.resources.textureatlas;

import com.google.gwt.resources.client.ResourcePrototype;
import com.google.gwt.resources.ext.ResourceGeneratorType;
import com.google.gwt.safehtml.shared.SafeUri;

import java.util.List;

/**
 * designed for resources generated from TexturePacker
 * (https://www.codeandweb.com/texturepacker)
 * resource is able to autodetect multiple resources
 * automatically generated from texture packer
 * For example packer generates resources such as:
 * my_resource_0.json
 * my_resource_1.json
 * my_resource_2.json
 * in Client bundle only first file must be added as resource
 *   @Source("my_resource_0.json")
 *   TextureAtlasResource goldAnim();
 * remaining files will be located automatically when
 * all resources located in same directory.
 * Then just iterate over all myClientBundle.getSafeUris()
 * and load them to PIXI.loaders.Loader
 * represented as sk.mrtn.pixi.client.loaders.Loader
 *
 * Special thanks goes to fishi for showing me
 * how to do this litlle piece of magic :-)
 * @author klaun
 */
@ResourceGeneratorType(TextureAtlasGenerator.class)
public interface TextureAtlasResource extends ResourcePrototype {
    List<SafeUri> getSafeUris();
    List<String> getFrames();
}
