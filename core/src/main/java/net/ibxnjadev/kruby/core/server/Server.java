package net.ibxnjadev.kruby.core.server;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.ibxnjadev.kruby.core.model.Identifiable;

import java.util.function.Consumer;

@JsonDeserialize(as = CoreServer.class)
public interface Server extends Identifiable {

    /**
     * Get the container id the docker
     * @return the container id
     */

    String getContainerId();

    /**
     * Get the template name
     * @return the template name of server
     */

    String getTemplateName();

    /**
     * Get the id the template
     * @return the id the template of server
     */

    String getTemplateId();

    /**
     * Get if the server is static
     * @return the server if static
     */

    boolean isStatic();

    /**
     * Get the server name
     * @return the server name
     */

    String getName();

    /**
     * Get the port server
     * @return the port server
     */

    int getPort();

}
