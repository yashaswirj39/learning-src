package MultiThreading.producerConsumerUsingObserverPattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ObserverExecution {
    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer("/home/yashaswi/Desktop/java/multithreading", "/home/yashaswi/Desktop/java/multithreading/archive");
        new Thread(producer).start();

        Consumer consumer = new Consumer(producer);
        TableInfoConsumer tic = new TableInfoConsumer(producer);
        ExecutorService consumerExecutor = Executors.newFixedThreadPool(5);
            //System.out.println("Current Thread -----> "+Thread.currentThread().getName());
            consumerExecutor.execute(consumer);
            consumerExecutor.execute(tic);

        consumerExecutor.shutdown();
        consumerExecutor.awaitTermination(10, TimeUnit.SECONDS);

    }
}
