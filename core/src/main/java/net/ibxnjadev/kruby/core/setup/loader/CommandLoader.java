package net.ibxnjadev.kruby.core.setup.loader;

import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import net.ibxnjadev.kruby.core.command.ListServerCommand;

public class CommandLoader implements Loader {

    private final AnnotatedCommandTreeBuilder annotatedCommandTreeBuilder;
    private final CommandManager commandManager;

    public CommandLoader(AnnotatedCommandTreeBuilder annotatedCommandTreeBuilder, CommandManager commandManager) {
        this.annotatedCommandTreeBuilder = annotatedCommandTreeBuilder;
        this.commandManager = commandManager;
    }

    @Override
    public void load() {
        commandManager.registerCommands(annotatedCommandTreeBuilder.fromClass(new ListServerCommand()));
    }

}
