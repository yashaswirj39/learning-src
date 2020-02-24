package designpattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadedSingletonTest /*implements Runnable*/{
    static void useSingleTon() {
        Singleton singleton = Singleton.getInstance();
        System.out.println("singletong: " + singleton + " hascode: " + singleton.hashCode());
    }
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(MultithreadedSingletonTest::useSingleTon);
        service.submit(MultithreadedSingletonTest::useSingleTon);
        service.shutdown();
    }

    /*@Override
    public void run() {

    }*/
}
