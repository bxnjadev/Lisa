package net.ibxnjadev.kruby.core.remote.message;

import java.beans.ConstructorProperties;

public class BackendAuthorizationResponseMessage {

    private final boolean connected;
    private final String messageError;

    private final String key;

    @ConstructorProperties(
            {"connected",
            "message_error",
            "key"}
    )
    public BackendAuthorizationResponseMessage(boolean connected,
                                               String messageError,
                                               String key) {
        this.connected = connected;
        this.messageError = messageError;
        this.key = key;
    }

    public boolean isConnected() {
        return connected;
    }

    public String getMessageError() {
        return messageError;
    }

    public String getKey() {
        return key;
    }

}
