package interview.queue;

import java.util.PriorityQueue;

public class PriorityQueueUSel {
    public static void main(String[] args) {
        PriorityQueue<Entry> pq = new PriorityQueue<>();
        String[] key = {"A","B","C","D","E","F"};
        int j = 0;
        for (int i = 5; i >= 0 ; i--) {
            pq.add(new Entry(key[j], i));
            j++;
        }

        System.out.println(pq.size());

        pq.add(new Entry("A", 3));

        while (!pq.isEmpty()) {
            Entry entry = pq.poll();
            System.out.println(entry.key + " = " + entry.element);
        }
    }
}
