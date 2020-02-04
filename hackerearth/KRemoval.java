package hackerearth;

import java.util.*;

public class KRemoval {
    private static int maxlength(int[] a){

        /*int res = a.length - k;

        int[] arr = new int[res];

        for (int i = 0; i < a.length-2; i++) {
            int sum = 0;
            for (int j = i+1; j < a.length-1; j++) {
                sum = Math.abs(a[i] - a[j]) + Math.abs(a[j] - a[j+1]);
                if (sum == res){
                    arr[0] = a[i];
                    arr[1] = a[j];
                    arr[1] = a[j+1];
                }
            }
        }
        return res;*/
        Arrays.sort(a);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!hm.containsKey(a[i])){
                hm.put(a[i], 1);
            } else {
                hm.put(a[i], hm.get(a[i]) + 1);
            }
        }
        System.out.println(hm);
        int sum = 0;
        List<Integer> list = new ArrayList<>(hm.keySet());
        for (int i = 0; i < list.size() - 1; i++) {
            if (Math.abs(list.get(i) - list.get(i+1)) == 1){
                if (hm.get(list.get(i)) > hm.get(list.get(i+1))){
                    sum += hm.get(list.get(i));
                } else if(hm.get(list.get(i)) < hm.get(list.get(i+1))){
                    sum += hm.get(list.get(i+1));
                } else  if (hm.get(list.get(i)) == hm.get(list.get(i+1))){
                    sum += 1;
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        //int k = scanner.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(maxlength(a));
    }
}
