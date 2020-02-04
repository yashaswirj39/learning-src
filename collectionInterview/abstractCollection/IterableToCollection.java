package collectionInterview.abstractCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class IterableToCollection {
    public static <T> Collection<T> getCollectionFromIteralbe(Iterable<T> itr) {
        Collection<T> cltn = new ArrayList<T>();
        itr.forEach(cltn::add);
        return cltn;
    }

    public static void main(String[] args) {
        Iterable<Integer> i = Arrays.asList(1, 2, 3, 4);
        System.out.println("Iterable List : " + i);

        Collection<Integer> cn = getCollectionFromIteralbe(i);
        System.out.println("Collection List : " + cn);
    }
}
