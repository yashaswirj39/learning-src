package Hackerrank.implementations.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Abs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> hm = new HashMap<>();
        String[] abc = new String[9];

        for (int i = 0; i < abc.length; i++) {
            abc[i] = sc.next();
            hm.put(abc[i], i+1);
        }
        System.out.println(Arrays.toString(abc));
        System.out.println(hm);
    }


}
