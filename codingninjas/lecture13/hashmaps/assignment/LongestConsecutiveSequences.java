package codingninjas.lecture13.hashmaps.assignment;

import java.util.ArrayList;
import java.util.Collections;

public class LongestConsecutiveSequences {
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list);


        return null;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        longestConsecutiveIncreasingSequence(a);
    }
}
