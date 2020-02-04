package ScalarInterviewTest.sundayTest;

import java.math.BigInteger;

public class QuesTwelve {
    public static void main(String[] args) {
        //int num = 1000000;
        BigInteger val = BigInteger.valueOf(1);
        for (int i = 1000000; i > 0 ; i--) {
            val = val.multiply(BigInteger.valueOf(i));
            System.out.println(val);
        }
        System.out.println(val);
    }
}
