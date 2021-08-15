package net.ibxnjadev.kruby.core.template;

import net.ibxnjadev.kruby.core.java.JavaVersion;
import net.ibxnjadev.kruby.core.server.ServerType;

import java.beans.ConstructorProperties;
import java.io.File;

public class CoreTemplate implements Template {

    private final String id;
    private final String name;
    private final String imageName;
    private final ServerType serverType;
    private File directory;
    private String pathJar;
    private final int quantityServerCreatedPerDefect;
    private final JavaVersion javaVersion;
    private String imageId;
    private String commandStart;
    @ConstructorProperties({"id", "name", "imageName", "serverType", "directory", "pathJar", "quantityServerCreatedPerDefect", "javaVersion", "imageId", "commandStart"})
    public CoreTemplate(String id,
                        String name,
                        String imageName,
                        ServerType serverType,
                        File directory,
                        String pathJar,
                        int quantityServerCreatedPerDefect,
                        JavaVersion javaVersion,
                        String imageId,
                        String commandStart) {
        this.id = id;
        this.name = name;
        this.imageName = imageName;
        this.serverType = serverType;
        this.directory = directory;
        this.pathJar = pathJar;
        this.quantityServerCreatedPerDefect = quantityServerCreatedPerDefect;
        this.javaVersion = javaVersion;
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
    public String getImageName() {
        return imageName;
    }

    @Override
    public ServerType getType() {
        return serverType;
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

    @Override
    public JavaVersion getJavaVersion() {
        return javaVersion;
    }

}
