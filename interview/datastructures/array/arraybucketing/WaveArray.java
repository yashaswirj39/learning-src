package interview.datastructures.array.arraybucketing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WaveArray {
    private static ArrayList<Integer> wave(ArrayList<Integer> A) {
        if (A.size() == 1) return A;

        Collections.sort(A);
        if (A.size() % 2 == 0) {
            for (int i = 0; i < A.size(); i = i + 2) {
                int temp = A.get(i);
                A.remove(i);
                A.add(i + 1, temp);
            }
        } else {
            for (int i = 0; i < A.size() - 1; i = i + 2) {
                int temp = A.get(i);
                A.remove(i);
                A.add(i + 1, temp);
            }
        }
        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            al.add(scanner.nextInt());
        }
        System.out.println(wave(al));
    }
}
