package Hackerrank.stringmanipulations;

import java.util.*;

public class SherlockAndValidString {


    /*from collections import Counter

        def isValid(s):
        cnt = Counter(s)
        if len(set(cnt.values())) == 1:
        return "YES"
        elif len(set(cnt.values())) > 2:
        return "NO"
    else:
        m1 = max(cnt.values())
        m2 = min(cnt.values())
        if cnt.values().count(m2) == 1:
        return "YES"
        if cnt.values().count(m1) > 1 or m1 - m2 > 1:
        return "NO"
        return "YES"

        s = raw_input().strip()
        result = isValid(s)
        print(result)*/

    private static String isValid(String s) {

        /**
         * sort String using lambda stream api
         */
        System.out.println(s.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
        LinkedHashMap<Character, Integer> charOccurance = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            if (!charOccurance.containsKey(c))
                charOccurance.put(c, 1);
            else {
                charOccurance.put(c, charOccurance.get(c) + 1);
            }
        }

        Set<Integer> values = new HashSet<>(charOccurance.values());

        if (values.size() == 1) return "YES";
        else if (values.size() > 2) return "NO";
        else {
            int m1 = Collections.max(values);
            int m2 = Collections.min(values);

            if (values.stream().distinct().count() == 1)
                return "YES";
            if (values.stream().distinct().count() > 1) {
                int maxCount = (int) charOccurance
                        .entrySet()
                        .stream()
                        .filter(entry -> entry.getValue().equals(m1)).count();

                int minCount = (int) charOccurance
                        .entrySet()
                        .stream()
                        .filter(entry -> entry.getValue().equals(m2)).count();

                if (maxCount < minCount && maxCount > 1) {
                    return "NO";
                } else if (maxCount < minCount && maxCount == 1 /*&& m1 - m2 == 1*/) {
                    if (maxCount == m1) {
                        return "YES";
                    } else {
                        return "NO";
                    }
                }

                if (minCount < maxCount && minCount > 1) {
                    return "NO";
                } else if (minCount < maxCount && minCount == 1 /*&& m1 - m2 == 1*/) {
                    if (minCount == m2) {
                        return "YES";
                    } else {
                        return "NO";
                    }
                }

                if (minCount == maxCount && minCount > 1) {
                    return "NO";
                } else if (minCount == maxCount && minCount == 1) {
                    return "YES";
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(isValid(s));

    }
}
