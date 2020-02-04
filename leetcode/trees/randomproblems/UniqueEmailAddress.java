package leetcode.trees.randomproblems;

import java.util.HashSet;
import java.util.Scanner;

public class UniqueEmailAddress {
    private int numUniqueEmails(String[] emails) {
        HashSet<String> hs = new HashSet<>();
        for (String email : emails) {
            String s;
            String s1 = email.substring(0, email.indexOf("@"));
            if (s1.contains("+") && s1.contains(".")) {
                s = s1.substring(0, s1.indexOf("+")).replaceAll("\\.", "") +
                        email.substring(email.indexOf("@"));
                hs.add(s);
            } else if (s1.contains("+")) {
                s = s1.substring(0, s1.indexOf("+")) +
                        email.substring(email.indexOf("@"));
                hs.add(s);
            } else if (s1.contains(".")) {
                s = s1.replaceAll("\\.", "") +
                        email.substring(email.indexOf("@"));
                hs.add(s);
            } else {
                hs.add(email);
            }
        }
        return hs.size();
    }
        public static void main (String[]args){

            UniqueEmailAddress uniqueEmailAddress = new UniqueEmailAddress();

            Scanner scanner = new Scanner(System.in);

            int n = scanner.nextInt();

            String array[] = new String[n];

            for (int i = 0; i < n; i++) {
                array[i] = scanner.next();
            }
            System.out.println(uniqueEmailAddress.numUniqueEmails(array));
        }
    }
