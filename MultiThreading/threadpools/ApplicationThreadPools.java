package MultiThreading.threadpools;

import MultiThreading.Adder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ApplicationThreadPools {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Adder adder = new Adder();
        for (int i = 0; i < 10; i++) {
            es.submit(adder);
        }
        try {
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);
        } catch (Exception e) {

        }
    }
}
