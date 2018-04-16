package sk.mrtn.pixi.client.spine;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Skin is used to find an attachment for a slot by a name.
 * It is simply a map where the
 * key is a slot and a name and the
 * value is an attachment.
 *
 * The name used in the key does not have to be the name of the attachment.
 * This allows code and animations to set attachments by name without knowing what attachment is actually used.
 *
 * For example, a skin might have
 * a key [slot:head,name:head] and a value for that key [attachment:head-fish].
 * Another skin might have
 * a key [slot:head,name:head] and a value [attachment:head-donkey].
 * The skin allows the name in the skin ("head") to be used without knowing
 * which attachment is actually used ("head-fish" or "head-donkey").
 *
 * All attachments that are not in a skin in Spine will appear at runtime in a skin named "default".
 * When a skeleton needs to find an attachment by name, it first looks in its skin.
 * If the attachment is not found, then it looks in the default skin

 *
 *
 * Skin defines set of objects containing unique name and it's visual assets.
 * Each spine animation has DEFAULT skin.
 * All other skin could have name according your choice
 *
 * @author Tomas Ecker
 */
@JsType(isNative = true, namespace = "PIXI.spine.core")
public class Skin {

    @JsProperty
    public String name;

    @JsConstructor
    public Skin(String name){};

}

