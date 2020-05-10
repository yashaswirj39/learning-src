package leetcode.thirtydaychallenge.may.week1;

import java.util.Scanner;

public class FirstBadVersion {

    static boolean arr[] = new boolean[2126753390];
    //2126753390
    //1702766719

    public static void insertArray() {
        for (int i = 0; i < arr.length; i++) {
            if (i <= 2126753) {
                arr[i] = false;
            } else {
                arr[i] = true;
            }
        }
    }

    static boolean  isBadVersion(int version) {
        return arr[version];
    }

    public static int firstBadVersion(int n) {

        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        insertArray();
        long start = System.currentTimeMillis();
        System.out.println(firstBadVersion(n));
        System.out.println(System.currentTimeMillis() - start);
    }
}

//0 1 2 3 4
//1 2 3 4 5