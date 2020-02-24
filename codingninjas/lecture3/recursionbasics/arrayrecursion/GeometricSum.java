package codingninjas.lecture3.recursionbasics.arrayrecursion;

public class GeometricSum {
    private static double calculatePower(int num, int pow) {
        if (pow <= 0) {
            return 1;
        }
        return calculatePower(num, pow-1) * num;
    }

    private static double findGeometricSum(int k) {
        if (k <= 0) {
            return 1;
        }
        double pow = calculatePower(2, k);
        double gsum = findGeometricSum(k-1) + (1/pow);
        return gsum;
    }

    public static void main(String[] args) {
        //System.out.println(calculatePower(2, 1));
        System.out.println(findGeometricSum(3));
    }
}
