package interview.datastructures.math.NumberTheory;

import java.util.*;

public class SortedPermutationsRank {
    static TreeSet<String> al = new TreeSet<>();
    private static int findRank(String m) {
        findPermutation(m, "");
        int index = al.headSet(m).size();
        al.clear();
        return index;
    }

    private static void findPermutation(String str, String ans) {

        if (str.length() == 0) {
            al.add(ans);
        }

        boolean alpha[] = new boolean[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            String ros = str.substring(0,i) + str.substring(i+1);
            //findPermutation(ros, ans+ch);
            if (alpha[ch - 'a'] == false)
                findPermutation(ros, ans + ch);
            alpha[ch - 'a'] = true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        System.out.println(findRank(n));
    }
}
