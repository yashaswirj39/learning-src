package leetcode.thirtydaychallenge.week1;

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3286/
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */

public class MoveZeros {

    private static void moveZeros(int[] nums) {
        int pointer_one = 0;
        int pointer_two = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[pointer_one] == 0 && nums[pointer_two] != 0) {
                int temp = nums[pointer_two];
                nums[pointer_two] = nums[pointer_one];
                nums[pointer_one] = temp;
                pointer_one++;
                pointer_two++;
            } else if(nums[pointer_one] == 0 && nums[pointer_two] == 0) {
                pointer_two++;
            } else if(nums[pointer_one] != 0 && nums[pointer_two] == 0) {
                pointer_one++;
                pointer_two++;
            } else if(nums[pointer_one] != 0 && nums[pointer_two] != 0) {
                pointer_one++;
                pointer_two++;
            }
        }
    }

    public static void main(String[] args) {
        //int[] a = {0,1,0,3,12};
        //int[] a = {0,0,0,0,0};
        //int[] a = {0,1,1,1,0};
        //int[] a = {1,0,0,0,1};
        //int[] a = {1,0,0,0,0};
        int[] a = {1,1,1,1,1};
        moveZeros(a);
    }
}
