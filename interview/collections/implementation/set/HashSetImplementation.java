package interview.collections.implementation.set;

import java.util.*;

/**
 * This is java 7 implementation of HashSet
 * splitIterator is not defined
 * @param <E>
 */

public class HashSetImplementation<E> extends AbstractSet<E> implements Set<E>, Cloneable, java.io.Serializable {

    private transient HashMap<E, Object> map;
    private static final Object PRESENT = new Object();

    public HashSetImplementation() {
        map = new HashMap<>();
    }

    public HashSetImplementation(Collection<? extends E> c) {
        map = new HashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));
        addAll(c);
    }

    public HashSetImplementation(int initialCapacity, float loadFactor) {
        map = new HashMap<>(initialCapacity, loadFactor);
    }

    public HashSetImplementation(int initialCapacity) {
        map = new HashMap<>(initialCapacity);
    }

    HashSetImplementation(int initialCapacity, float loadFactor, boolean dummy) {
        map = new LinkedHashMap<>(initialCapacity, loadFactor);
    }

    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c)
            if (add(e))
                modified = true;
        return modified;
    }

    @Override
    public Iterator<E> iterator() {
        return this.map.keySet().iterator();
    }

    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }

    public void clear() {
        map.clear();
    }

    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public int size() {
        return map.size();
    }

    public static void main(String[] args) {
        HashSetImplementation<String> set = new HashSetImplementation<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("E");
        set.add("F");
        set.add("G");
        set.add("H");

        if (set.contains("B"))
            System.out.println("B is Present");
        else
            System.out.println("B is not present");

        if (set.isEmpty())
            System.out.println("set is empty");
        else
            System.out.println("set is not empty");

        if (set.size() > 0)
            System.out.println(set.size());
        else
            System.out.println("set is empty");

        if (set.remove("C"))
            System.out.println("C is removed");
        else
            System.out.println("C is not present");

        set.clear();
        System.out.println(set.toString());
        System.out.println(set.toString());
    }

    public String toString() {
        if (this.map.isEmpty()) {
            return "[]";
        }

        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (Map.Entry<E, Object> entry: this.map.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(",");
        }
        sb.append("]");
        return sb.toString().replaceAll(" ,]", "]");
    }
}
