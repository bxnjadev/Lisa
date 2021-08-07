package net.ibxnjadev.kruby.core.setup;

import net.ibxnjadev.kruby.abstraction.cloud.CloudConfiguration;
import net.ibxnjadev.kruby.abstraction.redis.RedisClientProvider;
import net.ibxnjadev.kruby.abstraction.redis.RedisConfiguration;
import net.ibxnjadev.kruby.abstraction.setup.CloudSetupService;
import net.ibxnjadev.kruby.core.redis.CoreRedisClientProvider;
import net.ibxnjadev.kruby.core.util.ObjectFileStorageHelper;

public class DefaultCloudSetupService implements CloudSetupService {

    private CloudConfiguration configuration = null;

    @Override
    public void setup() {

        if (!cloudIsConfigured()) {
            System.out.println("");
            System.out.println("Welcome to Kruby (Minecraft Cloud)");
            System.out.println("Setup cloud");
            System.out.println("");

            setups(
                    new SetupDirectory(),
                    new SetupCloudConfiguration(configuration),
                    new SetupDockerfiles(),
                    new SetupRedis()
            );
        }

        configuration = ObjectFileStorageHelper.load(CloudConfiguration.class);
        RedisConfiguration redisConfiguration = ObjectFileStorageHelper.load(RedisConfiguration.class);

        RedisClientProvider redisClientProvider = new CoreRedisClientProvider(redisConfiguration);
        redisClientProvider.getClient();

    }

}
