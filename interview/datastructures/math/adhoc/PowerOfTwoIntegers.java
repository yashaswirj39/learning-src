package interview.datastructures.math.adhoc;

import java.util.Scanner;

public class PowerOfTwoIntegers {

    private static int isPower(int a) {
        if(a==1) return 1;
        if(a==2) return 0;
        for (int i = 2; i*i <= a; i++) {
            int p = a;
            while(p%i == 0){
                p/=i;
            }
            if(p == 1) return 1;
        }
        return 0;
    }

    //536870912
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(isPower(n));
        //System.out.println(String.valueOf(Math.sqrt(n)));
    }
}
