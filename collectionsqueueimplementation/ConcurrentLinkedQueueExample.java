package collectionsqueueimplementation;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ConcurrentLinkedQueue<Integer> clq = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < n; i++) {
            clq.add(i);
        }

        ConcurrentLinkedQueue<Integer> clq1 = new ConcurrentLinkedQueue<>(clq);

        System.out.println(clq1);
    }
}
