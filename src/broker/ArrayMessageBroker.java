package broker;

import java.util.concurrent.ArrayBlockingQueue;

public final class ArrayMessageBroker<T> extends MessageBroker<T> {

    public ArrayMessageBroker(final int capacity) {
        super(new ArrayBlockingQueue<>(capacity));
    }
}
