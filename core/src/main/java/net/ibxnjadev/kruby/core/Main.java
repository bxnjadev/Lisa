package net.ibxnjadev.kruby.core;

import net.ibxnjadev.kruby.core.setup.CloudSetupService;
import net.ibxnjadev.kruby.core.setup.DefaultCloudSetupService;

public class Main {

    public static void main(String[] args) {
        CloudSetupService cloudSetupService
                = new DefaultCloudSetupService();

        cloudSetupService.setup();
    }

}
