package net.ibxnjadev.kruby.core.setup.start;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import net.ibxnjadev.kruby.core.cloud.*;
import net.ibxnjadev.kruby.core.docker.DefaultDockerClientProvider;
import net.ibxnjadev.kruby.core.docker.DockerClientProvider;
import net.ibxnjadev.kruby.core.mapper.ObjectMapperProvider;
import net.ibxnjadev.kruby.core.mapper.deserialize.ServerDeserialize;
import net.ibxnjadev.kruby.core.redis.RedisClientProvider;
import net.ibxnjadev.kruby.core.redis.RedisConfiguration;
import net.ibxnjadev.kruby.core.redis.CoreRedisClientProvider;
import net.ibxnjadev.kruby.core.server.Server;
import net.ibxnjadev.kruby.core.setup.*;
import net.ibxnjadev.kruby.core.setup.loader.ServerLoader;
import net.ibxnjadev.kruby.core.setup.loader.TemplateLoader;
import net.ibxnjadev.kruby.core.storage.local.LocalStorageProvider;
import net.ibxnjadev.kruby.core.template.CoreTemplateService;
import net.ibxnjadev.kruby.core.template.DockerTemplateHandler;
import net.ibxnjadev.kruby.core.template.TemplateService;
import net.ibxnjadev.kruby.core.terminal.TerminalProvider;
import net.ibxnjadev.kruby.core.util.InputExecutor;
import net.ibxnjadev.kruby.core.util.ObjectFileStorageHelper;

public class DefaultCloudSetupService implements CloudSetupService {

    @Override
    public void setup() {

        CloudConfiguration configuration = null;

        TerminalProvider terminalProvider = TerminalProvider.defaultTerminal();

        if (terminalProvider == null) {
            return;
        }

        InputExecutor inputExecutor = InputExecutor.defaultExecutor(terminalProvider.getLineReader());

        if (!cloudIsConfigured()) {
            System.out.println("");
            System.out.println("Welcome to Kruby (Minecraft Cloud)");
            System.out.println("Setup cloud");
            System.out.println("");

            configuration = new CoreCloudConfiguration();

            setups(
                    new SetupDirectory(),
                    new SetupCloudConfiguration(configuration,  inputExecutor),
                    new SetupDockerfiles(),
                    new SetupRedis()
            );
        }

        DockerClientProvider dockerClientProvider = new DefaultDockerClientProvider();
        dockerClientProvider.establishConnection();

        ObjectMapper mapperDefinitive = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(Server.class, new ServerDeserialize(dockerClientProvider));
        mapperDefinitive.registerModule(simpleModule);

        ObjectMapperProvider objectMapperProvider = new ObjectMapperProvider(mapperDefinitive);

        configuration = ObjectFileStorageHelper.load(CloudConfiguration.class);
        RedisConfiguration redisConfiguration = ObjectFileStorageHelper.load(RedisConfiguration.class);

        RedisClientProvider redisClientProvider = new CoreRedisClientProvider(redisConfiguration);
        redisClientProvider.establishConnection();

        LocalStorageProvider localStorageProvider = new LocalStorageProvider(objectMapperProvider);

        CloudPortProvider cloudPortProvider = new RedisCloudPortProvider(redisClientProvider.getClient(), configuration.getAddress());

        CloudService cloudService = new CoreCloudService(
                dockerClientProvider.getClient(),
                cloudPortProvider
        );

        TemplateService templateService = new CoreTemplateService(
                new DockerTemplateHandler(dockerClientProvider.getClient()),
                localStorageProvider
        );

        load(
                new TemplateLoader(templateService, localStorageProvider),
                new ServerLoader(cloudService, localStorageProvider)
        );

        setups(
                new SetupCommand(terminalProvider.getLineReader())
        );

        System.out.println("Cloud loaded and running");
    }

}
