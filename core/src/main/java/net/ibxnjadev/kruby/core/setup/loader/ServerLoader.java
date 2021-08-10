package net.ibxnjadev.kruby.core.setup.loader;

import net.ibxnjadev.kruby.core.cloud.CloudService;
import net.ibxnjadev.kruby.core.server.Server;
import net.ibxnjadev.kruby.core.storage.local.LocalStorage;
import net.ibxnjadev.kruby.core.storage.local.LocalStorageProvider;

import java.io.File;

public class ServerLoader implements Loader {

    private final CloudService cloudService;

    public ServerLoader(
            CloudService cloudService
    ) {
        this.cloudService = cloudService;
    }

    @Override
    public void load() {

        File directory = new File("servers");
        LocalStorage<Server> localStorage = LocalStorageProvider.registerStorage(Server.class, directory);

        for (Server server : localStorage.values()) {
            cloudService.loadServer(server);
        }

    }

}
