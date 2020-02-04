package sat.thread.threadjoining;

public class GFG {
    public static void main(String[] args) throws InterruptedException {
        ThreadJoining t1 = new ThreadJoining();
        ThreadJoining t2 = new ThreadJoining();
        ThreadJoining t3 = new ThreadJoining();

        t1.start();

        System.out.println("Current Thread ---> "+Thread.currentThread().getName());
        t1.join();

        t2.start();
        System.out.println("Current Thread ---> "+Thread.currentThread().getName());
        t2.join();

        t3.start();
        System.out.println("Current Thread ---> "+Thread.currentThread().getName());
    }
}
