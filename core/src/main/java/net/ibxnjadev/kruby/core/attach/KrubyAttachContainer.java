package net.ibxnjadev.kruby.core.attach;

import com.github.dockerjava.api.model.Frame;

import java.util.function.Consumer;

public class KrubyAttachContainer extends KrubyResultCallbackTemplate<KrubyAttachContainer, Frame> {

    private final Consumer<String> consumer;

    public KrubyAttachContainer(Consumer<String> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void onNext(Frame frame) {
        consumer.accept(format(frame));
    }

    private String format(Frame frame) {
        String frameString = frame.toString();
        frameString = frameString.replaceFirst(">", "");
        frameString = frameString.replaceFirst(":", "");
        frameString = frameString.replaceFirst("RAW", "");

        return frameString.trim();
    }

}
