package codingninjas.lecture13.hashmaps;

import java.util.HashMap;

public class MaximumFrequencyNumber {
    public static int maxFrequencyNumber(int[] arr){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int maxKey = arr[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
                if(map.get(maxKey) < map.get(arr[i])) {
                    maxKey = arr[i];
                }
            } else {
                int count = map.get(arr[i]);
                count++;
                map.put(arr[i], count);
                if(map.get(maxKey) < map.get(arr[i])) {
                    maxKey = arr[i];
                }
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        int[] array = {2, 12, 2, 11, 12, 2, 1, 2, 2, 11, 12, 2, 6};
        System.out.println(maxFrequencyNumber(array));
    }
}
