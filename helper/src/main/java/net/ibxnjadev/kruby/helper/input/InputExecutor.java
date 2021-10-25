package net.ibxnjadev.kruby.helper.input;

import net.ibxnjadev.kruby.helper.Executor;
import org.jline.reader.LineReader;

import java.util.function.Consumer;

public class InputExecutor {

    private final LineReader lineReader;

    public InputExecutor(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    public <T> void execute(Class<T> clazz, Consumer<T> consumer, String prefix) {
        execute(clazz, consumer, null, prefix);
    }

    public <T> void execute(Class<T> clazz, Consumer<T> consumer, Executor executorIfThrow, String prefix) {

        String line = prefix != null ? lineReader.readLine(prefix + " ") : lineReader.readLine();
        line = line.trim();

        try {
            consumer.accept(clazz.cast(create(clazz, line)));
        } catch (Exception e) {

            if (executorIfThrow != null) {
                executorIfThrow.execute();
            }

            execute(clazz, consumer, executorIfThrow, prefix);
        }
    }

    public <T> T get(Class<T> clazz, Executor executorIfThrow, String prefix){
        String line = prefix != null ? lineReader.readLine(prefix + " ") : lineReader.readLine();
        line = line.trim();

        try {
            return clazz.cast(create(clazz, line));
        } catch (Exception e) {

            if (executorIfThrow != null) {
                executorIfThrow.execute();
            }

        }
        return get(clazz, executorIfThrow, prefix);
    }

    private Object create(Class<?> clazz, String line) {
        switch (clazz.getSimpleName()) {
            case "Integer":
                return Integer.parseInt(line);
            case "Double":
                return Double.parseDouble(line);
            case "Float":
                return Float.parseFloat(line);
            default:
                return line;
        }
    }

    public static InputExecutor defaultExecutor(LineReader lineReader) {
        return new InputExecutor(lineReader);
    }

}
