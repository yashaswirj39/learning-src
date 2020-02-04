package ScalarInterviewTest;

import java.util.ArrayList;
import java.util.Collections;

public class Test3 {
    public int solve(int num, ArrayList<Integer> A, ArrayList<Integer> B) {
        int  count = 0;
        Collections.sort(A);
        Collections.sort(B);
        for (int i = 0; i < A.size(); i++) {
            if (i == 0) {
                count++;
            } else {
                if (A.get(i) != A.get(i+1)) {
                    count++;
                }
            }
        }
        return 0;
    }
}
