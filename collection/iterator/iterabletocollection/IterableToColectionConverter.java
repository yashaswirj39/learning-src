package collection.iterator.iterabletocollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class IterableToColectionConverter {

    public static <T> Collections getCollectionFromIterable(Iterable<T> itr){
        Collection<T> collection = new ArrayList<>();
        for (T elem : itr){
            collection.add(elem);
        }
        return (Collections) collection;
    }
    public static void main(String[] args) {
        Iterable<Integer> itr = (Iterable) Arrays.asList(1,2,3,4);
        System.out.println("Iterable list: "+itr);

        Collection<Integer> cole = (Collection<Integer>) getCollectionFromIterable(itr);
        System.out.println(cole);
    }
}
