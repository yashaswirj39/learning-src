package interview.datastructures.array.arraymath;

import java.util.ArrayList;
import java.util.Scanner;

public class AddOneToNumber {
    private static ArrayList<Integer> plusOne(ArrayList<Integer> arrayList) {
        if (arrayList.size() == 1) {
            int num = arrayList.get(0);
            num = num + 1;
            arrayList.remove(0);
            if (num == 10) {
                arrayList.add(0, 1);
                arrayList.add(1, 0);

            } else {
                arrayList.add(0, num);
            }
            return arrayList;
        }
        int remainder = 0;
        int adder = 0;
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (i == arrayList.size() -1 ) {
                int num = arrayList.get(i) + 1;
                num = num + adder;
                remainder = num % 10;
                adder = num / 10;
                arrayList.remove(i);
                arrayList.add(i, remainder);
            } else {
                int num = arrayList.get(i);
                num = num + adder;
                remainder = num % 10;
                adder = num / 10;
                arrayList.remove(i);
                arrayList.add(i, remainder);
            }
        }
        if (adder >= 1) {
            arrayList.add(0, adder);
        }
        int i = 0;
        while (arrayList.get(i) == 0) {
            arrayList.remove(i);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }
        System.out.println(plusOne(al));
    }
}
