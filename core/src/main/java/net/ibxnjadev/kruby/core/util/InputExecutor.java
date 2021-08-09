package net.ibxnjadev.kruby.core.util;

import java.util.Scanner;
import java.util.function.Consumer;

public class InputExecutor {

    public void executeText(Consumer<String> consumer, Executor executorIfThrow) {
        execute(null, consumer, executorIfThrow, true);
    }

    public <T> void execute(Class<T> clazz, Consumer<T> consumer) {
        execute(clazz, consumer, null);
    }

    public <T> void execute(Class<T> clazz, Consumer<T> consumer, Executor executorIfThrow) {
        execute(clazz, consumer, executorIfThrow, false);
    }

    private <T> void execute(Class<T> clazz, Consumer<T> consumer, Executor executorIfThrow, boolean isText) {
        Scanner scanner = new Scanner(System.in);

        try {
            consumer.accept(isText ? (T) scanner.nextLine() : clazz.cast(create(clazz, scanner)));
        } catch (Exception e) {

            if (executorIfThrow != null) {
                executorIfThrow.execute();
            }

            execute(clazz, consumer, executorIfThrow);
        }
    }

    private Object create(Class<?> clazz, Scanner scanner) {
        switch (clazz.getSimpleName()) {
            case "Double":
                return scanner.nextDouble();
            case "Integer":
                return scanner.nextInt();
            case "Byte":
                return scanner.nextByte();
            case "Float":
                return scanner.nextFloat();
            case "Long":
                return scanner.nextLong();
            default:
                return scanner.next();
        }
    }

    public static InputExecutor defaultExecutor() {
        return new InputExecutor();
    }

}
