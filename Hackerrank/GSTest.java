package Hackerrank;

import java.util.Scanner;

public class GSTest {
    public static int findDamagedToy(int N, int T, int D) {
        int count = D;

        for (int i = 0; i < T; i++) {
            if (count != N) {
                count++;
            } else {
                count = 1;
            }
        }
        return count - 1 != 0 ? count - 1 : N;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(findDamagedToy(n, t, d));
    }
}
