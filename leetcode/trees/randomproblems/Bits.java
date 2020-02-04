package leetcode.trees.randomproblems;

import java.util.Iterator;
import java.util.TreeSet;

public class Bits {
    public static void main(String[] args) {
        int x = 4;
        int y = 1;
        System.out.println(String.format("%4s", Integer.toBinaryString(x)).replace(' ', '0'));
        System.out.println(String.format("%4s", Integer.toBinaryString(y)).replace(' ', '0'));
        System.out.println(Integer.bitCount(x ^ y));

        TreeSet map = new TreeSet();
        map.add("one");
        map.add("two");
        map.add("three");
        map.add("one");
        Iterator it = map.iterator();
        while (it.hasNext()){
            System.out.println(it.next() + "");
        }

        final long MICROS_PER_DAY = 24*60*60*1000*1000;
        final long MILIS_PER_DAY = 24*60*60*1000;
        System.out.println(MICROS_PER_DAY/MILIS_PER_DAY);
    }
}
