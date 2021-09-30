package net.ibxnjadev.kruby.core.command.server;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.annotated.annotation.OptArg;
import me.fixeddev.commandflow.annotated.annotation.Text;
import net.ibxnjadev.kruby.core.cloud.CloudService;
import net.ibxnjadev.kruby.core.template.Template;
import net.ibxnjadev.kruby.core.template.TemplateService;
import net.ibxnjadev.kruby.helper.input.ErrorInput;
import net.ibxnjadev.kruby.helper.input.InputExecutor;

@Command(names = "createserver")
public class CreateServerCommand implements CommandClass {

    private final TemplateService templateService;
    private final CloudService cloudService;
    private final InputExecutor inputExecutor;
    private final ErrorInput errorInput;

    public CreateServerCommand(CloudService cloudService, TemplateService templateService, InputExecutor inputExecutor, ErrorInput errorInput) {
        this.cloudService = cloudService;
        this.templateService = templateService;
        this.inputExecutor = inputExecutor;
        this.errorInput = errorInput;
    }

    @Command(names = "")
    public void main() {

        String templateName = inputExecutor.get(String.class, errorInput, "Enter Template Name");
        int port = inputExecutor.get(Integer.class, errorInput, "Enter server port");
        String commandStart = inputExecutor.get(String.class, errorInput, "Enter Command Start");
        String serverName = inputExecutor.get(String.class, errorInput, "Enter Server Name");
        boolean isStatic = inputExecutor.get(Boolean.class, errorInput, "Your server is static?");
        String variables = inputExecutor.get(String.class, errorInput, "Enter the variables and separate with ,");

        Template template = templateService.getTemplateByName(templateName);

        if (template == null) {
            System.out.println("The template no exists");
            return;
        }

        cloudService.createServer(template, port, serverName, commandStart, isStatic, variables.split(","));
    }

}
