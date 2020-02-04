package sat.thread;

public class MainThread extends Thread {
    public static void main(String[] args) {

        //getting reference to main thread
        Thread t = Thread.currentThread();

        //getting name of main Thread
        System.out.println("Current thread: --> "+t.getName());

        //changing name of main thread
        t.setName("geeks");
        System.out.println("After changing name of main thread: --> "+t.getName());

        //getting priority of main Thread
        System.out.println("Main Thread priority: ---> "+t.getPriority());

        //setting priority of main thread
        t.setPriority(MAX_PRIORITY);

        System.out.println("Main Thread new priority: --> "+t.getPriority());

        for (int i = 0; i < 5; i++) {
            System.out.println("MAin Thread");
        }

        //Main thread creating a child thread
        ChildThread ct = new ChildThread();

        /**
         * getting priority of child thread
         * which will be inherited from main thread
         * as it is created by main thread
         */

        System.out.println("Child thread priority: --> "+ct.getPriority());
        ct.setPriority(MIN_PRIORITY);

        System.out.println("After setting priority to child thread: --> "+ct.getPriority());
        ct.start();
    }
}

class ChildThread extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread");
        }
    }
}