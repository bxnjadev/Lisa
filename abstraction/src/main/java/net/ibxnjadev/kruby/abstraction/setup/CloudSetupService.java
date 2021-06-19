package net.ibxnjadev.kruby.abstraction.setup;

/**
 * this class is in charge of the cloud setup
 */

public interface CloudSetupService {

    /**
     * Create the default cloud configuration
     */

    void setup();

    /**
     * Check if the cloud has already been configured in its initial state
     * @return if the cloud was configured by default
     */

    boolean cloudIsConfigured();

}
