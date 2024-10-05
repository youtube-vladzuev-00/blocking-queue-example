package task;

import broker.MessageBroker;

import static java.lang.System.out;

public final class MessageBrokerConsumingTask<T> extends MessageBrokerTask<T> {

    public MessageBrokerConsumingTask(final MessageBroker<T> broker, final long secondTimeout) {
        super(broker, secondTimeout);
    }

    @Override
    protected void executeOperation(final MessageBroker<T> broker)
            throws InterruptedException {
        final T message = broker.take();
        out.println(message + " was consumed");
    }
}
