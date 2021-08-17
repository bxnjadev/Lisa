package net.ibxnjadev.kruby.core.template;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.BuildImageResultCallback;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class manager the templates images in docker
 */

public class DockerTemplateHandler {

    private final DockerClient client;

    public DockerTemplateHandler(DockerClient client) {
        this.client = client;
    }

    /**
     * Create the image docker based in a template
     *
     * @param template the template
     * @return the template id
     */

    public String createTemplateImage(Template template) {

        File directory = template.getDirectory();
        File dockerFile = new File(directory, "Dockerfile");

        return client.buildImageCmd()
                .withDockerfile(dockerFile)
                .withPull(true)
                .withTags(asSet(template.getName() + ":latest"))
                .exec(new BuildImageResultCallback())
                .awaitImageId();
    }

    /**
     * Delete the template
     *
     * @param templateId the template id
     */

    public void deleteTemplate(String templateId) {
        client.removeImageCmd(templateId).exec();
    }

    private Set<String> asSet(String... strings) {
        return new HashSet<String>(Arrays.asList(strings));
    }

}
