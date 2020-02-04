package interview.datastructures.array.arraybucketing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HotelBookingsPossible {
    private static boolean booking(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        System.out.println(arrive);
        System.out.println(depart);
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            al1.add(scanner.nextInt());
        }
        for (int i = 0; i < m; i++) {
            al2.add(scanner.nextInt());
        }
        int o = scanner.nextInt();
        booking(al1,al2,o);
    }
}
