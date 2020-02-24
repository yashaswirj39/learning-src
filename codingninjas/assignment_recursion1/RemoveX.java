package codingninjas.assignment_recursion1;

public class RemoveX {
    private static String removeX(String input) {
        if (input.length() > 0) {
            if (input.contains("x"))
                return input.replaceAll("x", "");
        }
        return input;
    }
}
