package net.ibxnjadev.kruby.core.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import net.ibxnjadev.kruby.core.docker.DockerClientProvider;
import net.ibxnjadev.kruby.core.server.CoreServer;
import net.ibxnjadev.kruby.core.server.Server;

import java.io.IOException;

public class ServerDeserialize extends StdDeserializer<Server> {

    private final DockerClientProvider dockerClientProvider;

    public ServerDeserialize(DockerClientProvider dockerClientProvider) {
        this(null, dockerClientProvider);
    }

    protected ServerDeserialize(Class<?> vc, DockerClientProvider dockerClientProvider) {
        super(vc);
        this.dockerClientProvider = dockerClientProvider;
    }

    @Override
    public Server deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);

        return new CoreServer(jsonNode.get("id").asText(),
                jsonNode.get("containerId").asText(),
                jsonNode.get("templateName").asText(),
                jsonNode.get("templateId").asText(),
                jsonNode.get("name").asText(),
                jsonNode.get("port").asInt(),
                jsonNode.get("isStatic").asBoolean(),
                dockerClientProvider.getClient());
    }
}
