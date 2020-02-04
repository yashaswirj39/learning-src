package interview.datastructures.array.arrangements;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @testcase-1 4
 * 4
 * 1 2 3 4
 * 5 6 7 8
 * 4 3 2 1
 * 8 7 6 5
 * @testcase-2 3
 * 3
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * @testcase-3 2
 * 2
 * 1 2
 * 3 4
 */
public class RotateMatrix {
    private static void rotate(ArrayList<ArrayList<Integer>> a) {
        if (a.isEmpty() || a == null) return;

        ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();


        int count = 0;

        while (count != a.size()) {
            ArrayList<Integer> list = new ArrayList<>();
            int counter = a.size() - 1;
            while (counter >= 0) {
                list.add(a.get(counter).get(count));
                counter--;
            }
            count++;
            finalList.add(list);
        }
        a = finalList;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < a.size(); i++) {
            sb.append("[");
            for (int j = 0; j < a.get(i).size(); j++) {
                sb.append(a.get(i).get(j)).append(" ");
            }
            sb.append("]").append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                innerList.add(sc.nextInt());
            }
            al.add(innerList);
        }

        System.out.println(al);
        System.out.println("Result after rotating to 90  degree");
        rotate(al);
    }
}
