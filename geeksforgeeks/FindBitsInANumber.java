package geeksforgeeks;

import java.util.Scanner;

public class FindBitsInANumber {
    protected static int getBits(int n, int m, int o){
        System.out.println((Integer.bitCount(n^m) *2) + (Integer.bitCount(m^o) * 2)+ (Integer.bitCount(n^o)* 2));
        return (Integer.bitCount(n^m^o) * 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int o = sc.nextInt();

        System.out.println(getBits(n,m,o));
    }
}
