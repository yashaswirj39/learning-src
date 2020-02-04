package sat.thread;

public class MAinThreadDeadlock {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Entering into deadlock");
        Thread.currentThread().join();
        //following statement will never execute
        System.out.println("This statement will never execute");

        /**
         * The statement “Thread.currentThread().join()”,
         * will tell Main thread to wait for this thread(i.e. wait for itself) to die.
         * Thus Main thread wait for itself to die, which is nothing but a deadlock.
         */
    }
}
