package broker;

import java.util.concurrent.SynchronousQueue;

public final class SynchronousMessageBroker<T> extends MessageBroker<T> {

    public SynchronousMessageBroker() {
        super(new SynchronousQueue<>());
    }
}
