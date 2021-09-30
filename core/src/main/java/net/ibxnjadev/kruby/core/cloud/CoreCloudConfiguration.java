package net.ibxnjadev.kruby.core.cloud;

import net.ibxnjadev.kruby.helper.storage.RouteFile;

import java.beans.ConstructorProperties;

@RouteFile(
        route = "configuration.json"
)
public class CoreCloudConfiguration implements CloudConfiguration {

    private String id;
    private String name;
    private String address;
    private int memory;
    private RemoteCloudConfiguration remoteCloudConfiguration;

    @ConstructorProperties({"id", "name", "address", "memory", "remote_configuration"})
    public CoreCloudConfiguration(String id,
                                  String name,
                                  String address,
                                  int memory,
                                  RemoteCloudConfiguration remoteCloudConfiguration) {
        this.id = id;
        this.name = name;
        this.address= address;
        this.memory = memory;
        this.remoteCloudConfiguration = remoteCloudConfiguration;
    }

    public CoreCloudConfiguration() {

    }

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
