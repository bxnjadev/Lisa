package net.ibxnjadev.kruby.core.remote;

import net.ibxnjadev.kruby.core.cloud.CloudConfiguration;
import net.ibxnjadev.kruby.core.remote.message.AuthorizationMessage;
import net.ibxnjadev.kruby.core.remote.message.BackendAuthorizationResponseMessage;
import net.ibxnjadev.vmesseger.universal.Messenger;

public class CoreBackendConnectionHandler implements BackendConnectionHandler {

    private final CloudConfiguration cloudConfiguration;
    private final Messenger messenger;

    private static final String CHANNEL_AUTHORIZATION = "AUTHORIZATION";

    public CoreBackendConnectionHandler(
            CloudConfiguration cloudConfiguration,
            Messenger messenger
    ) {
        this.cloudConfiguration = cloudConfiguration;
        this.messenger = messenger;

        messenger.intercept(CHANNEL_AUTHORIZATION, BackendAuthorizationResponseMessage.class, (this::receiveAuthorizationResponse));
    }

    @Override
    public void connect(CloudConfiguration configuration) {
        messenger.sendMessage(CHANNEL_AUTHORIZATION, new AuthorizationMessage(cloudConfiguration, false));
    }

    @Override
    public void reconnect(CloudConfiguration configuration) {
        messenger.sendMessage(CHANNEL_AUTHORIZATION, new AuthorizationMessage(cloudConfiguration, true));
    }

    @Override
    public void receiveAuthorizationResponse(BackendAuthorizationResponseMessage response) {
        if (!response.isConnected()) {
            System.out.println(response.getMessageError());
            return;
        }


    }


}
