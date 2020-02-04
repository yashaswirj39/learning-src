package collectionInterview.abstractCollection;

import java.util.Vector;
import java.util.Enumeration;

/**
 * Enumeration is the first iterator present in java in 1.0
 * Other iterator was added in java 1.2 and above.
 * It has only 2 methods
 * 1. hasMoreElements()
 * 2. nextElement()
 *
 * Limitations of Enumeration :
 *
 * Enumeration is for legacy classes(Vector, Hashtable) only. Hence it is not a universal iterator.
 * Remove operations can’t be performed using Enumeration.
 * Only forward direction iterating is possible.
 */
public class EnumerationExample {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        for (int i = 0; i < 10; i++) {
            v.addElement(i);
        }
        System.out.println(v);

        Enumeration e = v.elements();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
    }
}
