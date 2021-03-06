package interview.datastructures.array.arraysimulation;

import java.util.ArrayList;
import java.util.Scanner;

public class KthRowOfPascalTriangle {
    private static ArrayList<Integer> pascalTriangle(int A) {
        ArrayList<ArrayList<Integer>> pascalList = new ArrayList<>();

        if (A == 0) {
            ArrayList<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            pascalList.add(firstRow);
            return pascalList.get(0);
        }

        if (A == 1) {
            ArrayList<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            pascalList.add(firstRow);
            ArrayList<Integer> secondRow = new ArrayList<>();
            secondRow.add(1);
            secondRow.add(1);
            pascalList.add(secondRow);
            return pascalList.get(1);
        }

        if (A > 1) {
            ArrayList<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            pascalList.add(firstRow);
            ArrayList<Integer> secondRow = new ArrayList<>();
            secondRow.add(1);
            secondRow.add(1);
            pascalList.add(secondRow);
            A = A - 2;
            A = A + 1;
            while (A > 0) {
                ArrayList<Integer> traverseList = pascalList.get(pascalList.size() - 1);
                if (traverseList.size() == 2) {
                    ArrayList<Integer> sublist = new ArrayList<>();
                    sublist.add(1);
                    sublist.add(2);
                    sublist.add(1);
                    pascalList.add(sublist);
                } else {
                    ArrayList<Integer> sublist = new ArrayList<>();
                    sublist.add(1);
                    for (int i = 0; i < traverseList.size() - 1; i++) {
                        sublist.add(traverseList.get(i) + traverseList.get(i + 1));
                    }
                    sublist.add(1);
                    pascalList.add(sublist);
                }
                A--;
            }
        }
        return pascalList.get(pascalList.size() - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(pascalTriangle(n));
    }
}