package net.ibxnjadev.kruby.core.command.template;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.annotated.annotation.Text;
import net.ibxnjadev.kruby.core.java.JavaVersion;
import net.ibxnjadev.kruby.core.server.ServerType;
import net.ibxnjadev.kruby.core.template.TemplateBuilder;
import net.ibxnjadev.kruby.core.template.TemplateService;

import java.io.File;
import java.util.Locale;

@Command(names = "createtemplate")
public class CreateTemplateCommand implements CommandClass {

    private final TemplateService templateService;

    public CreateTemplateCommand(TemplateService templateService) {
        this.templateService = templateService;
    }

    @Command(names = "")
    public void main(String name, String serverTypeString, int javaVersionInt, String pathJar, @Text String commandStart) {

        File file = new File("templates/" + name);
        ServerType serverType = ServerType.valueOf(serverTypeString);

        if (!file.exists()) {
            System.out.println("The template folder no exists, first create the folder files");
            return;
        }

        JavaVersion javaVersion = JavaVersion.parse(javaVersionInt);

        templateService
                .createTemplate(
                        TemplateBuilder.provideBuilder()
                                .setName(name)
                                .setDirectory(file)
                                .setJavaVersion(javaVersion)
                                .setType(serverType)
                                .setPathJar(pathJar)
                                .setCommandStart(commandStart)
                                .build(),
                        javaVersion.name().toLowerCase(Locale.ROOT)
                );
    }

}