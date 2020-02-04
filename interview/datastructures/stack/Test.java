package interview.datastructures.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> al = new ArrayList<>();
        for (int i = 0; i < 22; i++) {
            al.add(sc.next());
        }
        Collections.sort(al);
        System.out.println(al);
    }
}
