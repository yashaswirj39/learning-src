package java8;

import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.util.stream.IntStream;

public class StreamsApi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a[] = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        /***
         * The below line will check whether the min number is present or not.
         * if present it will print else not
         */

        IntStream.of(a).min().ifPresent(System.out::println);

        /***
         * Instead of calling IntStream.of(a).<anyfunction> everytime,
         * IntStream.of(a) returns object of IntSummaryStatistics, which can be used to caluculate
         * max, min, count, sum, avg.
         */

        IntSummaryStatistics statistics = IntStream.of(a).summaryStatistics();

        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());

        /***
         * Finding 3 distinct smallest number from an array of int with stream api.
         * Stream API = Create + Process + Consume
         * Below line is printing the first 3 distinct smallest number.
         */

        IntStream.of(a).distinct().sorted().limit(3).forEach(System.out::println);

        /***
         * Below line is printing the sum of first 3 distinct smallest number.
         */
        System.out.println(IntStream.of(a).distinct().sorted().limit(3).sum());
    }
}
