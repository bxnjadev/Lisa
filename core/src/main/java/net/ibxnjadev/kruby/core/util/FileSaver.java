package net.ibxnjadev.kruby.core.util;

import net.ibxnjadev.kruby.abstraction.annotations.RouteFile;
import net.ibxnjadev.kruby.core.mapper.ObjectMapperProvider;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class FileSaver {

    public static void save(Object object) {
        findAnnotation(object)
                .ifPresent(routeFile -> saveObject(routeFile, object));
    }

    private static Optional<RouteFile> findAnnotation(Object object) {
        Class<?> clazz = object.getClass();
        RouteFile routeFile = clazz.getAnnotation(RouteFile.class);

        return Optional.ofNullable(routeFile);
    }

    private static void saveObject(RouteFile routeFile, Object object) {
        try {
            ObjectMapperProvider.provideMapper()
                    .writeValue(new File(routeFile.route()), object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
