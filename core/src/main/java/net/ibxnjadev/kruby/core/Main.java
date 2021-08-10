package net.ibxnjadev.kruby.core;

import net.ibxnjadev.kruby.core.setup.start.CloudSetupService;
import net.ibxnjadev.kruby.core.setup.start.DefaultCloudSetupService;

public class Main {

    public static void main(String[] args) {
        CloudSetupService cloudSetupService
                = new DefaultCloudSetupService();

        cloudSetupService.setup();
    }

}
