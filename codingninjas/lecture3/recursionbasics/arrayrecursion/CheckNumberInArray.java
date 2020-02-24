package codingninjas.lecture3.recursionbasics.arrayrecursion;

public class CheckNumberInArray {
    public static boolean check(int[] array, int x) {
        if (array.length <= 1 && array[0] == x) {
            return true;
        }

        if (array[0] == x) {
            return true;
        }

        int small[] = new int[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            small[i-1] = array[i];
            if (small[i -1] == x){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {67, 2, 3, 4, 5};
        int num = 3;
        System.out.println(check(input, num));
    }
}
