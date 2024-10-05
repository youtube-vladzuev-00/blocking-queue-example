package broker;

import java.util.concurrent.LinkedBlockingQueue;

public final class LinkedMessageBroker<T> extends MessageBroker<T> {

    public LinkedMessageBroker(final int capacity) {
        super(new LinkedBlockingQueue<>(capacity));
    }
}
