package net.ibxnjadev.kruby.core.template;

import java.beans.ConstructorProperties;
import java.io.File;

public class CoreTemplate implements Template {

    private final String id;
    private final String name;
    private File directory;
    private String pathJar;
    private final int quantityServerCreatedPerDefect;
    private String imageId;
    private String commandStart;
    @ConstructorProperties({"id", "name", "directory", "pathJar", "quantityServersCreateByDefect", "imageId", "commandStart"})
    public CoreTemplate(String id,
                        String name,
                        File directory,
                        String pathJar,
                        int quantityServerCreatedPerDefect,
                        String imageId,
                        String commandStart) {
        this.id = id;
        this.name = name;
        this.directory = directory;
        this.pathJar = pathJar;
        this.quantityServerCreatedPerDefect = quantityServerCreatedPerDefect;
        this.imageId = imageId;
        this.commandStart = commandStart;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getImageId() {
        return imageId;
    }

    @Override
    public File getDirectory() {
        return directory;
    }

    @Override
    public String getPathJar() {
        return pathJar;
    }

    @Override
    public void updatePathJar(String pathJar) {
        this.pathJar = pathJar;
    }

    @Override
    public String getCommandStart() {
        return commandStart;
    }

    @Override
    public void updateCommandStart(String commandStart) {
        this.commandStart = commandStart;
    }

    @Override
    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @Override
    public void setDirectory(File directory) {
        this.directory = directory;
    }

    @Override
    public int getQuantityServersCreateByDefect() {
        return quantityServerCreatedPerDefect;
    }
    
}
