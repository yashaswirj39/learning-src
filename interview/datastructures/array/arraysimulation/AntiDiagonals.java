package interview.datastructures.array.arraysimulation;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @testCase-1: 3
 * [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
 * @testCase-2: 2
 * [[1,2],[3,4]]
 * @testcase-3: [[1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9],[4 ,5 ,3 ,2 ,9 ,0 ,8 ,7 ,6],[3 ,4 ,5 ,6 ,7 ,8 ,9 ,1 ,2],[4 ,5 ,6 ,7 ,8 ,9 ,1 ,2 ,3],[5 ,6 ,7 ,8 ,9 ,1 ,2 ,3 ,4],[6 ,7 ,8 ,9 ,1 ,2 ,3 ,4 ,5],[7 ,8 ,9 ,1 ,2 ,3 ,4 ,5 ,6],[8 ,9 ,1 ,2 ,3 ,4 ,5 ,6 ,7],[9 ,1 ,2 ,3 ,4 ,5 ,6 ,7 ,8]]
 */
public class AntiDiagonals {

    private static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        ArrayList<Integer> first_row = new ArrayList<>();
        first_row.add(A.get(0).get(0));
        al.add(first_row);

        int counter = 1;
        while (counter < A.size()) {
            int i = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = counter; j >= 0; j--) {
                temp.add(A.get(i).get(j));
                i++;
            }
            al.add(temp);
            counter++;
        }

        int antiCounter = 1;
        int i = 1;
        int tempArk = 1;
        while (antiCounter < A.size()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int tempJ = 0;
            for (int j = A.size() - 1; j > tempArk; j--) {
                tempJ = j;
                temp.add(A.get(i).get(j));
                if (i < A.size() - 1) {
                    i++;
                } else {
                    temp.add(A.get(i).get(j));
                }
            }
            if (A.size() - 1 - antiCounter == 0) {
                temp.add(A.get(antiCounter).get(antiCounter));
            } else {
                temp.add(A.get(i).get(tempJ - 1));
            }
            tempArk++;
            al.add(temp);
            antiCounter++;
            i = antiCounter;
        }
        return al;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                temp.add(sc.nextInt());
            }
            al.add(temp);
        }

        System.out.println(al);
        System.out.println(diagonal(al));
    }
}
