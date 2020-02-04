package sat.thread.semaphore;

import java.util.concurrent.Semaphore;

public class MyThread extends Thread {
    Semaphore semaphore;
    String threadName;

    public MyThread(Semaphore semaphore, String threadName) {
        super(threadName);
        this.semaphore = semaphore;
        this.threadName = threadName;
    }

    public void run(){
        if (this.getName().equals("A")){
            System.out.println(threadName + " is waiting to acquire a permit");
            try {
                semaphore.acquire();
                System.out.println(threadName + " gots the permit");
                for (int i = 0; i < 5; i++) {
                    Shared.count++;
                    System.out.println(threadName+" : "+Shared.count);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " releases the lock");
            semaphore.release();
        } else{
            System.out.println(threadName + "is waiting for permit");
            try {
                semaphore.acquire();
                System.out.println(threadName + " acquires the permit");
                for (int i = 0; i < 5; i++) {
                    Shared.count--;
                    System.out.println(threadName + " : " + Shared.count);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " releasing the lock");
            semaphore.release();
        }
    }
}
