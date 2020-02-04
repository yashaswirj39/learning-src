package interview.datastructures.array.arraymath;

/**
 * This is Kadanes algorithm
 * Please follow youtube channel by CSDojo Kadane's algorithm
 */
public class MaximumSumContiguousSubarray {

    private static int maxSubArray(int[] A) {
        int maxCurr = A[0];
        int maxGlobal = A[0];

        if (A.length == 2) {
            maxCurr = Math.max(A[1], A[1] + maxCurr);
            if (maxCurr > maxGlobal) {
                maxGlobal = maxCurr;
            }
        }

        for (int i = 1; i < A.length - 1; i++) {
            maxCurr = Math.max(A[i], A[i] + maxCurr);
            if (maxCurr > maxGlobal) {
                maxGlobal = maxCurr;
            }
        }
        return maxGlobal;
    }
    public static void main(String[] args) {
        //int[] arr = {-1, 3, 4, -5, 9, -2}; //ans = 11
        //int[] arr = {1,2,3,4,-10}; //and = 10
        //int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // ans = 6
        //int[] arr = {1}; // and = 1;
        int[] arr = {-163, -20 };
        System.out.println(maxSubArray(arr));
    }
}
