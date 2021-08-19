package net.ibxnjadev.kruby.core.command.template;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import net.ibxnjadev.kruby.core.template.TemplateService;

@Command(names = "templatelist")
public class ListTemplateCommand implements CommandClass {

    private final TemplateService templateService;

    public ListTemplateCommand(TemplateService templateService) {
        this.templateService = templateService;
    }

    @Command(names = "")
    public void main() {

        System.out.println("[Kruby] Templates: ");
        System.out.println("");
        templateService.values().forEach(template -> {
            System.out.println(": " + template.getName());
        });

    }

}
