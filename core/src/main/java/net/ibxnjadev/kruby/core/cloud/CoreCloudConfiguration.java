package net.ibxnjadev.kruby.core.cloud;

import net.ibxnjadev.kruby.core.annotations.RouteFile;

@RouteFile(
        route = "configuration.json"
)
public class CoreCloudConfiguration implements CloudConfiguration {

    private String id;
    private String name;
    private String address;
    private int memory;
    private RemoteCloudConfiguration remoteCloudConfiguration;

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public int getMemory() {
        return memory;
    }

    @Override
    public RemoteCloudConfiguration getRemoteCloudConfiguration() {
        return remoteCloudConfiguration;
    }

    @Override
    public String getId() {
        return id;
    }

}
