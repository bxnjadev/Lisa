package net.ibxnjadev.kruby.abstraction.template;

import net.ibxnjadev.kruby.abstraction.java.JavaVersion;
import net.ibxnjadev.kruby.abstraction.server.ServerType;
import net.ibxnjadev.kruby.abstraction.model.Identifiable;

public interface Template extends Identifiable {

    String getName();

    ServerType getType();

    String getPathJar();

    void updatePathJar(String pathJar);

    int getQuantityServersCreatePerDefect();

    JavaVersion getJavaVersion();

}
