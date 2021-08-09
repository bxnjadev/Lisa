package net.ibxnjadev.kruby.core.cloud;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.ibxnjadev.kruby.core.annotations.RouteFile;
import net.ibxnjadev.kruby.core.model.Identifiable;

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
