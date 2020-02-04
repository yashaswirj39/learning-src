package collection.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This is a universal iterator
 * it can be used with all collection type
 */
public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            al.add(i);
        }
        System.out.println(al);

        Iterator<Integer> i = al.iterator();
        while (i.hasNext()){
            int elem = i.next();
            System.out.println(elem);
            if (elem%2!=0){
                i.remove();
            }
        }
        System.out.println(al);
    }
}
