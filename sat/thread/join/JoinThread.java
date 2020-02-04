package sat.thread.join;

public class JoinThread implements Runnable{

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("Current thread -->  "+t.getName());
        System.out.println("isAlive --> "+t.isAlive());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new JoinThread());
        thread.start();
        thread.join(1000);
        System.out.println("joining after 1000 ms: Current thread ---> "+thread.getName());
        System.out.println("thread isAlive ---> "+thread.isAlive());
    }
}