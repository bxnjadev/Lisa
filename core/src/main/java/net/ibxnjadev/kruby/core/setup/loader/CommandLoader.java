package net.ibxnjadev.kruby.core.setup.loader;

import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.CommandClass;
import net.ibxnjadev.kruby.core.cloud.CloudService;
import net.ibxnjadev.kruby.core.cloud.CloudShutdown;
import net.ibxnjadev.kruby.core.command.ListServerCommand;
import net.ibxnjadev.kruby.core.command.StopCommand;
import net.ibxnjadev.kruby.core.command.server.CreateServerCommand;
import net.ibxnjadev.kruby.core.command.template.CreateTemplateCommand;
import net.ibxnjadev.kruby.core.command.template.ListTemplateCommand;
import net.ibxnjadev.kruby.core.template.TemplateService;

public class CommandLoader implements Loader {

    private final AnnotatedCommandTreeBuilder annotatedCommandTreeBuilder;
    private final CommandManager commandManager;
    private final TemplateService templateService;
    private final CloudService cloudService;
    private final CloudShutdown cloudShutdown;

    public CommandLoader(AnnotatedCommandTreeBuilder annotatedCommandTreeBuilder,
                         CommandManager commandManager, TemplateService templateService,
                         CloudService cloudService,
                         CloudShutdown cloudShutdown) {
        this.annotatedCommandTreeBuilder = annotatedCommandTreeBuilder;
        this.commandManager = commandManager;
        this.templateService = templateService;
        this.cloudService = cloudService;
        this.cloudShutdown = cloudShutdown;
    }

    @Override
    public void load() {
        register(
                new ListServerCommand(),
                new CreateTemplateCommand(templateService),
                new CreateServerCommand(cloudService, templateService),
                new ListTemplateCommand(templateService),
                new StopCommand(cloudShutdown)
        );
    }

    private void register(CommandClass... commandClasses) {
        for (CommandClass commandClass : commandClasses) {
            commandManager.registerCommands(annotatedCommandTreeBuilder.fromClass(commandClass));
        }
    }

}
