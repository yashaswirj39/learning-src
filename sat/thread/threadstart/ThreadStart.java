package sat.thread.threadstart;

/**
 * What happens when a function is called?
 * When a function is called the following operations take place:
 *
 * The arguments are evaluated.
 * A new stack frame is pushed into the call stack.
 * Parameters are initialized.
 * Method body is executed.
 * Value is retured and current stack frame is popped from the call stack.
 */


/**
 * The purpose of start() is to create a separate call stack for the thread.
 * A separate call stack is created by it, and then run() is called by JVM.
 */


public class ThreadStart extends Thread{
    public void run(){
            System.out.println(Thread.currentThread().getName() + " is running");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ThreadStart ts = new ThreadStart();
            ts.run();
        }
    }
}
