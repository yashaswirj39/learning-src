package MultiThreading.producerConsumerUsingObserverPattern;

import java.util.List;
import java.util.Queue;

public interface ConsumerObserver {
    void update(ProducerSubject subject);
}
