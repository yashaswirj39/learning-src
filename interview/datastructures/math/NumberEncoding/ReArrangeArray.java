package interview.datastructures.math.NumberEncoding;

import java.util.ArrayList;

import java.util.Scanner;

public class ReArrangeArray {
    public static void arrange(ArrayList <Integer> A) {
        int n = A.size();
        for (int i = 0; i < n; i++) {
            int form = (A.get(A.get(i)) % n);
            System.out.println("index ----> " + i + " - "+ form);
            int value = A.get(i) + form * n;
            System.out.println("index value----> " + i + " - "+ value);
            A.set(i, value);
        }

        System.out.println("=========================================");
        for (int i = 0; i < n; i++) {
            int data = A.get(i) / n;
            System.out.println(i + " --> " + data);
            A.set(i, data);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }
        arrange(al);
    }
}
