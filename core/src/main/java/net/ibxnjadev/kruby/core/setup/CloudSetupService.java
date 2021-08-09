package net.ibxnjadev.kruby.core.setup;

import java.io.File;

/**
 * this class is in charge of the cloud setup
 */

public interface CloudSetupService extends SetupHandler {

    /**
     * Check if the cloud has already been configured in its initial state
     *
     * @return if the cloud was configured by default
     */

    default boolean cloudIsConfigured() {
        File servers = new File("servers");
        return servers.exists();
    }

    /**
     * Make setup all collection received for arguments
     * @param setups a collection of setups
     */

    default void setups(SetupHandler... setups) {
        for (SetupHandler setup : setups) {
            setup.setup();
      }
    }

}
