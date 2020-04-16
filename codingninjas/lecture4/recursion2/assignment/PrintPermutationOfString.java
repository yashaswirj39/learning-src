package codingninjas.lecture4.recursion2.assignment;

public class PrintPermutationOfString {
    public static void permutations(String input){
        String ans = "";
        printPermutn(input, ans);
    }

    static void printPermutn(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            printPermutn(ros, ans + ch);
        }
    }

    public static void main(String[] args) {
        String s = "abb";
        permutations(s);
    }
}
