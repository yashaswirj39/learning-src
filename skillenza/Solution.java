package skillenza;

import java.util.*;

class Solution {
    private static List<Integer> setOperation(Set<Integer> set1, Set<Integer> set2, int operation){
        if (operation == 1){
            set1.retainAll(set2);
            List<Integer> list = new ArrayList<>(set1);
            Collections.sort(list);
            return list;
        } else if (operation == 2){
            set1.addAll(set2);
            List<Integer> list = new ArrayList<>(set1);
            Collections.sort(list);
            return list;
        } else if (operation == 3){
            Set<Integer> set3 = new HashSet<>();
            set3.addAll(set1);
            set3.addAll(set2);
            set1.retainAll(set2);
            set3.removeAll(set1);
            List<Integer> list = new ArrayList<>(set3);
            Collections.sort(list);
            return list;
        } else if (operation == 4){
            set1.removeAll(set2);
            List<Integer> list = new ArrayList<>(set1);
            Collections.sort(list);
            return list;
        } else if (operation == 5){
            set2.removeAll(set1);
            List<Integer> list = new ArrayList<>(set2);
            Collections.sort(list);
            return list;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        while (testCase-- > 0){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            if (m == 0 || n==0){
                continue;
            }
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();
            for (int i = 0; i < m; i++) {
                set1.add(scanner.nextInt());
            }
            for (int i = 0; i < n; i++) {
                set2.add(scanner.nextInt());
            }
            int operations = scanner.nextInt();
            System.out.println(setOperation(set1, set2, operations)
                    .toString()
                    .replaceAll("\\[","{")
                    .replaceAll("\\]","}"));
        }
    }
}