package net.ibxnjadev.kruby.core.messenger.base;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Represent a action message received for the cloud
 */

@JsonDeserialize(as = DefaultActionMessage.class)
public interface ActionMessage {

    /**
     * @return the object id
     */

    String getId();

    /**
     * @return the object name
     */

    String getName();

    /**
     * @return Method
     */

    ActionMethod getMethod();

    /**
     * @return the action
     */

    String getAction();

}
