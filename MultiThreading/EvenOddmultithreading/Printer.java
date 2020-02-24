package MultiThreading.EvenOddmultithreading;

public class Printer {
    boolean isOdd = false;

    public synchronized void printEvent(int number) {
        while (isOdd == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Even: " + number);
        isOdd = false;
        notifyAll();
    }

    public synchronized void printOdd(int number) {
        while (isOdd == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Odd: " + number);
        isOdd = true;
        notifyAll();
    }
}