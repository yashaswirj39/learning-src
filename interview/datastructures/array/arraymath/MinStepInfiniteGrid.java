package interview.datastructures.array.arraymath;

import java.util.ArrayList;

public class MinStepInfiniteGrid {

    public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A.size() <= 1 && B.size() <= 1)
            return 0;

        int res = 0;
        for(int i = 0; i < A.size(); i++) {
            res = res + Math.max(Math.abs(A.get(i) - A.get(i-1)), Math.abs(B.get(i) - B.get(i-1)));
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(-7);
        list1.add(-13);
        list2.add(1);
        list2.add(-5);
        System.out.println(coverPoints(list1, list2));
    }
}
