package codingninjas.lecture4.recursion2.assignment;

/**
 * https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
 */

public class PrintArraySubset {

    private static void subset(int[] input) {
        int n = input.length;
        for (int i = 0; i < (1<<n); i++)
        {
            for (int j = 0; j < n; j++)
                if ((i & (1 << j)) > 0)
                    System.out.print(input[j] + " ");

            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] arr = {15, 20, 12};
        subset(arr);
    }
}
