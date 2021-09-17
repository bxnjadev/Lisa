package net.ibxnjadev.kruby.core.template;

import net.ibxnjadev.kruby.helper.UtilId;

import java.io.File;

public class CoreTemplateBuilder implements TemplateBuilder {

    private String name;
    private String imageName;
    private String pathJar;
    private String commandStart;
    private File directory;
    private int quantityServerPerDefect = 1;

    @Override
    public TemplateBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public TemplateBuilder imageName(String imageName) {
        this.imageName = imageName;
        return this;
    }

    @Override
    public TemplateBuilder directory(File directory) {
        this.directory = directory;
        return this;
    }

    @Override
    public TemplateBuilder pathJar(String pathJar) {
        this.pathJar = pathJar;
        return this;
    }

    @Override
    public TemplateBuilder commandStart(String commandStart) {
        this.commandStart = commandStart;
        return this;
    }

    @Override
    public TemplateBuilder quantityServerPerDefect(int quantityServerPerDefect) {
        this.quantityServerPerDefect = quantityServerPerDefect;
        return this;
    }

    @Override
    public Template build() {

        String randomId = UtilId.randomId();

        return new CoreTemplate(
                randomId,
                name,
                directory,
                pathJar,
                quantityServerPerDefect,
                null,
                commandStart
        );
    }
}
