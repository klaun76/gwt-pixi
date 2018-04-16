package sk.mrtn.pixi.client.spine;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * AtlasAttachment Parsers hold instance of Atlas for future use with {@link SkeletonJson}
 *
 * @author Tomas Ecker
 */
@JsType(isNative = true, namespace = "PIXI.spine.core")
public class AtlasAttachmentLoader {

    @JsConstructor
    public AtlasAttachmentLoader(TextureAtlas atlas){};

}
