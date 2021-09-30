package net.ibxnjadev.kruby.core.setup.start;

import net.ibxnjadev.kruby.core.setup.SetupHandler;
import net.ibxnjadev.kruby.core.setup.loader.Loader;

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
     *
     * @param setups a collection of setups
     */

    default void setups(SetupHandler... setups) {
        for (SetupHandler setup : setups) {
            setup.setup();
        }
    }

    /**
     * Load all loaders of the cloud
     * @param loaders a collection of loaders
     */

    default void load(Loader... loaders) {
        for (Loader loader : loaders) {
            loader.load();
        }
    }

}
