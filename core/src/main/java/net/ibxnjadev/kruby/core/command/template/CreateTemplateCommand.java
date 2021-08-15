package net.ibxnjadev.kruby.core.command.template;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import net.ibxnjadev.kruby.core.java.JavaVersion;
import net.ibxnjadev.kruby.core.template.TemplateBuilder;
import net.ibxnjadev.kruby.core.template.TemplateService;

import java.io.File;

@Command(names = "createtemplate")
public class CreateTemplateCommand implements CommandClass {

    private final TemplateService templateService;

    public CreateTemplateCommand(TemplateService templateService) {
        this.templateService = templateService;
    }

    @Command(names = "")
    public void main(String name, int javaVersion, String pathJar, String commandStart) {

        File file = new File("templates/" + name);

        if (!file.exists()) {
            System.out.println("The template folder no exists, first create the folder files");
            return;
        }

        templateService
                .createTemplate(
                        TemplateBuilder.provideBuilder()
                                .setDirectory(new File("templates/" + name))
                                .setJavaVersion(JavaVersion.parse(javaVersion))
                                .setPathJar(pathJar)
                                .setCommandStart(commandStart)
                                .build(),
                        name
                );
    }

}