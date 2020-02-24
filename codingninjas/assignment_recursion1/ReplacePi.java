package codingninjas.assignment_recursion1;

import java.util.Scanner;

public class ReplacePi {
    public static String replace(String input){
        // Write your code here
        if(input.contains("pi")) {
            return input.replaceAll("pi", String.valueOf(3.14));
        }
        return input;
    }
    /*private static String result(String input) {

    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(replace(s));
    }
}
