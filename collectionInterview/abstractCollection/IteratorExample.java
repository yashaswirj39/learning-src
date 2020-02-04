package collectionInterview.abstractCollection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Iterator is a universal iterator.
 * It can be used with all the collection object.
 * It can work with List, Set, Queue, and implemented classes of Map interface.
 * Iterator object can be created using iterator() method.
 * it has 3 methods:
 * hasNext()
 * next()
 * remove()
 *
 * remove() method can throw unsupported Exception and illegalState Exception
 *
 * Limitations of Iterator :
 *
 * Only forward direction iterating is possible.
 * Replacement and addition of new element is not supported by Iterator.
 *
 */
public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            al.add(i);
        }
        System.out.println(al);

        Iterator<Integer> itr = al.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
            if (itr.next()%2 != 0) {
                itr.remove();
            }
        }
        System.out.println();
        System.out.println(al);
    }
}
