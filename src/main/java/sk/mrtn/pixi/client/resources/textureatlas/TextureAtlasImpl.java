package sk.mrtn.pixi.client.resources.textureatlas;

import com.google.gwt.safehtml.shared.SafeUri;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * designed for resources generated from TexturePacker
 * (https://www.codeandweb.com/texturepacker)
 * Special thanks goes to fishi for showing me
 * how to do this litlle piece of magic :-)
 * @author klaun
 */
public class TextureAtlasImpl implements TextureAtlasResource {

    private final String name;
    private final List<SafeUri> safeUri;
    private final List<String> frames;

    public TextureAtlasImpl(
            final String name,
            final SafeUri[] safeUri,
            final String[] frames
    ) {

        this.name = name;
        this.safeUri = Arrays.asList(safeUri);
        this.frames = Collections.unmodifiableList(Arrays.asList(frames));
    }

    public List<String> getFrames() {
        return this.frames;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<SafeUri> getSafeUris() {
        return this.safeUri;
    }
}
