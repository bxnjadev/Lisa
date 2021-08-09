package net.ibxnjadev.kruby.core.util;

import net.ibxnjadev.kruby.core.annotations.RouteFile;
import net.ibxnjadev.kruby.core.mapper.ObjectMapperProvider;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class ObjectFileStorageHelper {

    public static void save(Object object) {
        findAnnotation(object.getClass())
                .ifPresent(routeFile -> saveObject(routeFile, object));
    }

    public static <T> T load(Class<T> clazz) {
        Optional<RouteFile> optional = findAnnotation(clazz);

        return optional.map(routeFile -> ConfigurationParser.provideConfiguration(clazz, new File(routeFile.route()))).orElse(null);
    }

    private static Optional<RouteFile> findAnnotation(Class<?> clazz) {
        RouteFile routeFile = clazz.getAnnotation(RouteFile.class);

        return Optional.ofNullable(routeFile);
    }

    private static void saveObject(RouteFile routeFile, Object object) {
        try {
            System.out.println("Saving object in file");
            ObjectMapperProvider.provideMapper()
                    .writeValue(new File(routeFile.route()), object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
