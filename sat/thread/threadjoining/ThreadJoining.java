package sat.thread.threadjoining;

public class ThreadJoining extends Thread {
    public void run(){
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Current Thread ---> "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
