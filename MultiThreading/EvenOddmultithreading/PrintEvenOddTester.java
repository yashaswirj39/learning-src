package MultiThreading.EvenOddmultithreading;

public class PrintEvenOddTester {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread t1 = new Thread(new TaskEvenOdd(10, printer, false));
        Thread t2 = new Thread(new TaskEvenOdd(10, printer, false));
        t1.start();
        t2.start();
    }
}
