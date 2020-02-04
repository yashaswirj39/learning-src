package leetcode.trees.randomproblems;

import java.util.Scanner;

public class LastWordLength {
    private static int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) return 0;

        String[] splitArray = s.split(" ");
        if (splitArray.length < 1) return 0;

        if (splitArray.length >= 1){
            return splitArray[splitArray.length - 1].length();
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(lengthOfLastWord(s));
    }
}
