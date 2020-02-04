package leetcode.trees.randomproblems;

import java.util.Scanner;

public class JewelsAndStones {
    private static int jewelsAndStones(String j, String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (j.contains(Character.toString(s.charAt(i)))){
                    count++;
                }
            }
            return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String j = scanner.next();
        String s = scanner.next();

        System.out.println(jewelsAndStones(j, s));
    }
}
