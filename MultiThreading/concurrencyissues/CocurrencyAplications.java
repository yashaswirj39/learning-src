package MultiThreading.concurrencyissues;

import java.util.concurrent.*;

public class CocurrencyAplications {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        BankAccount ba = new BankAccount(100);
        /*Worker worker = new Worker(ba);
        es.submit(worker);*/ //no loop is required. it will executed and get the balance is 200
        for (int i = 0; i < 5; i++) {
            Worker worker = new Worker(ba);
            es.submit(worker);
        }

        try {
            es.shutdown();
            try {
                es.awaitTermination(60, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception exw){

        }
    }
}
