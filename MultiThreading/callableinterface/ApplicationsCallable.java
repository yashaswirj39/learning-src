package MultiThreading.callableinterface;

import MultiThreading.Adder;

import java.util.concurrent.*;

public class ApplicationsCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer>[] futures = new Future[10];
        Adder adder = new Adder();
        for (int i = 0; i < 10; i++) {
            futures[i] = (Future<Integer>) es.submit(adder);
        }

        for (Future<Integer> res : futures){
            try {
                res.get(); // blocks until return value available
            } catch (ExecutionException ex){ // Exception raised inadder
                Throwable adderex = ex.getCause(); // Get the Adder Exception
            }
        }
    }
}
