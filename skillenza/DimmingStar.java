package skillenza;

import java.util.*;

public class DimmingStar {

    private static void m1(HashMap<Integer, List<Integer>> map , int key){
        System.out.println(map);
        List<List<Integer>> allList = new ArrayList<>();
        int i = 0;
        /*List<Integer> integerList = map.get(key);
        for (int j = 0; j < integerList.size(); j++) {
            List<Integer> pathCount = new ArrayList<>();
            while (map.containsKey(key)){
                pathCount.add(key);
                key = map.get(key).get(i);
            }
            pathCount.add(key);
            allList.add(pathCount);
        }*/
        int mainIndex = 0;
        List<Integer> pathCount = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            List<Integer> list = map.get(entry.getKey());
            pathCount.add(entry.getKey());
            for (int k = 0; k < list.size(); k++) {
                if (map.containsKey(list.get(i))){
                    key = list.get(i);
                    break;
                }
            }
            if (pathCount.contains(key)){
                int index = pathCount.indexOf(key);
                pathCount.remove(key);
                key = pathCount.get(index--);
            }
            mainIndex++;
        }
        System.out.println(pathCount);
        //return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //int testcase = sc.nextInt();
        int size = sc.nextInt();
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        list1.add(6);
        list1.add(2);
        list2.add(4);
        list2.add(3);
        list3.add(7);
        list4.add(1);
        hm.put(5, list1);
        hm.put(6,list2);
        hm.put(4, list3);
        hm.put(7, list4);

        int startPoint = sc.nextInt();
        m1(hm, startPoint);

            /*
            while (size > 0){
                int key = sc.nextInt();
                int value = sc.nextInt();
                if (!hm.containsKey(key)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(value);
                    hm.put(key, list);
                } else {
                    List<Integer> ls = hm.get(key);
                    ls.add(value);
                    hm.put(key, ls);
                }
                size--;
            }*/

    }
}
