package leetcode.pickone;

import java.util.Scanner;

public class LinkedListMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListUtility llu = new LinkedListUtility();
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            llu.add(sc.nextInt());
        }
        System.out.println(llu);
        System.out.println("mid point");
        System.out.println(llu.mid(llu.head).val);
        System.out.println("isPallindrome");
        System.out.println(PallindromeLinkedList.isPallindrome(llu.head));
    }
}
