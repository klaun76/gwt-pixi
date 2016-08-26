# Gwt-pixi
Gwt-pixi library is wrapper for the [PixiJS 3](https://github.com/pixijs/pixi.js) library and [Pixi Particles](https://github.com/pixijs/pixi-particles) using JsInterop and bits of Dagger 2. 

# How to use
Native javascript pixi.js is kept within project files for now. It will load automatically when module is initiated. Then just create Loader, load resources, wait for load end. Then create stage Container, Renderer and render the stage as shown below. Exactly as in native javascript when using pixi.
```java
    private void tempStart() {
        Loader aLoader = new Loader();
        aLoader.add("name",RES.imageResource().getSafeUri().asString());
        for (SafeUri safeUri : RES.textureAtlasResource().getSafeUris()) {
            aLoader.add(safeUri.asString());
        }
        aLoader.load((loader, resources) -> {
            // create basic objects and append to body
            stage = new Container();
            pixi = PixiEntryPoint.getPixi();
            renderer = this.pixi.autoDetectRenderer(800, 600);
            Browser.getDocument().getBody().appendChild(renderer.view);
            // create some children, set properties
            Sprite imageResource = createSprite(RES.bunny().getSafeUri().asString());
            imageResource.position.set(100,100);
            imageResource.anchor.set(0.5,0.5);
            stage.addChild(imageResource);
            // finally render
            renderer.render(stage);
        });
    }
```
# What is done until now
* I did pass through documentation of pixi and created most of interfaces. Some of them are unfinished, so there is plenty of Objects there.
* Module was tested within demo project where was:
    * pixi stage created
    * simple objects added
    * tested interaction on desktop
    * tested some filters with basic settings
    * tested particle systems with Particle AnimatedParticle (PathParticle is in TODO)
* TextureAtlasResource 
    * is new resource type which allows to work with [Texture Atlas](https://en.wikipedia.org/wiki/Texture_atlas) (coupled json + image) generated also by [Texture Packer](https://www.codeandweb.com/texturepacker)

# HOW TO USE TextureAtlasResource
* add resources to resource folder as standard resources (json and image file in same folder)
* prepare ClientBundle as usually
```java
public interface IResources extends ClientBundle {
    IResources impl =  GWT.create(IResources.class);
    
    @Source("single_file_resource_filename.json")
    TextureAtlasResource resource();
    /**
     * you have to import only first file when texture atlas produces several textures
     * it happens when selected resources do not fit in one texture
     */
    @Source("multi_file_resource_filename_0.json")
    TextureAtlasResource resource();
}
```
* TextureAtlasResource generator will take care of importing json file and also for binded image file. (texture atlas produces multi file exports when textures are too large. Thats why TextureAtlasResource is prepared to automatically search for sequential exports. 
```
multi_file_resource_filename_0.json + multi_file_resource_filename_0.png
multi_file_resource_filename_1.json + multi_file_resource_filename_1.png
```
* all above shown files should be inserted into resources but only first file needs to be added as resource. TextureAtlasResource is automatically looking for _x suffix of filename and tryies to find possible sequential resources.
* TextureAtlasResource provides interface with two methods:
  * List<SafeUri> getSafeUris();
    * for preload objects use PIXI.loaders.Loader represented as sk.mrtn.pixi.client.loaders.Loader.
  * List<String> getFrames();
    * to get hold of all frames in json description of file use this method

# What will be next ?
I'm working on small educational project. During development i'll try to improve library best i can. I already started to work on enumeration of filters to have more comfort. I want to have look at Ticker and optimised environment for frame animations. As soon as PIXI 4 is out i'll switch libraries.
    
# Note
Project is in early stage of development. Any suggestions or collaboration is appreciated. I would welcome suggestions concerning good coding manners. I'm life educated programmer (may be a strong word) and still learning Doing things right and also doing the right things

# Thanks
Dzekujem ci bars šumňe fišičku bo ši mi bars pomohnul a bez tebe bi ňebulo ňič z teho možne.
