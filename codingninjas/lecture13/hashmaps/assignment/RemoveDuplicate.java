package codingninjas.lecture13.hashmaps.assignment;

import java.util.LinkedHashSet;

public class RemoveDuplicate {

    private static String removeduplicateCharacter(String str) {
        //String str = "abcd";
        LinkedHashSet<Character> set  = new LinkedHashSet<>();
        set.add(str.charAt(0));
        set.add(str.charAt(1));
        set.add(str.charAt(2));
        Character[] arr = set.toArray(new Character[0]);
        String res = "";
        for (char s:arr){
            res += s;
        }
        return res;
    }
}
