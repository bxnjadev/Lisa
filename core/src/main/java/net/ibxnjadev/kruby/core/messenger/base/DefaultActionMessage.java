package net.ibxnjadev.kruby.core.messenger.base;

import net.ibxnjadev.kruby.core.messenger.base.ActionMessage;
import net.ibxnjadev.kruby.core.messenger.base.ActionMethod;

public class DefaultActionMessage implements ActionMessage {

    private final ActionMethod method;
    private final String id;
    private final String name;
    private final String action;

    public DefaultActionMessage(ActionMethod method, String id, String name, String action){
        this.method = method;
        this.id = id;
        this.name = name;
        this.action = action;
    }

    @Override
    public ActionMethod getMethod() {
        return method;
    }

    @Override
    public String getAction() {
        return action;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

}
