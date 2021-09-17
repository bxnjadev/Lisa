package net.ibxnjadev.kruby.core.cloud;

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
