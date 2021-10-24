package net.ibxnjadev.kruby.core.setup;

import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.Namespace;
import me.fixeddev.commandflow.NamespaceImpl;
import me.fixeddev.commandflow.SimpleCommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilderImpl;
import me.fixeddev.commandflow.annotated.part.PartInjector;
import me.fixeddev.commandflow.annotated.part.defaults.DefaultsModule;
import me.fixeddev.commandflow.exception.ArgumentException;
import me.fixeddev.commandflow.exception.CommandUsage;
import net.ibxnjadev.kruby.core.cloud.CloudService;
import net.ibxnjadev.kruby.core.cloud.CloudShutdown;
import net.ibxnjadev.kruby.core.setup.loader.CommandLoader;
import net.ibxnjadev.kruby.core.setup.loader.Loader;
import net.ibxnjadev.kruby.core.template.TemplateService;
import net.ibxnjadev.kruby.helper.input.ErrorInput;
import net.ibxnjadev.kruby.helper.input.InputExecutor;
import org.jline.reader.LineReader;

public class SetupCommand implements SetupHandler {

    private static final String PREFIX = "$ ";

    private final LineReader lineReader;
    private final TemplateService templateService;
    private final CloudService cloudService;
    private final CloudShutdown cloudShutdown;
    private final InputExecutor inputExecutor;

    public SetupCommand(LineReader lineReader,
                        TemplateService templateService,
                        CloudService cloudService,
                        CloudShutdown cloudShutdown,
                        InputExecutor inputExecutor) {
        this.lineReader = lineReader;
        this.templateService = templateService;
        this.cloudService = cloudService;
        this.cloudShutdown = cloudShutdown;
        this.inputExecutor = inputExecutor;
    }

    @Override
    public void setup() {

        PartInjector partInjector = PartInjector.create();
        partInjector.install(new DefaultsModule());

        AnnotatedCommandTreeBuilder annotatedCommandTreeBuilder = new AnnotatedCommandTreeBuilderImpl(partInjector);
        CommandManager commandManager = new SimpleCommandManager();
        Namespace namespace = new NamespaceImpl();

        Loader loader = new CommandLoader(annotatedCommandTreeBuilder, commandManager, templateService, cloudService, cloudShutdown,
                inputExecutor);
        loader.load();

        while (true) {
            try {
                commandManager.execute(namespace, lineReader.readLine(PREFIX));
            } catch (CommandUsage e) {
                if (e.getCause() instanceof ArgumentException) {
                    System.out.println("Error in the arguments, type again");
                }
            }
        }

    }
}
