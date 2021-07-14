package net.ibxnjadev.kruby.core.setup;

import net.ibxnjadev.kruby.abstraction.cloud.CloudConfiguration;
import net.ibxnjadev.kruby.abstraction.setup.Loader;
import net.ibxnjadev.kruby.abstraction.util.Executor;
import net.ibxnjadev.kruby.abstraction.util.InputExecutor;
import net.ibxnjadev.kruby.abstraction.util.IpProvider;
import net.ibxnjadev.kruby.core.util.FileSaver;
import net.ibxnjadev.kruby.core.util.UtilId;

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

        String idRandom = UtilId.randomId();

        configuration.setId(idRandom);

        INPUT_EXECUTOR
                .execute(String.class, (s) -> {
                    configuration.setName(s + "_" + idRandom);
                }, errorInput);

        System.out.println(">> Now please enter the memory in GB that you want to assign to the cloud");

        INPUT_EXECUTOR
                .execute(Integer.class, configuration::setMemory, errorInput);

        configuration
                .setAddress(IpProvider.provideIp());

        System.out.println("------------------------------");
        System.out.println("Configured cloud....");
        System.out.println("Id" + configuration.getId());
        System.out.println("Name" + configuration.getName());
        System.out.println("Memory " + configuration.getMemory());
        System.out.println("Ip " + configuration.getAddress());
        System.out.println("------------------------------");

        FileSaver.save(configuration);
    }

    private static class ErrorInput implements Executor {
        @Override
        public void execute() {
            System.out.println(">> You have entered a data incorrectly, please enter the requested information again");
        }
    }

}
