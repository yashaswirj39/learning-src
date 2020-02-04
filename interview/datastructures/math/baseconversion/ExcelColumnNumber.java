package interview.datastructures.math.baseconversion;
import java.util.Scanner;

public class ExcelColumnNumber {

    private static int titleToNumber(String A) {
        if (A.length() == 1) return (A.charAt(0) - 'A' + 1);
        int sum = 0;
        if (A.length() > 1) {
            for (int i = 0; i < A.length(); i++) {
                double po = Math.pow(26, A.length()-i-1);
                System.out.println("po ------> " + po);
                System.out.println("char ----> " + (A.charAt(i) - 'A' + 1));
                sum += ((A.charAt(i) - 'A' + 1) * (Math.pow(26, A.length()-i-1)));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();

        System.out.println(titleToNumber(A));
    }
}
