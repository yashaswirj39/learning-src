package codingninjas.lecture13.hashmaps.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LongestSubsetZerocSum {

    public static int lengthOfLongestSubsetWithZeroSum(ArrayList<Integer> arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
                if (sum == 0) {
                    max = i;
                    break;
                }
            } else {
                if (max < (i - hm.get(sum))) {
                    max = i - hm.get(sum);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }
        System.out.println(lengthOfLongestSubsetWithZeroSum(al));
    }
}
