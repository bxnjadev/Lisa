package net.ibxnjadev.kruby.core.cloud;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.ibxnjadev.kruby.core.model.Identifiable;
import net.ibxnjadev.kruby.helper.storage.RouteFile;

@RouteFile(
        route = "configuration.json"
)
@JsonDeserialize(as = CoreCloudConfiguration.class)
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
