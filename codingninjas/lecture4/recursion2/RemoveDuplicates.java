package codingninjas.lecture4.recursion2;

public class RemoveDuplicates {
    public static String removeConsecutiveDuplicates(String s) {
        if (s.length() >= 1) {
            char[] c = remove(s.toCharArray(), 0);
            return new String(c).replaceAll(" ", "");
        } else return s;
    }

    private static char[] remove(char[] c, int index) {
        if (index < c.length - 1) {
            if (index <= c.length - 2) {
                if (c[index] == c[index + 1]) {
                    c[index] = ' ';
                }
                return remove(c, index + 1);
            } else {
                return remove(c, index + 1);
            }
        }
        else return c;
    }
    public static void main(String[] args) {
        System.out.println(removeConsecutiveDuplicates("aabccba"));
    }
}
