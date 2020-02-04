package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueExample <E>{

    private Queue<E> queue;
    private int max = 16;
    private ReentrantLock lock = new ReentrantLock(true);
    private Object noEmpty = new Object();
    private Object noFull = new Object();


    private BlockingQueueExample(int size){
        queue = new LinkedList<>();
        this.max = size;
    }

    public synchronized void put(E e){
        try {
            if (queue.size() == max){
                noFull.wait();
            }
            queue.add(e);
            noEmpty.notifyAll();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public synchronized E take(){
        E item = null;
        try {
            while (queue.size() == 0){
                noEmpty.wait();
            }
            item = queue.remove();
            noFull.notifyAll();
            return item;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return item;
    }
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(n);

        for (int i = 0; i < n; i++) {
            final Runnable producer = () -> {
                while (true) {
                    try {
                        queue.put(sc.nextInt());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            new Thread(producer).start();
            new Thread(producer).start();

            final Runnable consumer = () -> {
                while (true) {
                    try {
                        int b = queue.take();
                        System.out.println(b);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            new Thread(consumer).start();
            new Thread(consumer).start();
        }
    }*/
}
