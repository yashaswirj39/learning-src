package leetcode.thirtydaychallenge.may.week1;

public class NumberComplement {
    public static String toBinary(int number) {
        return Integer.toBinaryString(number);
    }

    public static String compliment(String binary) {
        System.out.println(binary);
        String s = "";
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i)=='1') {
                s += '0';
            } else {
                s += '1';
            }
        }
        return s;
    }

    public static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    public static void main(String[] args) {
        int n = 4;
        /*String binary = toBinary(n);
        String compliment = compliment(binary);
        System.out.println(Integer.parseInt(compliment,2));*/
        System.out.println(Integer.toBinaryString(n));
    }
}
