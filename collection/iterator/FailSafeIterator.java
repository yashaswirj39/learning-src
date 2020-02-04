package collection.iterator;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeIterator {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list =
                new CopyOnWriteArrayList<>(new Integer[] {1,2,3,4});

        Iterator itr = list.iterator();

        while (itr.hasNext()){
            Integer no = (Integer) itr.next();
            System.out.println(no);
            if (no == 4){
                list.add(14);
            }
        }
        System.out.println(list);

        /**
         * java program of fail safe iterator
         * which doesnot create a seperate copy
         */

        // Creating a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map
                = new ConcurrentHashMap<String, Integer>();

        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THREE", 3);
        map.put("FOUR", 4);

        // Getting an Iterator from map
        Iterator it = map.keySet().iterator();

        while (it.hasNext()) {
            String key = (String)it.next();
            System.out.println(key + " : " + map.get(key));

            // This will reflect in iterator.
            // Hence, it has not created separate copy
            map.put("SEVEN", 7);
        }
    }
}
