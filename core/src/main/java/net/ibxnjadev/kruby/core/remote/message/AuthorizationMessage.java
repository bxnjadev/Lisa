package net.ibxnjadev.kruby.core.remote.message;

import net.ibxnjadev.kruby.core.cloud.CloudConfiguration;

public class AuthorizationMessage {

    private final CloudConfiguration cloudConfiguration;
    private final boolean reconnect;

    public AuthorizationMessage(CloudConfiguration cloudConfiguration, boolean reconnect) {
        this.cloudConfiguration = cloudConfiguration;
        this.reconnect = reconnect;
    }

    public CloudConfiguration getCloudConfiguration() {
        return cloudConfiguration;
    }

    public boolean isReconnect() {
        return reconnect;
    }

}
