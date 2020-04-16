package codingninjas.lecture4.recursion2;

import java.util.LinkedList;
import java.util.List;

/**
 * https://stackoverflow.com/questions/2344496/how-can-i-print-out-all-possible-letter-combinations-a-given-phone-number-can-re
 */
public class ReturnKeyPadCode {

    public static String mappings[][] = {
            {"0"}, {"1"}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"},
            {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"},
            {"t", "u", "v"}, {"w", "x", "y", "z"}
    };

    public static void generateCombosHelper(List<String> combos,
                                            String prefix, String remaining) {
        // The current digit we are working with
        int digit = Integer.parseInt(remaining.substring(0, 1));

        if (remaining.length() == 1) {
            // We have reached the last digit in the phone number, so add
            // all possible prefix-digit combinations to the list
            for (int i = 0; i < mappings[digit].length; i++) {
                combos.add(prefix + mappings[digit][i]);
            }
        } else {
            // Recursively call this method with each possible new
            // prefix and the remaining part of the phone number.
            for (int i = 0; i < mappings[digit].length; i++) {
                generateCombosHelper(combos, prefix + mappings[digit][i],
                        remaining.substring(1));
            }
        }
    }

    public static String[] keypad(int phoneNumber) {
        // This will hold the final list of combinations
        List<String> combos = new LinkedList<String>();

        // Call the helper method with an empty prefix and the entire
        // phone number as the remaining part.
        generateCombosHelper(combos, "", String.valueOf(phoneNumber));

        return combos.toArray(new String[0]);
    }

    public static void main(String[] args) {
        int str = 23;
        String[] combos = keypad(str);

        for (String s : combos) {
            System.out.println(s);
        }
    }
}