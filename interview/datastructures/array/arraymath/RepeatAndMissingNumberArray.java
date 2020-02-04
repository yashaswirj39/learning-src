package interview.datastructures.array.arraymath;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepeatAndMissingNumberArray {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    // Sum of array and sum of n elements will not match. Use this to
    // get A - B. Then use the sum of square of elements to get (A+B)*(A-B)
    // Solve to get A and B
    public static ArrayList<Integer> repeatedNumber(List<Integer> A) {
        long sum = 0, sqSum = 0;
        for (int i = 0; i < A.size(); i++) {
            // Sum of array
            sum += (long) A.get(i);
            // Sum of squares of elements of array
            // It is essential to typecast here as A.get(i)*A.get(i) will
            // overflow as it is an int
            sqSum = sqSum + ((long) A.get(i) * (long) A.get(i));
        }
        // Needs to be long for calculations to not overflow
        long n = A.size();
        // Sum of n digits
        long acSum = (n * (n + 1)) / 2;
        // Sum of squares of n digits
        long acSqSum = (n * (n + 1) * (2 * n + 1)) / 6;
        // A - B
        long diff = sum - acSum;
        // Gives A + B
        long sqDiff = (sqSum - acSqSum) / diff;
        ArrayList<Integer> res = new ArrayList<Integer>();
        // Repeating number
        int rep = (int) ((diff + sqDiff) / 2);
        res.add(Math.abs(rep));
        // Missing number
        res.add(Math.abs((int) (rep - diff)));
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            array.add(sc.nextInt());
        }
        repeatedNumber(array);
    }
}
