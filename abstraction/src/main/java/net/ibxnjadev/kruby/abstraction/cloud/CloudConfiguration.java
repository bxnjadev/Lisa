package net.ibxnjadev.kruby.abstraction.cloud;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.ibxnjadev.kruby.abstraction.model.Identifiable;

public interface CloudConfiguration extends Identifiable {

    String getName();

    String getAddress();

    @JsonProperty("remote_configuration")
    RemoteCloudConfiguration getRemoteCloudConfiguration();

}
