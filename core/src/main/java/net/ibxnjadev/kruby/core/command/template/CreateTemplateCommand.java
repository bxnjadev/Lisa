package net.ibxnjadev.kruby.core.command.template;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.annotated.annotation.Text;
import net.ibxnjadev.kruby.core.template.TemplateBuilder;
import net.ibxnjadev.kruby.core.template.TemplateService;
import net.ibxnjadev.kruby.helper.input.ErrorInput;
import net.ibxnjadev.kruby.helper.input.InputExecutor;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Command(names = "createtemplate")
public class CreateTemplateCommand implements CommandClass {

    private final ErrorInput errorInput = new ErrorInput();

    private final TemplateService templateService;
    private final InputExecutor inputExecutor;

    public CreateTemplateCommand(TemplateService templateService, InputExecutor inputExecutor) {
        this.templateService = templateService;
        this.inputExecutor = inputExecutor;
    }

    @Command(names = "")
    public void main() {
        
        String name = inputExecutor.get(String.class, errorInput, "Enter Template Name");
        String commandStart = inputExecutor.get(String.class, errorInput, "Enter Command Start");
        String directory = inputExecutor.get(String.class, errorInput, "Enter Template Directory");
        int serversPerDefect = inputExecutor.get(Integer.class, errorInput, "Enter Server per Defect");
        String dockerFileDirectory = inputExecutor.get(String.class, errorInput, "Enter dockerfile directory");

        File fileDirectory = new File("template-registry/" + directory);

        if (!fileDirectory.exists()) {
            System.out.println("The directory no exists");
            return;
        }

        templateService.createTemplate(
                TemplateBuilder.provideBuilder()
                        .name(name)
                        .commandStart(commandStart)
                        .directory(fileDirectory)
                        .quantityServerPerDefect(serversPerDefect)
                        .build(),
                        dockerFileDirectory
        );

    }

}