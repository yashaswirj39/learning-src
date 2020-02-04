package MultiThreading;

public class Applications extends Thread{

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[10];
        Adder adder = new Adder();
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(adder);
            threads[i].start();
            System.out.println("Thread name ---> "+Thread.currentThread().getName());
        }

        for (Thread thread : threads)
            thread.join(); //Blocks waiting for thread completion
    }
}
