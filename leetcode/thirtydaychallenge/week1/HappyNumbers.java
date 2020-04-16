package leetcode.thirtydaychallenge.week1;

/**
 * Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1
 * (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this
 * process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */


public class HappyNumbers {
    public boolean isHappy(int n) {
        if(n == 0) return false;

        if(n == 1) return true;

        int sum = 0;
        while(sum != 1 && sum != 4) {
            while(n > 0) {
                int num = n%10;
                sum += num * num;
                n = n / 10;
            }
            if(sum != 1 && sum != 4) {
                n = sum;
                sum = 0;
            } else {
                break;
            }
        }
        if(sum == 1) {
            return true;
        } else {
            return false;
        }
    }
}
