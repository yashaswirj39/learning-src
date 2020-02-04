package MultiThreading.producerconsumer.producer.factory;

import MultiThreading.producerconsumer.FileReader;

import java.util.Queue;

public class Dataproducer implements Runnable {

    public FileReader reader;
    public String path;
    public Queue<String> queue;

    public Dataproducer(FileReader reader, String path, Queue<String> queue) {
        this.reader = reader;
        this.path = path;
        this.queue = queue;
    }

    public void addData() {
        queue.addAll(this.reader.readFile(path));
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == 20) {
                    try {
                        System.out.println("Producer Queue is full...... hence moved to wait state for 30 seconds --> "+Thread.currentThread().getName());
                        queue.wait(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (queue.isEmpty()){
                    try {
                        queue.wait(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                addData();
                queue.notify();
                System.out.println("data inside producer queue --> " + queue);
            }
        }
    }
}