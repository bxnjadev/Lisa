package net.ibxnjadev.kruby.core.terminal;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

public class TerminalProvider {

    private final Terminal terminal;
    private final LineReader lineReader;

    public TerminalProvider(Terminal terminal,
                            LineReader lineReader) {
        this.terminal = terminal;
        this.lineReader = lineReader;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public LineReader getLineReader() {
        return lineReader;
    }

    public static TerminalProvider defaultTerminal() {

        try {
            Terminal terminal =
                    TerminalBuilder
                    .builder()
                    .color(true)
                    .name("Kruby Terminal")
                    .build();

            LineReader lineReader =
                    LineReaderBuilder
                    .builder()
                    .terminal(terminal)
                    .appName("Kruby")
                    .build();

            return new TerminalProvider(terminal, lineReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
