package codingninjas.lecture4.recursion2.assignment;

public class ReturnAllCodeString {

    public static  String[] getCode(String input){
        char[] c = input.toCharArray();
        countDecoding(c, c.length);
        return null;
    }

    static int countDecoding(char[] digits, int n) {

        if (n == 0 || n == 1)
            return 1;
        if (digits[0] == '0') //for base condition "01123" should return 0
            return 0;


        int count = 0;


        if (digits[n - 1] > '0')
            count = countDecoding(digits, n - 1);


        if (digits[n - 2] == '1' ||
                (digits[n - 2] == '2' && digits[n - 1] < '7'))
            count += countDecoding(digits, n - 2);

        return count;
    }


    public static void main(String[] args) {
        String str = "1123";
        String[] abc = getCode(str);
    }
}
