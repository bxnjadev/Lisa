package net.ibxnjadev.kruby.core.template;

import net.ibxnjadev.kruby.abstraction.java.JavaVersion;
import net.ibxnjadev.kruby.abstraction.server.ServerType;
import net.ibxnjadev.kruby.abstraction.template.Template;

import java.io.File;

public class CoreTemplate implements Template {

    private final String id;
    private final String name;
    private final String imageName;
    private final ServerType serverType;
    private final File directory;
    private String pathJar;
    private final int quantityServerCreatedPerDefect;
    private final JavaVersion javaVersion;

    public CoreTemplate(String id,
                        String name,
                        String imageName,
                        ServerType serverType,
                        File directory,
                        String pathJar,
                        int quantityServerCreatedPerDefect,
                        JavaVersion javaVersion) {
        this.id = id;
        this.name = name;
        this.imageName = imageName;
        this.serverType = serverType;
        this.directory = directory;
        this.pathJar = pathJar;
        this.quantityServerCreatedPerDefect = quantityServerCreatedPerDefect;
        this.javaVersion = javaVersion;
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
        return null;
    }

    @Override
    public void updateCommandStart(String commandStart) {

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
