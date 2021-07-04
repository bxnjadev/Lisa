package net.ibxnjadev.kruby.abstraction.cloud;

import net.ibxnjadev.kruby.abstraction.util.MathUtil;

/**
 * This class provide the new port for create minecraft server
 */

public interface CloudPortProvider {

    int providePort();

    void assignPort(int port);

    default int randomPort() {
        return MathUtil.getRandomNumberInRange(1000, 40000);
    }



}
