package net.ibxnjadev.kruby.core.command;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import net.ibxnjadev.kruby.core.cloud.CloudShutdown;

@Command(names = "stop")
public class StopCommand implements CommandClass {

    private final CloudShutdown cloudShutdown;

    public StopCommand(CloudShutdown cloudShutdown) {
        this.cloudShutdown = cloudShutdown;
    }

    @Command(names = "")
    public void main() {
        cloudShutdown.shutdown();
    }

}
