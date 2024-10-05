import broker.MessageBroker;
import broker.SynchronousMessageBroker;
import task.MessageBrokerConsumingTask;
import task.MessageBrokerProducingTask;

import static java.util.concurrent.ThreadLocalRandom.current;

public final class Main {

    public static void main(final String[] args) {
        final MessageBroker<Integer> broker = new SynchronousMessageBroker<>();

        startProducing(broker, 1);
        startProducing(broker, 3);
        startProducing(broker, 5);

        startConsuming(broker, 5);
        startConsuming(broker, 3);
        startConsuming(broker, 1);
    }

    private static void startProducing(final MessageBroker<Integer> broker, final long secondTimeout) {
        new Thread(new MessageBrokerProducingTask<>(broker, secondTimeout, Main::generateInt)).start();
    }

    private static void startConsuming(final MessageBroker<Integer> broker, final long secondTimeout) {
        new Thread(new MessageBrokerConsumingTask<>(broker, secondTimeout)).start();
    }

    private static int generateInt() {
        return current().nextInt(0, 10);
    }
}
