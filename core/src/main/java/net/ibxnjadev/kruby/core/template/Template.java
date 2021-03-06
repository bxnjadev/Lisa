package net.ibxnjadev.kruby.core.template;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.ibxnjadev.kruby.core.model.Identifiable;

import java.io.File;

@JsonDeserialize(as = CoreTemplate.class)
public interface Template extends Identifiable {

    /**
     * The template name
     *
     * @return template name
     */

    String getName();

    /**
     * Get the docker image template id
     *
     * @return the template image id
     */

    String getImageId();

    /**
     * Get the directory the template
     *
     * @return the template directory
     */

    File getDirectory();

    /**
     * The name the path jar for run the servers
     *
     * @return name path jar
     */

    String getPathJar();

    /**
     * Update the path jar for create servers
     *
     * @param pathJar the path for run servers
     */

    void updatePathJar(String pathJar);

    /**
     * The command start the server
     *
     * @return the command
     */

    String getCommandStart();

    /**
     * Obtain the number of servers that will be created from this template when the cloud turns on
     *
     * @return the number of servers that will be created by default
     */

    int getQuantityServersCreateByDefect();

    /**
     * Update the command for start the server
     *
     * @param commandStart the new command start
     */

    void updateCommandStart(String commandStart);

    /**
     * Set the template id when the image is created
     * @param imageId the image id
     */

    void setImageId(String imageId);

    /**
     * Set the directory template
     * @param directory the template directory
     */

    void setDirectory(File directory);

}
