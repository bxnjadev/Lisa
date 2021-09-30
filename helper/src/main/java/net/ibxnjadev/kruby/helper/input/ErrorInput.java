package net.ibxnjadev.kruby.helper.input;

import net.ibxnjadev.kruby.helper.Executor;

public class ErrorInput implements Executor {
        @Override
        public void execute() {
            System.out.println(">> You have entered a data incorrectly, please enter the requested information again");
        }
}
