package codingninjas.test1;

import java.util.Arrays;
import java.util.Scanner;

public class MaxProfit {

    public static int maximumProfit(int budget[]) {
        Arrays.sort(budget);
        int maxProfit = 0;
        int len = budget.length;
        for (int i = 0; i < budget.length; i++) {
            int result = (budget[i] * (len - i));
            if (maxProfit < result) {
                maxProfit = result;
            } else continue;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(maximumProfit(array));
    }
}
