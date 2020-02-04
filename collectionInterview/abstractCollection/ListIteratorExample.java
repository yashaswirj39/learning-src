package collectionInterview.abstractCollection;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorExample {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            al.add(i);
        }
        System.out.println(al);

        ListIterator<Integer> listItr = al.listIterator();
        /**
         * Example for forward iteration
         */
        while (listItr.hasNext()) {
            System.out.println(listItr.next());
            if (listItr.next() % 2 != 0) {
                listItr.remove();
            }
            // it will throw IllegalStateException, because after this remove(), next() needs to be called
            //listItr.set(13);

            listItr.add(14);
        }
        System.out.println();
        System.out.println(al);

        /**
         * Example for backward iteration
         */
        System.out.println("backward iteration:");
        while (listItr.hasPrevious()) {
            System.out.println(listItr.previous());
            if (listItr.previous() % 2 != 0) {
                listItr.remove();
            }
            // it will throw IllegalStateException, because after this remove(), next() needs to be called
            //listItr.set(13);

            listItr.add(14);
        }
        System.out.println();
        System.out.println(al);
    }
}
