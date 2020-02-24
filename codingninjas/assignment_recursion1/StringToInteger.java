package codingninjas.assignment_recursion1;

public class StringToInteger {
    public static int convertStringToInt(String input){
        // Write your code here
        if (input.length() > 0) {
            return Integer.parseInt(input);
        }
        return Integer.parseInt(input);
    }

    public static void main(String[] args) {
        convertStringToInt("12345");
    }
}
