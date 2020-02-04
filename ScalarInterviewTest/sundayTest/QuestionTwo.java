package ScalarInterviewTest.sundayTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuestionTwo {
    private static int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int size = A.size();
        int last = A.get(size-1);
        int i = 0;
        int sum = 0;
        while (i != size-1) {
            sum+=Math.abs(A.get(i) - last);
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }
        System.out.println(solve(al));
    }
}
