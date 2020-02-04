package sat.thread.interthreadcommunication;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        PC pc = new PC();

        //creates a thread object that calls pc.produce()
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //create another thread object that calls pc.consume()
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        //starts both the threads
        t1.start();
        t2.start();

        System.out.println(t1.getState());
        System.out.println(t2.getState());
        //t1 executes before t2
        t1.join();
        t2.join();
    }
}