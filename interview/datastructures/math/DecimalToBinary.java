package interview.datastructures.math;

import java.util.Scanner;

public class DecimalToBinary {
    private static String decimalToBinaryConversion(int A) {
        StringBuffer stringBuffer = new StringBuffer();
        while (A > 0) {
            int rem = A % 2;
            stringBuffer.append(rem);
            A = A/2;
        }
        return stringBuffer.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(decimalToBinaryConversion(num));
    }
}
