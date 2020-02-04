package leetcode.trees.randomproblems;

public class ValidAnagrams {
    private static  boolean anagrams(String s, String t){
        if (s.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString().equals(t.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString())) return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(anagrams(s, t));
    }
}
