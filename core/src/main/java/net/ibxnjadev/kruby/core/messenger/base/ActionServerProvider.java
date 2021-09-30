package net.ibxnjadev.kruby.core.messenger.base;

import net.ibxnjadev.kruby.core.cloud.CloudService;
import net.ibxnjadev.kruby.core.server.Server;
import org.jetbrains.annotations.Nullable;

public class ActionServerProvider {

    @Nullable
    public static Server provide(CloudService service, ActionMessage action) {
        return action.getMethod() == ActionMethod.NAME ? service.getServerByName(action.getName()) : service.getServer(action.getId());
    }

}
