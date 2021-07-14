package net.ibxnjadev.kruby.abstraction.cloud;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.ibxnjadev.kruby.abstraction.annotations.RouteFile;
import net.ibxnjadev.kruby.abstraction.model.Identifiable;

@RouteFile(
        route = "configuration.json"
)
public interface CloudConfiguration extends Identifiable {

    void setId(String id);

    void setName(String name);

    void setAddress(String address);

    void setMemory(int memory);

    String getName();

    String getAddress();

    int getMemory();

    @JsonProperty("remote_configuration")
    RemoteCloudConfiguration getRemoteCloudConfiguration();

}
