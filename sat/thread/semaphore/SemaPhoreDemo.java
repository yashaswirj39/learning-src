package sat.thread.semaphore;

import java.util.concurrent.Semaphore;

public class SemaPhoreDemo {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        MyThread t1 = new MyThread(semaphore, "A");
        MyThread t2 = new MyThread(semaphore, "B");
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count: "+Shared.count);
    }
}
