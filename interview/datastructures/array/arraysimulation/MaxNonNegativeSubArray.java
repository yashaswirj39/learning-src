package interview.datastructures.array.arraysimulation;

import java.util.*;

/**
 * @testcase-1: 6
 * 1 2 5 -7 2 3
 * @testcase-2: 6
 * 10 -1 2 3 -4 100
 * @testcase-3 10
 * 336465782 -278722862 -2145174067 1101513929 1315634022 -1369133069 1059961393 628175011 -1131176229 -859484421
 */

public class MaxNonNegativeSubArray {
    private static ArrayList<Integer> maxSet(ArrayList<Integer> A) {
        if (A.size() == 1 && A.get(0) >= 0)
            return A;

        HashMap<Long, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) >= 0) {
                sum += A.get(i);
                if (list.size() == 0) {
                    list.add(i);
                }
                list.add(A.get(i));
            } else {
                if (!list.isEmpty()) {
                    if (!map.containsKey(sum)) {
                        ArrayList<Integer> value = new ArrayList<>(list);
                        map.put(sum, value);
                        list.clear();
                    } else {
                        if (map.get(sum).size() > list.size()) {
                            list.clear();
                            continue;
                        } else if (map.get(sum).size() < list.size()) {
                            ArrayList<Integer> updatedValue = new ArrayList<>(list);
                            map.put(sum, updatedValue);
                            list.clear();
                        } else if (map.get(sum).size() == list.size() && map.get(sum).get(0) < list.get(0)) {
                            list.clear();
                            continue;
                        } else if (map.get(sum).size() == list.size() && map.get(sum).get(0) > list.get(0)) {
                            ArrayList<Integer> leastIndexedValue = new ArrayList<>(list);
                            map.put(sum, leastIndexedValue);
                            list.clear();
                        }
                    }
                    sum = 0;
                }
            }
        }

        if (sum > 0) {
            if (!map.containsKey(sum)) {
                ArrayList<Integer> value = new ArrayList<>(list);
                map.put(sum, value);
                list.clear();
            } else {
                if (map.get(sum).size() > list.size()) {
                    list.clear();
                } else if (map.get(sum).size() > list.size()) {
                    ArrayList<Integer> updatedValue = new ArrayList<>(list);
                    map.put(sum, updatedValue);
                    list.clear();
                } else if (map.get(sum).size() == list.size() && map.get(sum).get(0) < list.get(0)) {
                    list.clear();
                } else if (map.get(sum).size() == list.size() && map.get(sum).get(0) > list.get(0)) {
                    ArrayList<Integer> leastIndexedValue = new ArrayList<>(list);
                    map.put(sum, leastIndexedValue);
                    list.clear();
                }
            }
        }
        if (!map.isEmpty()) {
            System.out.println(map);
            long mx = Collections.max(map.keySet());
            return new ArrayList<>(map.get(mx).subList(1, map.get(mx).size()));
        } else {
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        long start = System.currentTimeMillis();
        System.out.println(maxSet(list));
        System.out.println(System.currentTimeMillis() - start);
        System.gc();
    }
}