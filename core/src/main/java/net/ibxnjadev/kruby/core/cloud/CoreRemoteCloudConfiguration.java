package net.ibxnjadev.kruby.core.cloud;

public class CoreRemoteCloudConfiguration implements RemoteCloudConfiguration {

    @Override
    public void establishConnected() {

    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getKey() {
        return null;
    }
}
