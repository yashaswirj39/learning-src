package collectionInterview.abstractCollection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;


/**
 * Important Common Points
 *
 * 1 : Please note that initially any iterator reference will point to the index just before the index of
 * first element in a collection.
 *
 * 2 : We don’t create objects of Enumeration, Iterator, ListIterator because they are interfaces.
 * We use methods like elements(), iterator(), listIterator() to create objects.
 * These methods have anonymous Inner classes that extends respective interfaces and return this class object.
 * This can be verified by below code. For more on inner class refer
 */
public class ImportantNotes {
    public static void main(String[] args) {
        Vector v = new Vector();

        // Create three iterators
        Enumeration e = v.elements();
        Iterator itr = v.iterator();
        ListIterator ltr = v.listIterator();

        // Print class names of iterators
        System.out.println(e.getClass().getName());
        System.out.println(itr.getClass().getName());
        System.out.println(ltr.getClass().getName());
    }
}
