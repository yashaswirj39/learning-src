package MultiThreading;

public class Adder implements Runnable{
    int count = 0;

    public void doAdd(){
        count = count + 1;
        System.out.println("Counter ----> "+count);
    }

    @Override
    public void run() {
        doAdd();
    }
}
