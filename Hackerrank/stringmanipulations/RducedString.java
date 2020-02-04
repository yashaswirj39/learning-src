package Hackerrank.stringmanipulations;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RducedString {

    static String superReducedString(String s) {
        List<String> list = Stream.of(s.split("")).collect(Collectors.toList());
        System.out.println(s.charAt(0));
        boolean flag = true;
        while (flag){
            flag = false;
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j).equalsIgnoreCase(list.get(j+1))){
                    list.remove(j);
                    list.remove(j);
                    flag = true;
                }
            }
            //System.out.println(list.size());
            if (!flag)
                break;
        }
        return !(list.toString().replaceAll("\\[", "")
                .replaceAll("\\]","")
                .replaceAll("[, ]", "").isEmpty()) ?
                list.toString().replaceAll("\\[", "")
                        .replaceAll("\\]","")
                        .replaceAll("[, ]", "") : "Empty String";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(superReducedString(sc.next()));
    }
}
