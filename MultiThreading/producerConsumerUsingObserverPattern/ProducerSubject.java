package MultiThreading.producerConsumerUsingObserverPattern;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public interface ProducerSubject {
    public void registerConsumer(ConsumerObserver co);
    public void removeConsumer(ConsumerObserver co);
    public void notifyConsumer(BlockingQueue<String> userList);
    public void reader(String read, String archive);
}
