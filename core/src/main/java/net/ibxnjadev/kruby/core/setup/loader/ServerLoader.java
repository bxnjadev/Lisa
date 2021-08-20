package net.ibxnjadev.kruby.core.setup.loader;

import net.ibxnjadev.kruby.core.cloud.CloudService;
import net.ibxnjadev.kruby.core.server.Server;
import net.ibxnjadev.kruby.core.storage.local.LocalStorage;
import net.ibxnjadev.kruby.core.storage.local.LocalStorageProvider;

import java.io.File;

public class ServerLoader implements Loader {

    private final CloudService cloudService;
    private final LocalStorageProvider localStorageProvider;

    public ServerLoader(CloudService cloudService, LocalStorageProvider localStorageProvider) {
        this.cloudService = cloudService;
        this.localStorageProvider = localStorageProvider;
    }

    @Override
    public void load() {

        File directory = new File("servers/");
        LocalStorage<Server> localStorage = localStorageProvider.registerStorage(Server.class, directory);

        for (Server server : localStorage.values()) {
            cloudService.loadServer(server);
        }

    }

}
