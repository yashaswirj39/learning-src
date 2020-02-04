package sat.thread.producerconsumer;

import java.util.*;

public class ProducerConsumerExample{
    public static void main(String[] args) throws InterruptedException {
        PC pc = new PC();
        Thread produce = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consume = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        produce.start();
        consume.start();

        produce.join();
        consume.join();
    }
}

class PC {
    LinkedList<Integer> list = new java.util.LinkedList<>();
    int capacity = 2;

    public void produce() throws InterruptedException {
        //System.out.println("inside producer...");
        int value = 0;
        while (true) {
            synchronized (this) {
                //System.out.println("inside produce synchronize");
                while (list.size() == capacity)
                    wait();
                System.out.println("Producer produced: " + value);
                list.add(value++);
                notify();
                Thread.sleep(3000);
            }
        }
    }

    public void consume() throws InterruptedException {
        //System.out.println("Inside consume");
        while (true){
            synchronized (this){
                while (list.size() == 0)
                    wait();
                int val = list.removeFirst();
                System.out.println("consumer sonsumed: "+val);
                notify();
                Thread.sleep(3000);
            }
        }
    }
}