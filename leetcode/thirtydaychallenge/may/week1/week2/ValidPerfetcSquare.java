package leetcode.thirtydaychallenge.may.week1.week2;

public class ValidPerfetcSquare {
    public static boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1) return true;

        long start = 1;
        long end = num;

        while(start <= end) {
           long mid = start + (end -start) / 2;

            if(mid * mid == num) return true;
            else if(mid*mid < num) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(2147483647));
    }
}
