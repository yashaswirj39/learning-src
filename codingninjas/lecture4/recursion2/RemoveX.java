package codingninjas.lecture4.recursion2;

public class RemoveX {
    public static String removeX(String str) {
        if (str.length() == 0) {
            return str;
        }
        String ans = "";
        if (str.charAt(0) != 'x') {
            ans = ans + str.charAt(0);
        }
        String s = removeX(str.substring(1));
        return ans + s;
    }

    public static void main(String[] args) {
        System.out.println(removeX("xabxcxdxbvxdewxsx"));
    }
}
