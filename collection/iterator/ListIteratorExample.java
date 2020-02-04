package collection.iterator;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorExample {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            al.add(i);
        }
        System.out.println(al);

        ListIterator<Integer> lit = al.listIterator();

        while (lit.hasNext()){
            int i = lit.next();

            if (i%2==0){
                i++;
                lit.set(i);
                lit.add(i);
            }
        }
        System.out.println(al);

        while (lit.hasPrevious()){
            System.out.println(lit.previous());
        }
    }
}