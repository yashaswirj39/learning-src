package leetcode.trees.randomproblems;


import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    static List<String> list = new ArrayList<>();
    private static List<String> fizBuz(int n){
        int i = 1;
        while (i <= n){
            if (i % 3 == 0){
                list.add('"'+"Fizz"+'"');
            } else if (i % 5 == 0){
                list.add('"'+"Buzz"+'"');
            } else if ((i % 3 == 0) && (i % 5 == 0)){
                list.add('"'+"FizzBuzz"+'"');
            } else {
                list.add('"'+String.valueOf(i)+'"');
            }
            i++;
        }
        return list;
    }
    public static void main(String[] args) {
        int n = 15;
        System.out.println(fizBuz(n));
    }
}
