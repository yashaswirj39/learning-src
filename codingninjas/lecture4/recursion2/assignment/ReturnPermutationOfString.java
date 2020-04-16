package codingninjas.lecture4.recursion2.assignment;

import java.util.ArrayList;
import java.util.List;

public class ReturnPermutationOfString {

    public static String[] permutationOfString(String s) {
        return permutationFinder(s).toArray(new String[0]);
    }

    public static List<String> permutationFinder(String str) {
        List<String> perm = new ArrayList<>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        List<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    static String[] printPermutn(String str, String ans, String[] array, int position) {
        if (str.length() == 0) {
            array[position] = ans;
            position++;
            return array;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            printPermutn(ros, ans + ch, array, position);
        }
        return array;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    public static void main(String[] args) {
        String s = "abc";
        String[] array = permutationOfString(s);
        for (String a: array) {
            System.out.println(a);
        }
    }
}
