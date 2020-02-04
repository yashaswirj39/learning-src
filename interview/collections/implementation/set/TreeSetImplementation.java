package interview.collections.implementation.set;

import java.util.*;

public class TreeSetImplementation<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, java.io.Serializable {

    private transient NavigableMap<E, Object> m;

    // Dummy value to associate with an Object in the backing Map
    private static final Object PRESENT = new Object();

    /**
     * Constructs a set backed by the specified navigable map.
     */
    TreeSetImplementation(NavigableMap<E, Object> m) {
        this.m = m;
    }


    /**
     * Constructs a new, empty tree set, sorted according to the
     * natural ordering of its elements.  All elements inserted into
     * the set must implement the {@link Comparable} interface.
     */
    public TreeSetImplementation() {
        this(new TreeMap<E, Object>());
    }

    public TreeSetImplementation(Comparator<? super E> comparator) {
        this(new TreeMap<>(comparator));
    }

    public TreeSetImplementation(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    public TreeSetImplementation(SortedSet<E> s) {
        this(s.comparator());
        addAll(s);
    }

    /**
     * =============================================================================
     * constructors END                            |
     * =============================================================================
     */

    /**
     * Adding elements inside TreeMap
     * @param e
     * @return
     */
    public boolean add(E e) {
        return m.put(e, PRESENT) == null;
    }

    /**
     * removing elements from a tree map
     * @param o
     * @return
     */
    public boolean remove(Object o) {
        return m.remove(o)==PRESENT;
    }

    public void clear() {
        m.clear();
    }

    @Override
    public E lower(E e) {
        return null;
    }

    @Override
    public E floor(E e) {
        return null;
    }

    @Override
    public E ceiling(E e) {
        return null;
    }

    @Override
    public E higher(E e) {
        return null;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return this.m.keySet().iterator();
    }

    @Override
    public NavigableSet<E> descendingSet() {
        return new TreeSetImplementation<>(this.m.descendingMap());
    }

    @Override
    public Iterator<E> descendingIterator() {
        return this.m.descendingKeySet().iterator();
    }

    @Override
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        return null;
    }

    @Override
    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        return null;
    }

    @Override
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        return null;
    }

    @Override
    public Comparator<? super E> comparator() {
        return null;
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        return null;
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        return null;
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        return null;
    }

    @Override
    public E first() {
        return null;
    }

    @Override
    public E last() {
        return null;
    }

    @Override
    public int size() {
        return this.m.size();
    }
}
