package net.ibxnjadev.kruby.core.template;

import java.io.File;

/**
 * This class is a builder for build the object Template
 */

public interface TemplateBuilder {

    /**
     * Set name to template
     * @param name the template name
     * @return the builder instance
     */

    TemplateBuilder name(String name);

    /**
     * Set the docker image name
     * @param imageName the image docker
     * @return the builder instance
     */

    TemplateBuilder imageName(String imageName);

    /**
     * Set the template directory
     * @param directory the template directory
     * @return the builder instance
     */

    TemplateBuilder directory(File directory);

    /**
     * Set the path jar
     * @param pathJar the path jar
     * @return the builder instance
     */

    TemplateBuilder pathJar(String pathJar);

    /**
     * Set the command start
     * @param commandStart the command start
     * @return the builder instance
     */

    TemplateBuilder commandStart(String commandStart);

    /**
     * Set the quantity servers created per defect when the cloud is starting
     * @param quantityServerPerDefect the quantity servers created per defect
     * @return the builder instance
     */

    TemplateBuilder quantityServerPerDefect(int quantityServerPerDefect);

    /**
     * Build the template object based in the actual object builder
     * @return the new template created to base the actual builder
     */

    Template build();

    static TemplateBuilder provideBuilder() {
        return new CoreTemplateBuilder();
    }

}
