package collectionsqueueimplementation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.add(sc.nextInt());
        }

        System.out.println(q.peek());
        System.out.println(q.element());
        System.out.println(q.remove());
        System.out.println(q.size());
        System.out.println(((LinkedList<Integer>) q).pollFirst());
        System.out.println(((LinkedList<Integer>) q).pollLast());
    }
}
