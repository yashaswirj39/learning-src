package skillenza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class SetOperations {

    private static void andSet(Set<String> set1, Set<String> set2) {
        set1.retainAll(set2);
        print(set1);
    }

    private static void orSet(Set<String> set1, Set<String> set2) {
        set1.addAll(set2);
        print(set1);
    }

    private static void xorSet(Set<String> set1, Set<String> set2) {
        Set<String> set3 = new HashSet<>();
        set3.addAll(set1);
        set3.addAll(set2);
        set1.retainAll(set2);
        set3.removeAll(set1);
        print(set3);
    }

    private static void aMinusbSet(Set<String> set1, Set<String> set2) {
        set1.removeAll(set2);
        print(set1);
    }

    private static void bMinusaSet(Set<String> set1, Set<String> set2) {
        set2.removeAll(set1);
        print(set2);
    }

    private static void print(Set<String> res) {
        List<String> resList = new ArrayList<>(res);
        Collections.sort(resList);
        String result = "";
        result = String.join(", ", resList);
        System.out.println("{" + result + "}");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            br.readLine();
            String[] A = br.readLine().split(" ");
            String[] B = br.readLine().split(" ");
            String op = br.readLine();

            Set<String> set1 = new HashSet<>(Arrays.asList(A));
            Set<String> set2 = new HashSet<>(Arrays.asList(B));
            switch (op) {
                case "1":
                    andSet(set1, set2);
                    break;
                case "2":
                    orSet(set1, set2);
                    break;
                case "3":
                    xorSet(set1, set2);
                    break;
                case "4":
                    aMinusbSet(set1, set2);
                    break;
                case "5":
                    bMinusaSet(set1, set2);
                    break;
            }
        }
    }
}
