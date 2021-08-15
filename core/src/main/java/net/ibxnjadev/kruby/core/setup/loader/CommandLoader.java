package net.ibxnjadev.kruby.core.setup.loader;

import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.CommandClass;
import net.ibxnjadev.kruby.core.command.ListServerCommand;
import net.ibxnjadev.kruby.core.command.template.CreateTemplateCommand;
import net.ibxnjadev.kruby.core.template.TemplateService;

public class CommandLoader implements Loader {

    private final AnnotatedCommandTreeBuilder annotatedCommandTreeBuilder;
    private final CommandManager commandManager;
    private final TemplateService templateService;

    public CommandLoader(AnnotatedCommandTreeBuilder annotatedCommandTreeBuilder, CommandManager commandManager, TemplateService templateService) {
        this.annotatedCommandTreeBuilder = annotatedCommandTreeBuilder;
        this.commandManager = commandManager;
        this.templateService = templateService;
    }

    @Override
    public void load() {
        register(
                new ListServerCommand(),
                new CreateTemplateCommand(templateService)
        );
    }

    private void register(CommandClass... commandClasses) {
        for (CommandClass commandClass : commandClasses) {
            commandManager.registerCommands(annotatedCommandTreeBuilder.fromClass(commandClass));
        }
    }

}
