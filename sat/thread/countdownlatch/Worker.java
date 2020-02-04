package sat.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Worker extends Thread{
    private int delay;
    private CountDownLatch countDownLatch;

    public Worker(int delay, java.util.concurrent.CountDownLatch countDownLatch, String name){
        super(name);
        this.delay = delay;
        this.countDownLatch = countDownLatch;
    }

    public void run(){
        try {
            Thread.sleep(1000);
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName()+" finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
