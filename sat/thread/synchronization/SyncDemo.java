package sat.thread.synchronization;

public class SyncDemo {
    public static void main(String[] args) throws InterruptedException {
        Sender send = new Sender();
        ThreadSend t1 = new ThreadSend("Hi", send);
        ThreadSend t2 = new ThreadSend("Bye", send);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
class Sender{
    public void send(String msg) throws InterruptedException {
        System.out.println("Sending "+msg);
        Thread.sleep(3000);
        System.out.println(msg + "sent");
    }
}

class ThreadSend extends Thread{
    private String msg;
    private Thread t;
    Sender sender;

    ThreadSend(String m, Sender sen){
        this.msg = m;
        this.sender = sen;
    }

    public void run(){
        synchronized (sender){
            try {
                sender.send(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}