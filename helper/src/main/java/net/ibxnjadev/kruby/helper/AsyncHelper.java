package net.ibxnjadev.kruby.helper;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncHelper {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public static <T> T submit(Class<T> clazz, Runnable task) {
        Future<T> future = (Future<T>) EXECUTOR_SERVICE.submit(task);

        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
        }
        return null;
    }

}
