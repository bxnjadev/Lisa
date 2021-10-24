package net.ibxnjadev.kruby.core.remote.message;

import java.beans.ConstructorProperties;

public class BackendAuthorizationResponseMessage {

    private final boolean connected;
    private final String messageError;

    private final String token;

    @ConstructorProperties(
            {"connected",
            "message_error",
            "token"}
    )
    public BackendAuthorizationResponseMessage(boolean connected,
                                               String messageError,
                                               String token) {
        this.connected = connected;
        this.messageError = messageError;
        this.token = token;
    }

    public boolean isConnected() {
        return connected;
    }

    public String getMessageError() {
        return messageError;
    }

    public String getToken() {
        return token;
    }

}
