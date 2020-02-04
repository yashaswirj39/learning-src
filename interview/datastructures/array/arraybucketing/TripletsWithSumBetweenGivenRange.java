package interview.datastructures.array.arraybucketing;

import java.util.ArrayList;

import java.util.Scanner;

public class TripletsWithSumBetweenGivenRange {
    private static int solve(ArrayList<String> A) {
        float max1A, max2A, max3A, min1A, min2A, min1B, min2B, min1C;
        max1A = max2A = max3A = Integer.MIN_VALUE;
        min1A = min2A = min1B = min2B = min1C = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            float val = Float.parseFloat(A.get(i));
            if (val <= 0.666) {
                if (val > max1A) {
                    max3A = max2A;
                    max2A = max1A;
                    max1A = val;
                }
                else if (val > max2A) {
                    max3A = max2A;
                    max2A = val;
                }
                else if (val > max3A) {
                    max3A = val;
                }
                if (val < min1A) {
                    min2A = min1A;
                    min1A = val;
                }
                else if (val < min2A) {
                    min2A = val;
                }
            }
            else if (val <= 1) {
                if (val < min1B) {
                    min2B = min1B;
                    min1B = val;
                }
                else if (val < min2B) {
                    min2B = val;
                }
            }
            else if (val < 2) {
                if (val < min1C) {
                    min1C = val;
                }
            }
        }
        /*System.out.println(max1A);
        System.out.println(max2A);
        System.out.println(max3A);
        System.out.println(min1A);
        System.out.println(min2A);
        System.out.println(min1B);
        System.out.println(min2B);
        System.out.println(min1C);*/
        float sumAAA = max1A + max2A + max3A;
        float sumAAB = max1A + max2A + min1B;
        float sumAAC = min1A + min2A + min1C;
        float sumABB = min1A + min1B + min2B;
        float sumABC = min1A + min1B + min1C;
        if ((sumAAA < 2.0 && sumAAA > 1.0) || (sumAAB < 2.0 && sumAAB > 1.0) || (sumAAC < 2.0 && sumAAC > 1.0)) {
            return 1;
        }
        if ((sumABB < 2.0 && sumABB > 1.0) || (sumABC < 2.0 && sumABC > 1.0)) {
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> al = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            al.add(sc.next());
        }
        System.out.println(solve(al));
    }
}
