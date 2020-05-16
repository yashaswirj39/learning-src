package interview.queue;

import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PriorityQueueWithMap {
    public static void main(String[] args) {
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b)->a.getValue()-b.getValue());

        String[] key = {"A","B","C","D","E","F"};

        int j = 0;
        for (int i = 5; i >= 0; i--) {
            queue.add(new AbstractMap.SimpleEntry<>(key[j], i));
            j++;
        }

        System.out.println(queue);

        System.out.println("=====================");


    }
}
