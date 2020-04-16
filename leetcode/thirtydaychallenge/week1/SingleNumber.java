package leetcode.thirtydaychallenge.week1;

import java.util.Arrays;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 * Input: [1,0,1]
 * Output: 0
 */

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                i++;
            } else {
                res = nums[i];
                break;
            }
        }
        if(len % 2 == 0) {
            return res;
        } else {
            if(res == Integer.MIN_VALUE) {
                res = nums[len - 1];
            }
            return res;
        }
    }
}
