package collectionInterview.abstractCollection;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * The AbstractCollection class will not allow to override add method and other concrete method
 * That is why it is called as unmodifiable collection.
 * @param <E>
 */
public class AbstractCollectionImpl<E> extends AbstractCollection {
    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean removeIf(Predicate filter) {
        return false;
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public Stream stream() {
        return null;
    }

    @Override
    public Stream parallelStream() {
        return null;
    }
    public static void main(String[] args)
    {
        // Create an empty collection
        AbstractCollection<Object>
                abs = new ArrayList<Object>();

        // Use add() method to add
        // elements in the collection
        abs.add("Welcome");
        abs.add("To");
        abs.add("Geeks");
        abs.add("4");
        abs.add("Geeks");

        // Displaying the Collection
        System.out.println("AbstractCollection: "
                + abs);
    }
}
