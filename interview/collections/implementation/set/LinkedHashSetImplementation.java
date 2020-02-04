package interview.collections.implementation.set;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;


/**
 * This is java 7 implementation of LinkedHashSet
 * splitIterator is not defined
 * @param <E>
 */
public class LinkedHashSetImplementation<E> extends HashSetImplementation<E> implements Set<E>, Cloneable, java.io.Serializable {

    public LinkedHashSetImplementation() {
        super(16, .75f, true);
    }

    public LinkedHashSetImplementation(int initialCapacity) {
        super(initialCapacity, .75f, true);
    }

    public LinkedHashSetImplementation(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor, true);
    }

    public LinkedHashSetImplementation(Collection<? extends E> c) {
        super(Math.max(2*c.size(), 11), .75f, true);
        addAll(c);
    }

    public static void main(String[] args) {
        LinkedHashSetImplementation<String> lset = new LinkedHashSetImplementation<>();
        lset.add("A");
        lset.add("B");
        lset.add("C");
        lset.add("D");
        lset.add("E");
        lset.add("F");
        lset.add("G");
        lset.add("H");
        System.out.println(lset);
    }

    public String toString() {
        return super.toString();
    }
}