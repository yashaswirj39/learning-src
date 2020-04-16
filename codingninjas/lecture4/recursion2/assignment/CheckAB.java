package codingninjas.lecture4.recursion2.assignment;

import java.util.Scanner;

public class CheckAB {

    private static boolean checkABpattern(String str) {
        if (str.length() <= 0) {
            return false;
        }

        /*if (str.startsWith("a") && str.substring(1, 2).equalsIgnoreCase("a")) {
            checkABpattern(str.substring(1));
        } else if (str.startsWith("a") && str.substring(1,2).equalsIgnoreCase("")) {
            checkABpattern(str.substring(1));
        } else if (str.startsWith("a") && str.substring(1,3).equalsIgnoreCase("bb")) {
            checkABpattern(str.substring(3));
        } else if (str.startsWith("bb") && str.substring(2,3).equalsIgnoreCase("a")) {
            checkABpattern(str.substring(3));
        } else if (str.startsWith("bb") && str.substring(2,3).equalsIgnoreCase("")) {
            checkABpattern(str.substring(3));
        } else {
            checkABpattern(str.substring(1));
        }*/
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' && str.substring(1, 2).equalsIgnoreCase("a")) {
                flag = true;
            } else if (str.charAt(i) == 'a' && str.substring(1,2).equalsIgnoreCase("")) {
                flag = true;
            } else if (str.charAt(i) == 'a' && str.substring(1,3).equalsIgnoreCase("bb")) {
                flag = true;
            } else if (str.charAt(i) == 'b' && str.charAt(i+1) == 'b'
                    && str.substring(2,3).equalsIgnoreCase("a")) {
                flag = true;
            } else if (str.charAt(i) == 'b' && str.charAt(i+1) == 'b'
                    && str.substring(2,3).equalsIgnoreCase("")) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private static boolean checkABloop(String str) {
        if (str.length() == 0) {
            return false;
        } else {
            for (int i = 0; i < str.length(); i++) {

            }
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(checkABpattern(str));
    }
}
