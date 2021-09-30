package net.ibxnjadev.kruby.core.setup.shutdown;

import net.ibxnjadev.kruby.core.cloud.CloudService;
import net.ibxnjadev.kruby.core.cloud.CloudShutdown;
import net.ibxnjadev.kruby.core.docker.DockerClientProvider;
import net.ibxnjadev.kruby.core.redis.RedisClientProvider;
import redis.clients.jedis.Jedis;

import java.io.IOException;

public class CoreCloudShutdown implements CloudShutdown {

    private final CloudService cloudService;
    private final RedisClientProvider redisClientProvider;
    private final DockerClientProvider dockerClientProvider;

    public CoreCloudShutdown(
            CloudService cloudService,
            RedisClientProvider redisClientProvider,
            DockerClientProvider dockerClientProvider
    ) {
        this.cloudService = cloudService;
        this.redisClientProvider = redisClientProvider;
        this.dockerClientProvider = dockerClientProvider;
    }

    @Override
    public void shutdown() {

        cloudService.getAllServers()
                .forEach(server -> {

                    cloudService.stop(server);

                    if (!server.isStatic()) {
                        cloudService.deleteServer(server);
                    }
                });

        try (Jedis jedis = redisClientProvider.getClient().getResource()) {
            jedis.close();
        }

        try {
            dockerClientProvider.getClient().close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

}
