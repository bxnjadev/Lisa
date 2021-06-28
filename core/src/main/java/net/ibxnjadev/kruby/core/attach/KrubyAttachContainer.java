package net.ibxnjadev.kruby.core.attach;

import com.github.dockerjava.api.model.Frame;

import java.util.Set;
import java.util.function.Consumer;

public class KrubyAttachContainer extends KrubyResultCallbackTemplate<KrubyAttachContainer, Frame> {

    private final Set<Consumer<String>> consumers;

    public KrubyAttachContainer(Set<Consumer<String>> consumers) {
        this.consumers = consumers;
    }

    @Override
    public void onNext(Frame frame) {
        consumers.forEach(consumer -> consumer.accept(format(frame)));
    }

    private String format(Frame frame) {
        String frameString = frame.toString();
        frameString = frameString.replaceFirst(">", "");
        frameString = frameString.replaceFirst(":", "");
        frameString = frameString.replaceFirst("RAW", "");

        return frameString.trim();
    }

}
