package net.ibxnjadev.kruby.core.command.template;

import me.fixeddev.commandflow.annotated.CommandClass;
import net.ibxnjadev.kruby.core.template.TemplateService;

public class ListTemplateCommand implements CommandClass {

    private final TemplateService templateService;

    public ListTemplateCommand(TemplateService templateService) {
        this.templateService = templateService;
    }

    public void main() {

        System.out.println("[Kruby] Templates: ");
        System.out.println("");
        templateService.values().forEach(template -> {
            System.out.println(": " + template.getName());
        });

    }

}
