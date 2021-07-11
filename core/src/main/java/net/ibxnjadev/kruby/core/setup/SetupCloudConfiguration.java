package net.ibxnjadev.kruby.core.setup;

import net.ibxnjadev.kruby.abstraction.cloud.CloudConfiguration;
import net.ibxnjadev.kruby.abstraction.setup.Loader;
import net.ibxnjadev.kruby.abstraction.util.Executor;
import net.ibxnjadev.kruby.abstraction.util.InputExecutor;
import net.ibxnjadev.kruby.abstraction.util.IpProvider;

public class SetupCloudConfiguration implements Loader {

    private static final InputExecutor INPUT_EXECUTOR = new InputExecutor();

    private final Executor errorInput = new ErrorInput();
    private final CloudConfiguration configuration;

    public SetupCloudConfiguration(CloudConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void load() {
        System.out.println("------------------------------");
        System.out.println(">> We are setting up kruby");
        System.out.println(">> Please follow the instructions");
        System.out.println("------------------------------");

        System.out.println(">> Please write a name for your cloud");

        INPUT_EXECUTOR
                .execute(String.class, configuration::setName, errorInput);

        System.out.println(">> Now please enter the memory in GB that you want to assign to the cloud");

        INPUT_EXECUTOR
                .execute(Integer.class, configuration::setMemory, errorInput);

        configuration
                .setAddress(IpProvider.provideIp());

    }

    private static class ErrorInput implements Executor {
        @Override
        public void execute() {
            System.out.println(">> You have entered a data incorrectly, please enter the requested information again");
        }
    }

}
