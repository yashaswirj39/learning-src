package sat.thread.threadname;

public class ThreadName extends Thread{
    ThreadName(String name){
        super(name);
    }

    public void run(){
        System.out.println("Thread is running...");
    }
}
class GFG{
    public static void main(String[] args) {
        ThreadName t1 = new ThreadName("geek1");
        ThreadName t2 = new ThreadName("geek2");

        System.out.println("Thread1: --> "+t1.getName());
        System.out.println("Thread2: --> "+t2.getName());

        t1.start();
        t2.start();
    }
}