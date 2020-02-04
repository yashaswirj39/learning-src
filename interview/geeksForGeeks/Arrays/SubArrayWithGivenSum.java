package interview.geeksForGeeks.Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class SubArrayWithGivenSum {
    public static String sum(int sum, ArrayList<Integer> arrayList) {
        if (arrayList.isEmpty()) {
            return String.valueOf(-1);
        }
        String str = "";

        int resultSum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i; j < arrayList.size(); j++) {
                if (resultSum < sum) {
                    resultSum += arrayList.get(j);
                    str += j + 1;
                    str += " ";
                } else if (resultSum == sum) {
                    break;
                } else {
                    str = "";
                    resultSum = 0;
                    break;
                }
            }
            if (resultSum == sum) {
                break;
            } else {
                str = "";
                resultSum = 0;
            }
        }
        if (str.length() > 0) {
            String[] res = str.split(" ");
            return res[0] + " " + res[res.length - 1];
        } else return String.valueOf(-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();

        while (tc-- > 0) {
            int size = scanner.nextInt();
            int sum = scanner.nextInt();
            ArrayList<Integer> al = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                al.add(scanner.nextInt());
            }

            System.out.println(sum(sum, al));
        }
    }
}
