package interview.datastructures.math.adhoc;

import java.util.ArrayList;
import java.util.Scanner;

public class FizzBuzz {
    private static ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> al = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                al.add("FizzBuzz");
            } else if (i % 5 == 0) {
                al.add("Buzz");
            } else if (i % 3 == 0) {
                al.add("Fizz");
            } else {
                al.add(String.valueOf(i));
            }
        }
        return al;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fizzBuzz(n));
    }
}
