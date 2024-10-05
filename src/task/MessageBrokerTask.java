package task;

import broker.MessageBroker;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.TimeUnit.SECONDS;

public abstract class MessageBrokerTask<T> implements Runnable {
    private final MessageBroker<T> broker;
    private final long secondTimeout;

    public MessageBrokerTask(final MessageBroker<T> broker, final long secondTimeout) {
        this.broker = broker;
        this.secondTimeout = secondTimeout;
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public final void run() {
        try {
            while (true) {
                executeOperation(broker);
                SECONDS.sleep(secondTimeout);
            }
        } catch (final InterruptedException exception) {
            currentThread().interrupt();
        }
    }

    protected abstract void executeOperation(final MessageBroker<T> broker)
            throws InterruptedException;
}
