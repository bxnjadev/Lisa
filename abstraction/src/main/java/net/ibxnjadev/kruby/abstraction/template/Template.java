package net.ibxnjadev.kruby.abstraction.template;

import net.ibxnjadev.kruby.abstraction.java.JavaVersion;
import net.ibxnjadev.kruby.abstraction.server.ServerType;
import net.ibxnjadev.kruby.abstraction.model.Identifiable;

/**
 * This class represent a template for create server
 */

public interface Template extends Identifiable {

    /**
     * The template name
      * @return template name
     */

    String getName();

    /**
     * The type of minecraft server used to create servers
     * @return the type minecraft server
     */

    ServerType getType();

    /**
     * The name the path jar for run the servers
     * @return name path jar
     */

    String getPathJar();

    /**
     * Update the path jar for create servers
     * @param pathJar the path for run servers
     */

    void updatePathJar(String pathJar);

    /**
     * Obtain the number of servers that will be created from this template when the cloud turns on
     * @return the number of servers that will be created by default
     */

    int getQuantityServersCreateByDefect();

    /**
     * Get the java version the template
     * @return the java version
     */

    JavaVersion getJavaVersion();

}
