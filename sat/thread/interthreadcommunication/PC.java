package sat.thread.interthreadcommunication;

import java.util.Scanner;

public class PC {

    //prints a string and waits for consume()
    public void produce() throws InterruptedException {
        //synchronized blocks ensures only one thread running at a time
        synchronized (this){
            System.out.println("producer thread running");

            //release the lock on shared resource
            wait();

            //waits till some other method invokes notify()
            System.out.println("Resumed producer");
        }
    }

    /**
     * sleeps for sometime and waits for key press,
     * after key is pressed
     */
    public void consume() throws InterruptedException {
        Thread.sleep(1000);

        Scanner sc = new Scanner(System.in);

        //synchronized blocks ensures only one thread running at a time
        synchronized (this){
            System.out.println("waiting for key press");
            sc.nextLine();
            System.out.println("key is presses");

            //notify the producer thread that it can wake up
            notify();

            Thread.sleep(1000);
        }
    }
}
