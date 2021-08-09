package net.ibxnjadev.kruby.core.template;

import net.ibxnjadev.kruby.core.java.JavaVersion;
import net.ibxnjadev.kruby.core.server.ServerType;
import net.ibxnjadev.kruby.core.util.UtilId;

import java.io.File;

public class CoreTemplateBuilder implements TemplateBuilder {

    private String name;
    private String imageName;
    private ServerType serverType;
    private String pathJar;
    private File directory;
    private int quantityServerPerDefect = 1;
    private JavaVersion javaVersion = JavaVersion.V_8;

    @Override
    public TemplateBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public TemplateBuilder setImageName(String imageName) {
        this.imageName = imageName;
        return this;
    }

    @Override
    public TemplateBuilder setDirectory(File directory) {
        this.directory = directory;
        return this;
    }

    @Override
    public TemplateBuilder setType(ServerType serverType) {
        this.serverType = serverType;
        return this;
    }

    @Override
    public TemplateBuilder setPathJar(String pathJar) {
        this.pathJar = pathJar;
        return this;
    }

    @Override
    public TemplateBuilder setQuantityServerPerDefect(int quantityServerPerDefect) {
        this.quantityServerPerDefect = quantityServerPerDefect;
        return this;
    }

    @Override
    public TemplateBuilder setJavaVersion(JavaVersion javaVersion) {
        this.javaVersion = javaVersion;
        return this;
    }

    @Override
    public Template build() {

        String randomId = UtilId.randomId();

        return new CoreTemplate(
                randomId,
                name,
                imageName,
                serverType,
                directory,
                pathJar,
                quantityServerPerDefect,
                javaVersion,
                null
        );
    }
}
