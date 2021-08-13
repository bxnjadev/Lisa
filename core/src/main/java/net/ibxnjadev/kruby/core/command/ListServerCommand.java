package net.ibxnjadev.kruby.core.command;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;

@Command(names = "serverlist")
public class ListServerCommand implements CommandClass {

    @Command(names = "serverlist")
    public void main() {
        System.out.println("List");
    }

}
