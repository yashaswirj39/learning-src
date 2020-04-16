package codingninjas.lecture4.recursion2.assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class ReturnArraySubset {
    public static int[][] subsets(int input[]) {
        int index = input.length - 1;
        ArrayList<ArrayList<Integer>> result = getSubset(input, index);
        int[][] array = new int[result.size()][];
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[result.get(i).size()];
        }
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                array[i][j] = result.get(i).get(j);
            }
        }
        return array;
    }

    static ArrayList<ArrayList<Integer>> getSubset(int[] set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;
        if (index < 0) {
            allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(new ArrayList<Integer>());
        } else {
            allSubsets = getSubset(set, index - 1);
            int item = set[index];
            ArrayList<ArrayList<Integer>> moreSubsets
                    = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> subset : allSubsets) {
                ArrayList<Integer> newSubset = new ArrayList<Integer>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }

    public static void main(String[] args) {

        int[] set = {15, 20, 12};
        int[][] subset = subsets(set);
        System.out.println(Arrays.deepToString(subset));
    }
}
