package net.ibxnjadev.kruby.abstraction.cloud;

import net.ibxnjadev.kruby.abstraction.model.Identifiable;

public interface CloudConfiguration extends Identifiable {

    String getName();

    String getAddress();

    RemoteCloudConfiguration getRemoteCloudConfiguration();

}
