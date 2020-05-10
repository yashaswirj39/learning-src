package leetcode.pickone;

import java.util.Scanner;

/**
 * https://leetcode.com/problems/masking-personal-information/
 */

public class MaskingPersonalInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(maskPhoneNumber(s));
    }

    private static String maskEmail(String email) {
        email = email.toLowerCase();
        String[] splitString = email.split("@");
        String first = splitString[0];
        first = first.substring(0, 1) + "*****" + first.substring(first.length() - 1);
        first += "@" + splitString[1];
        System.out.println(first);
        return first;
    }

    private static String maskPhoneNumber(String phone) {

        int count = 0;
        int fc = 0;
        int digitCount = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = phone.length() - 1; i >= 0; i--) {
            if (Character.isDigit(phone.charAt(i)) && count < 4 && fc == 0) {
                sb.append(phone.charAt(i));
                digitCount++;
                count++;
                if (count == 4) {
                    count = 0;
                    fc++;
                    sb.append("-");
                }
            } else if (Character.isDigit(phone.charAt(i)) && count < 3 && fc >= 1) {
                sb.append("*");
                count++;
                digitCount++;
                if (count == 3) {
                    count = 0;
                    fc++;
                    if (i > 0) {
                        sb.append("-");
                    }
                }
            }
        }
        sb.append("+");
        sb = sb.reverse();
        if (digitCount == 13) {
            String str = "+";
            str += sb.substring(2);
            return str;
        } else if (digitCount == 10){
            return sb.toString().substring(1);
        } else {
            return sb.toString();
        }
    }
}