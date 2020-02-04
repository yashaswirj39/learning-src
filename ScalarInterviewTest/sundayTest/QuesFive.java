package ScalarInterviewTest.sundayTest;

import java.util.ArrayList;
import java.util.Scanner;

public class QuesFive {
    static void findNumberOfDigits(long n, int base)
    {

        // Calculating log using base changing
        // property and then taking it
        // floor and then adding 1.
        int dig = (int)(Math.floor(
                Math.log(n) / Math.log(base))
                + 1);


        // printing output
        System.out.println("The Number of digits of Number "
                + n + " in base " + base
                + " is " + dig);
    }
    public static void main(String[] args) {
        /*long n = 10573;
        int base = 7;

        // calling the method
        findNumberOfDigits(n, base);*/
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        ArrayList<Integer> result = new ArrayList<>();

        int remainder = 0;
        boolean finish = false;

        while (!finish) {
            if (number == 0) {
                finish = true;
            } else {
                remainder = number % 7;
                number = number / 7;
                result.add(remainder);
            }
            remainder = 0;
        }
        for (int i = result.size()-1; i >=0 ; i--) {
            int a = result.get(i);
            System.out.print(a);
        }
        System.out.println();
    }
}
