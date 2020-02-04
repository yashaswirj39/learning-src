package collectionsqueueimplementation;

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        LinkedBlockingQueue<Integer> lbq = new LinkedBlockingQueue<>();

        for (int i = 0; i < n; i++) {
            lbq.add(i);
        }

        System.out.println(lbq);
    }
}
