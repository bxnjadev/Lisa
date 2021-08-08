package net.ibxnjadev.kruby.core.setup;

import net.ibxnjadev.kruby.abstraction.cloud.CloudConfiguration;
import net.ibxnjadev.kruby.abstraction.redis.RedisClientProvider;
import net.ibxnjadev.kruby.abstraction.redis.RedisConfiguration;
import net.ibxnjadev.kruby.abstraction.setup.CloudSetupService;
import net.ibxnjadev.kruby.core.cloud.CoreCloudConfiguration;
import net.ibxnjadev.kruby.core.redis.CoreRedisClientProvider;
import net.ibxnjadev.kruby.core.util.ObjectFileStorageHelper;

public class DefaultCloudSetupService implements CloudSetupService {

    @Override
    public void setup() {

        CloudConfiguration configuration = null;

        if (!cloudIsConfigured()) {
            System.out.println("");
            System.out.println("Welcome to Kruby (Minecraft Cloud)");
            System.out.println("Setup cloud");
            System.out.println("");

            configuration = new CoreCloudConfiguration();

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
        redisClientProvider.establishConnection();

    }

}
