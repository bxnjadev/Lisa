package net.ibxnjadev.kruby.abstraction.template;

import net.ibxnjadev.kruby.abstraction.server.ServerType;
import net.ibxnjadev.kruby.abstraction.util.Identifiable;

public interface Template extends Identifiable {

    String getName();

    ServerType getType();

}
