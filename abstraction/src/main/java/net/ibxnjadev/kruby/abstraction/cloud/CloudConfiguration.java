package net.ibxnjadev.kruby.abstraction.cloud;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.ibxnjadev.kruby.abstraction.model.Identifiable;

public interface CloudConfiguration extends Identifiable {

    void setName(String name);

    void setAddress(String address);

    void setMemory(int memory);

    String getName();

    String getAddress();

    int getMemory();

    @JsonProperty("remote_configuration")
    RemoteCloudConfiguration getRemoteCloudConfiguration();

}
