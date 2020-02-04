package collectionsqueueimplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * its a bounded queue means the size of the queue will be fixed
 */
public class ArrayBlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        /*Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();*/

        ArrayBlockingQueue<Integer> abqe = new ArrayBlockingQueue<>(5);

        for (int i = 0; i < 5; i++) {
            abqe.put(i);
        }

        List<Integer> list = new ArrayList<>();
        System.out.println(abqe);
        System.out.println(abqe.size());
        System.out.println(abqe.poll());
        System.out.println(abqe.take());
        System.out.println(abqe.remainingCapacity());
        System.out.println("size is full, then trying to insert into queue using offer() --> "+abqe.offer(10));
        System.out.println(abqe);
        abqe.drainTo(list);
        System.out.println(list);
    }
}
