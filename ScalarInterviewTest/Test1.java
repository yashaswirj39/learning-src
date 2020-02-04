package ScalarInterviewTest;

public class Test1 {
    static long thousandTerm() {
        long sum = 0;
        for (int i = 0; i < 1000; i++) {
            if (i == 0) {
                sum = 3;
            } else {
                sum += 4;
            }
            System.out.println(i  + " -----> " + sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(thousandTerm());
    }
}
