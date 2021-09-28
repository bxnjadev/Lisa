package net.ibxnjadev.kruby.core.remote.message;

public class BackendAuthorizationResponseMessage {

    private final boolean connected;
    private final String messageError;

    public BackendAuthorizationResponseMessage(boolean connected,
                                               String messageError) {
        this.connected = connected;
        this.messageError = messageError;
    }

    public boolean isConnected() {
        return connected;
    }

    public String getMessageError() {
        return messageError;
    }

}
