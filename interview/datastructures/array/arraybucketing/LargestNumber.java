package interview.datastructures.array.arraybucketing;

import java.util.*;

public class LargestNumber {
    public static String largestNumber(final List<Integer> A) {
        List<String> strs = new ArrayList<String>();
        for(Integer i : A){
            strs.add(String.valueOf(i));
        }

        Collections.sort(strs, new MyCompartor());
        System.out.println(A);

        StringBuffer strBuf = new StringBuffer();
        for(String s : strs){
            if("0".equals(s) && strBuf.length() != 0) {
                continue;
            }
            strBuf.append(s);
        }

        return strBuf.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }
        System.out.println(largestNumber(al));
    }
}
class MyCompartor implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        String first = s1 + s2;
        String second = s2 + s1;
        return second.compareTo(first);
    }
}