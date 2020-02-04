package sat.thread.countdownlatch;

public class CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(4);
        Worker worker = new Worker(1000, latch, "WORKER-1");
        Worker worker1 = new Worker(2000, latch, "WORKER-2");
        Worker worker2 = new Worker(3000, latch, "WORKER-3");
        Worker worker3 = new Worker(4000, latch, "WORKER-4");

        worker.start();
        worker1.start();
        worker2.start();
        worker3.start();

        latch.await();
        System.out.println(Thread.currentThread().getName() + " has finished");
    }
}
