
package net.ibxnjadev.kruby.core.messenger.interceptor;

import net.ibxnjadev.kruby.core.cloud.CloudService;
import net.ibxnjadev.kruby.core.messenger.base.ActionMessage;
import net.ibxnjadev.kruby.core.messenger.base.ActionMethod;
import net.ibxnjadev.kruby.core.messenger.base.ActionServerProvider;
import net.ibxnjadev.kruby.core.server.Server;
import net.ibxnjadev.vmesseger.universal.Interceptor;

public class DeleteServerInterceptor implements Interceptor<ActionMessage> {

    private static final String ACTION = "DELETE";

    private final CloudService cloudService;

    public DeleteServerInterceptor(CloudService cloudService) {
        this.cloudService = cloudService;
    }

    @Override
    public void subscribe(ActionMessage actionMessage) {
        Server server = ActionServerProvider.provide(cloudService, actionMessage);

        if (server != null) {
            cloudService.deleteServer(server);
        }

    }

    @Override
    public boolean check(ActionMessage object) {
        return object.getAction().equals(ACTION);
    }
}
