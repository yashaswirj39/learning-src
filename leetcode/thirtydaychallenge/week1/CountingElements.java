package leetcode.thirtydaychallenge.week1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CountingElements {
    public static int countElements(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        int  counter = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) == 1) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        //int[] arr = {1,2,3};
        //int[] arr = {1,1,3,3,5,5,7,7};
        //int[] arr = {1,3,2,3,5,0};
        int[] arr = {1,1,2,2};
        System.out.println(countElements(arr));
    }
}
