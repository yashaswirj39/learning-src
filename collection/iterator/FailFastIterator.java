package collection.iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * To know whether the collection is structurally modified or not,
 * fail-fast iterators use an internal flag called modCount which is
 * updated each time a collection is modified.Fail-fast iterators checks
 * the modCount flag whenever it gets the next value (i.e. using next() method),
 * and if it finds that the modCount has been modified after this iterator has been created,
 * it throws ConcurrentModificationException.
 */
public class FailFastIterator {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("A","B");
        map.put("C","D");
        map.put("E","F");
        map.put("i","j");

        Iterator<String> itr = map.keySet().iterator();

        while (itr.hasNext()){
            System.out.println(itr.next());
            map.put("k","l");
        }


        /**
         * Important points of fail-fast iterators :
         *
         * These iterators throw ConcurrentModificationException if a collection is modified
         * while iterating over it.
         *
         * They use original collection to traverse over the elements of the collection.
         * These iterators don’t require extra memory.
         * Ex : Iterators returned by ArrayList, Vector, HashMap.
         */

        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);

        Iterator<Integer> itr1 = al.iterator();
        while (itr.hasNext()) {
            if (itr1.next() == 2) {
                // will not throw Exception
                itr.remove();
            }
        }

        System.out.println(al);

        itr1 = al.iterator();
        while (itr.hasNext()) {
            if (itr1.next() == 3) {
                // will throw Exception on
                // next call of next() method
                al.remove(3);
            }
        }
    }
}