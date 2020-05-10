package recursion;

public class reverseString {

    public static void printReverse(char[] str) {
        helper(0, str, str.length - 1);
    }

    public static void helper(int index, char[] str, int len) {
        if (str == null || index >= str.length) {
            return;
        }

        helper(index + 1, str, len - 1);
        if(len < (str.length / 2)) {
            char c = str[len];
            str[len] = str[index];
            str[index] = c;
        }
        System.out.println(str[len]);
    }

    public static void main(String[] args) {
        char[] str = {'a', 'b', 'c', 'd', 'e'};
        printReverse(str);
    }
}
