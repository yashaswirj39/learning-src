package Hackerrank.stringmanipulations;

import java.util.*;

public class MakingAnagrams {
    protected static int makinganagrams(String a, String b) {

        /*a = a.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        b = b.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();*/

        int count = 0;

        LinkedHashMap<Character, Integer> mapA = new LinkedHashMap<>();
        LinkedHashMap<Character, Integer> mapB = new LinkedHashMap<>();


        for (int i = 0; i < a.length(); i++) {
            if (!mapA.containsKey(a.charAt(i))){
                mapA.put(a.charAt(i), 1);
            } else {
                mapA.put(a.charAt(i), mapA.get(a.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < b.length(); i++) {
            if (!mapB.containsKey(b.charAt(i))){
                mapB.put(b.charAt(i), 1);
            } else {
                mapB.put(b.charAt(i), mapB.get(b.charAt(i)) + 1);
            }
        }


            for (Map.Entry<Character, Integer> entry : mapA.entrySet()){
                if (!mapB.containsKey(entry.getKey())){
                    count += entry.getValue();
                }
            }


            for (Map.Entry<Character, Integer> entry : mapB.entrySet()){
                    if (mapA.containsKey(entry.getKey())){
                        if (Math.abs(mapA.get(entry.getKey()) - entry.getValue()) > 0){
                            count += Math.abs(mapA.get(entry.getKey()) - entry.getValue());
                        }
                    } else {
                        count += entry.getValue();
                    }
            }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        System.out.println(makinganagrams(a, b));
    }
}
