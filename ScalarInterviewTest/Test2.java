package ScalarInterviewTest;

import java.math.BigDecimal;

public class Test2 {
    static int division() {
        int count = 0;
        for (int i = 1; i <=500 ; i++) {
            if (i % 6 == 0 || i % 10 == 0 || i % 12 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(division());
    }
}
