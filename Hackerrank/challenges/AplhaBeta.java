package Hackerrank.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AplhaBeta {
    private static int alphaBeta(List<Integer> pile) {

        Collections.sort(pile, Collections.reverseOrder());

        int lastIndex = pile.lastIndexOf(pile.get(0));
        int gold = pile.get(0);

        for (int i = 0; i <= lastIndex; i++) {
            if (pile.contains(gold)) {
                pile.remove(pile.indexOf(gold));
            }
        }
        return pile.isEmpty() ? 0 : pile.get(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextInt());
        }
        System.out.println(alphaBeta(arrayList));
    }
}
