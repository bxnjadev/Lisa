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
import net.ibxnjadev.kruby.helper.input.ErrorInput;
import net.ibxnjadev.kruby.helper.input.InputExecutor;

public class CommandLoader implements Loader {

    private final AnnotatedCommandTreeBuilder annotatedCommandTreeBuilder;
    private final CommandManager commandManager;
    private final TemplateService templateService;
    private final CloudService cloudService;
    private final CloudShutdown cloudShutdown;

    private final InputExecutor inputExecutor;
    private final ErrorInput errorInput = new ErrorInput();

    public CommandLoader(AnnotatedCommandTreeBuilder annotatedCommandTreeBuilder,
                         CommandManager commandManager, TemplateService templateService,
                         CloudService cloudService,
                         CloudShutdown cloudShutdown,
                         InputExecutor inputExecutor) {
        this.annotatedCommandTreeBuilder = annotatedCommandTreeBuilder;
        this.commandManager = commandManager;
        this.templateService = templateService;
        this.cloudService = cloudService;
        this.cloudShutdown = cloudShutdown;
        this.inputExecutor = inputExecutor;
    }

    @Override
    public void load() {
        register(
                new ListServerCommand(),
                new CreateTemplateCommand(templateService, inputExecutor),
                new CreateServerCommand (cloudService, templateService, inputExecutor, errorInput),
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
