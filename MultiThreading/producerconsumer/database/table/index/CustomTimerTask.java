package MultiThreading.producerconsumer.database.table.index;


import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class CustomTimerTask {
    public  void testTimer(long scheduledDateMillis) throws InterruptedException {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("the scheduled timer is: " + scheduledDateMillis);
            }
        };
        Timer timer = new Timer("Timer");

        /*long delay = 1000L;*/
        //long period = 1000L * 60L * 60L * 24L;
        /*long period = 1000L;*/
        /*timer.scheduleAtFixedRate(task, 0, scheduledDate.getTime());*/
        timer.scheduleAtFixedRate(task, 0, scheduledDateMillis);

        Thread.sleep(1000L * 2L);
        task.cancel();
        timer.cancel();
    }

    public static void main(String[] args) {
        CustomTimerTask ctt = new CustomTimerTask();
    }
}