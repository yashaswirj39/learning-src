package leetcode.trees.randomproblems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueMorseCode {
    private static int umw(String[] array){
        System.out.println('z'-'a');
        String str = "";
        Set<String> set = new HashSet<>();
        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for (String s : array){
            for (int i = 0; i < s.length(); i++) {
                 str += code[alpha.indexOf(Character.toString(s.charAt(i)))];
            }
            set.add(str);
            str = "";
        }
        System.out.println(set);
        return set.size();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        String arr[] = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }
        System.out.println(umw(arr));
    }
}
