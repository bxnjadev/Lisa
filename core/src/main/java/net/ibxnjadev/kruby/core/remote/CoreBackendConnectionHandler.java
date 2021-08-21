package net.ibxnjadev.kruby.core.remote;

import net.ibxnjadev.kruby.core.cloud.CloudConfiguration;
import net.ibxnjadev.kruby.core.cloud.RemoteCloudConfiguration;

public class CoreBackendConnectionHandler implements BackendConnectionHandler {

    private final RemoteCloudConfiguration remoteCloudConfiguration;

    public CoreBackendConnectionHandler(
            RemoteCloudConfiguration remoteCloudConfiguration
    ) {
        this.remoteCloudConfiguration = remoteCloudConfiguration;
    }

    @Override
    public void sendConnection(CloudConfiguration configuration) {

    }

    @Override
    public void receiveReplyConnection(boolean connected) {
        if (connected) {
            remoteCloudConfiguration.establishConnected();
        }
    }
}
