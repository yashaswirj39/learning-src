package Hackerrank;

import java.util.*;

public class CountTriplets {

    private static int triplets(int tripletarr[], int mul){

        //ArrayList<String> list = new ArrayList<>(Arrays.asList(Arrays.stream(tripletarr).mapToObj(String::valueOf).toArray(String[]::new)));
        //System.out.println(list.contains("2"));

        for (int i = 0; i < tripletarr.length-2; i++) {
            for (int j = 1; j < tripletarr.length; j++) {
                    
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arrsize = sc.nextInt();
        int multiple = sc.nextInt();

        int arr[] = new int[arrsize];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int res = triplets(arr, multiple);
    }
}
