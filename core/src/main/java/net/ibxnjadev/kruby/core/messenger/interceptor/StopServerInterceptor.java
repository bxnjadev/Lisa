package net.ibxnjadev.kruby.core.messenger.interceptor;

import net.ibxnjadev.kruby.core.cloud.CloudService;
import net.ibxnjadev.kruby.core.messenger.base.ActionMessage;
import net.ibxnjadev.kruby.core.messenger.base.ActionServerProvider;
import net.ibxnjadev.kruby.core.server.Server;
import net.ibxnjadev.vmesseger.universal.Interceptor;

public class StopServerInterceptor implements Interceptor<ActionMessage> {

    private final CloudService cloudService;

    public StopServerInterceptor(CloudService cloudService) {
        this.cloudService = cloudService;
    }

    @Override
    public void subscribe(ActionMessage actionMessage) {
        Server server = ActionServerProvider.provide(cloudService, actionMessage);

        if (server != null) {
            cloudService.stop(server);
        }

    }

    @Override
    public boolean check(ActionMessage object) {
        return object.getAction().equals("STOP");
    }
}
