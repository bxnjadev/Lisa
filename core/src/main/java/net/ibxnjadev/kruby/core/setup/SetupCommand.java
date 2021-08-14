package net.ibxnjadev.kruby.core.setup;

import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.Namespace;
import me.fixeddev.commandflow.NamespaceImpl;
import me.fixeddev.commandflow.SimpleCommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilderImpl;
import me.fixeddev.commandflow.annotated.part.PartInjector;
import me.fixeddev.commandflow.annotated.part.defaults.DefaultsModule;
import net.ibxnjadev.kruby.core.setup.loader.CommandLoader;
import net.ibxnjadev.kruby.core.setup.loader.Loader;
import org.jline.reader.LineReader;

public class SetupCommand implements SetupHandler {

    private static final String PREFIX = "$ ";

    private final LineReader lineReader;

    public SetupCommand(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    @Override
    public void setup() {

        PartInjector partInjector = PartInjector.create();
        partInjector.install(new DefaultsModule());

        AnnotatedCommandTreeBuilder annotatedCommandTreeBuilder = new AnnotatedCommandTreeBuilderImpl(partInjector);
        CommandManager commandManager = new SimpleCommandManager();
        Namespace namespace = new NamespaceImpl();

        Loader loader = new CommandLoader(annotatedCommandTreeBuilder, commandManager);
        loader.load();

        while (true) {
            commandManager.execute(namespace, lineReader.readLine(PREFIX));
        }

    }
}
