package net.ibxnjadev.kruby.core.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientBuilder;

public class DefaultDockerClientProvider implements DockerClientProvider {

    private DockerClient dockerClient;

    @Override
    public void establishConnection() {
        dockerClient = DockerClientBuilder.getInstance("unix:///var/run/docker.sock").build();
    }

    @Override
    public DockerClient getClient() {
        return dockerClient;
    }
}
