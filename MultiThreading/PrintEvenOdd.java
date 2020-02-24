package MultiThreading;

public class PrintEvenOdd implements Runnable{
    public synchronized void printOdd() throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
                //wait();
            }
        }
        //notify();
    }
    public synchronized void printEven() throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                //wait();
            }
        }
        //notify();
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintEvenOdd());
        Thread t2 = new Thread(new PrintEvenOdd());
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        try {
            synchronized (this) {
                while (true) {
                    printOdd();
                    printEven();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
