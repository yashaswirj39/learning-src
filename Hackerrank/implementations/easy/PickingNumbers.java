package Hackerrank.implementations.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PickingNumbers {
    private static int picking(List<Integer> list){
        Collections.sort(list);
        /*List<List<Integer>> listInsideList = new ArrayList<>();*/
        List<Integer> listInsideList = new ArrayList<>();
        for (int i = 0; i < list.size()-1; i++) {
            /*List<Integer> listObj = new ArrayList<>();*/
            int count = 0;
            for (int j = i+1; j < list.size(); j++) {
                if (Math.abs(list.get(i) - list.get(j))<=1){
                    /*listObj.add(list.get(j));*/
                    count++;
                } else {
                    continue;
                }
            }
            /*listObj.add(list.get(i));*/
            count = count + 1;
            listInsideList.add(count);
        }
        Collections.sort(listInsideList, Collections.reverseOrder());
        System.out.println(listInsideList.get(0));
        return listInsideList.get(0);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        picking(list);
    }
}
