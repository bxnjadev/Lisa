package net.ibxnjadev.kruby.core.command.server;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.annotated.annotation.OptArg;
import net.ibxnjadev.kruby.core.cloud.CloudService;
import net.ibxnjadev.kruby.core.template.Template;
import net.ibxnjadev.kruby.core.template.TemplateService;

@Command(names = "createserver")
public class CreateServerCommand implements CommandClass {

    private final TemplateService templateService;
    private final CloudService cloudService;

    public CreateServerCommand(CloudService cloudService, TemplateService templateService) {
        this.cloudService = cloudService;
        this.templateService = templateService;
    }

    @Command(names = "")
    public void main(String templateName, String name, int port) {

        Template template = templateService.getTemplateByName(templateName);

        if (template == null) {
            System.out.println("The template no exists");
            return;
        }

        cloudService
                .createServer(
                    template,
                        port,
                        name
                );
    }

}
