package MultiThreading.topics.reetrantlockdemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Worker implements Runnable{

    String name;
    ReentrantLock re;

    public Worker(ReentrantLock rel, String job1) {
        this.name = job1;
        this.re = rel;
    }

    @Override
    public void run() {
        boolean done = false;
        while (!done) {
            //getting outer lock
            boolean ans = re.tryLock();

            //return true if lock is free
            if (ans) {
                try {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("task name - " + name + " outer lock acquired at: " +
                            ft.format(d) + "doing outer work");
                    Thread.sleep(1500);

                    //getting inner lock();
                    re.lock();

                    try {
                        d = new Date();
                        ft = new SimpleDateFormat("hh:mm:ss");
                        System.out.println("task name - " + name +
                                " inner lock acquired at " + ft.format(d) +
                                " Doing inner work ");
                        //displaying the hold count status/number
                        System.out.println("Lock hold count: " + re.getHoldCount());
                        Thread.sleep(1500);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    } finally {
                        System.out.println("task name - " + name + " releasing inner lock");
                        re.unlock();
                    }
                    System.out.println("Lock hold count: " + re.getHoldCount());
                    System.out.println("task name - " + name + " work done");
                    done = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("task name - " + name + " releasing outer lock");
                    re.unlock();
                    System.out.println("Lock hold count: " + re.getHoldCount());
                }
            } else {
                System.out.println("task name - " + name + " waiting for lock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Test {
    static final int MAX_T = 2;

    public static void main(String[] args) {
        ReentrantLock rel = new ReentrantLock();
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
        Runnable w1 = new Worker(rel, "Job1");
        Runnable w2 = new Worker(rel, "Job2");
        Runnable w3 = new Worker(rel, "Job3");
        Runnable w4 = new Worker(rel, "Job4");
        pool.execute(w1);
        pool.execute(w2);
        pool.execute(w3);
        pool.execute(w4);
        pool.shutdown();
    }
}