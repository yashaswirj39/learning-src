package ScalarInterviewTest;

import java.util.ArrayList;
import java.util.Scanner;

public class RotaatingTheString {
    private static ArrayList<Integer> rotate(String s, ArrayList<Integer> B) {
        ArrayList<Integer> resultList= new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            if (B.get(i) == s.length() || B.get(i) == 0) {
                resultList.add(s.length());
            } else {
                int rotation = B.get(i);
                char[] c = s.toCharArray();
                while (rotation-- > 0) {
                    char temp = c[c.length - 1];
                    for (int j = c.length - 2; j >= 0; j--) {
                        c[j + 1] = c[j];
                    }
                    c[0] = temp;
                }
                int count = 0;
                for (int j = 0; j < c.length; j++) {
                    if (s.charAt(j) == c[j]) {
                        count++;
                    }
                }
                resultList.add(count);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }
        System.out.println(rotate(s, al));
    }
}
