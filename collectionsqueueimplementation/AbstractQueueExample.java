package collectionsqueueimplementation;

import java.util.AbstractQueue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class AbstractQueueExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        AbstractQueue<Integer> q = new LinkedBlockingQueue<>();
        for (int i = 0; i < n; i++) {
            q.add(sc.nextInt());
        }

        System.out.println("abstract queue head --> " + q.element());
        System.out.println("abstract queue --> " + q);
        System.out.println("offered integer --> " + q.offer(2));
        q.clear();
        System.out.println("After clearing abstract queue ---> " + q);

    }
}
