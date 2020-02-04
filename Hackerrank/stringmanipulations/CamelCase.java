package Hackerrank.stringmanipulations;

import java.util.Scanner;

public class CamelCase {

    private static int camelCase(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))){
                count++;
            }
        }
        return count > 0 ? count+1 : 1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();
        System.out.println(camelCase(s));
    }
}
