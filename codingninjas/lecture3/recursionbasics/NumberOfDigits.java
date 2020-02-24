package codingninjas.lecture3.recursionbasics;

import java.util.Scanner;

public class NumberOfDigits {
    public static int count(int n) {
        if (n==0){
            return 0;
        }
        n = count(n/10) + 1;
        return n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(count(num));
    }
}
