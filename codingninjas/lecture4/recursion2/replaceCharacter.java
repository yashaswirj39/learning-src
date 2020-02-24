package codingninjas.lecture4.recursion2;

public class replaceCharacter {
    public static String replaceCharacter(String input, char c1, char c2) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        char[] c = replace(input.toCharArray(), c1, c2, 0);
        return new String(c);
        //return input.replaceAll(String.valueOf(c1), String.valueOf(c2));
    }

    private static char[] replace(char[] c, char c1, char c2, int index) {
        if (index == c.length - 1) {
            return c;
        }
        if (c[index] == c1) {
            c[index] = c2;
        }
        return replace(c, c1, c2, index+1);
    }

    public static void main(String[] args) {
        System.out.println(replaceCharacter("abacd", 'a', 'x'));
    }
}
