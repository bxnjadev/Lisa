package net.ibxnjadev.kruby.core.setup;

import net.ibxnjadev.kruby.abstraction.setup.SetupHandler;
import net.ibxnjadev.kruby.core.util.StreamHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SetupRedis implements SetupHandler {

    @Override
    public void setup() {

        try {

            InputStream inputStream = StreamHelper.getResource("redis.json");
            File redisFile = new File("redis.json");
            redisFile.createNewFile();

            StreamHelper
                    .copyStream(inputStream, new FileOutputStream(redisFile));

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("redis.json created, please configure the file first and run the cloud :)");
        System.exit(0);

    }

}
