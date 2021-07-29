package net.ibxnjadev.kruby.core.template;

import javafx.util.Builder;
import net.ibxnjadev.kruby.abstraction.java.JavaVersion;
import net.ibxnjadev.kruby.abstraction.server.ServerType;
import net.ibxnjadev.kruby.abstraction.template.Template;

import java.io.File;

/**
 * This class is a builder for build the object Template
 */

public interface TemplateBuilder extends Builder<Template> {

    /**
     * Set name to template
     * @param name the template name
     * @return the builder instance
     */

    TemplateBuilder setName(String name);

    /**
     * Set the docker image name
     * @param imageName the image docker
     * @return the builder instance
     */

    TemplateBuilder setImageName(String imageName);

    /**
     * Set the template directory
     * @param directory the template directory
     * @return the builder instance
     */

    TemplateBuilder setDirectory(File directory);

    /**
     * Set the type minecraft server
     * @param serverType the type minecraft server
     * @return the builder instance
     */

    TemplateBuilder setType(ServerType serverType);

    /**
     * Set the path jar
     * @param pathJar the path jar
     * @return the builder instance
     */

    TemplateBuilder setPathJar(String pathJar);

    /**
     * Set the quantity servers created per defect when the cloud is starting
     * @param quantityServerPerDefect the quantity servers created per defect
     * @return the builder instance
     */

    TemplateBuilder setQuantityServerPerDefect(int quantityServerPerDefect);

    /**
     * Set the java version for run the minecraft server
     * @param javaVersion the java version
     * @return the builder instance
     */

    TemplateBuilder setJavaVersion(JavaVersion javaVersion);

    static TemplateBuilder provideBuilder() {
        return new CoreTemplateBuilder();
    }

}
