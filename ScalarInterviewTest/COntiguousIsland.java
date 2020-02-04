package ScalarInterviewTest;

import java.util.ArrayList;
import java.util.Scanner;

public class COntiguousIsland {
    private static  int  checkIsland(String A, int B) {
        ArrayList<String> al = new ArrayList<>();
        int maxLength = 0;
        String substr = "";
        while (true) {
            for (int i = 0; i < A.length()-1; i++) {
                if (A.charAt(i) == 'a' && A.charAt(i+1) == 'a') {
                     substr += A.charAt(i);
                } else if (A.charAt(i) == 'a' && A.charAt(i+1) == 'b' && B > 0) {
                    substr += A.charAt(i);
                    substr += A.charAt(i+1);
                    B--;
                    i = i+1;
                } else if (A.charAt(i) == 'b' && A.charAt(i+1) == 'a' && B > 0) {

                }
            }
            al.add(substr);
            substr = "";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        String s = sc.next();
        System.out.println(checkIsland(s, b));
    }
}
