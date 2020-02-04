package ScalarInterviewTest.sundayTest;

import java.util.*;

public class QuestionOne {

    private static int solve(ArrayList<Integer> A) {
        int count = 0;
        while (!A.isEmpty()) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < A.size(); ) {
                if (!set.contains(A.get(j))) {
                    set.add(A.get(j));
                    A.remove(j);
                } else {
                    j++;
                    continue;
                }
            }
            count++;
        }
        return count;
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
