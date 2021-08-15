package net.ibxnjadev.kruby.core.template;

import com.github.dockerjava.api.DockerClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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

        try (FileInputStream inputStream = new FileInputStream(dockerFile)) {
            String idImage = client.createImageCmd(template.getName(), inputStream)
                    .withRepository(template.getName())
                    .exec()
                    .getId();
            inputStream.close();

            return idImage;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Delete the template
     *
     * @param templateId the template id
     */

    public void deleteTemplate(String templateId) {
        client.removeContainerCmd(templateId)
                .exec();
    }

}
