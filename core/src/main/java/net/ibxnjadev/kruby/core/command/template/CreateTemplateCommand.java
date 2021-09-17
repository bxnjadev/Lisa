package net.ibxnjadev.kruby.core.command.template;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.annotated.annotation.Text;
import net.ibxnjadev.kruby.core.template.TemplateBuilder;
import net.ibxnjadev.kruby.core.template.TemplateService;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Command(names = "createtemplate")
public class CreateTemplateCommand implements CommandClass {

    private final TemplateService templateService;

    public CreateTemplateCommand(TemplateService templateService) {
        this.templateService = templateService;
    }

    @Command(names = "")
    public void main(String name,
                     String serverTypeString,
                     String dockerFileDirectory,
                     String pathJar,
                     @Text String commandStart) {

        File file = new File("templates/" + name);

        if (!file.exists()) {
            System.out.println("The template folder no exists, first create the folder files");
            return;
        }

        templateService
                .createTemplate(
                        TemplateBuilder.provideBuilder()
                                .name(name)
                                .directory(file)
                                .pathJar(pathJar)
                                .commandStart(commandStart)
                                .build(), dockerFileDirectory
                );
    }

}