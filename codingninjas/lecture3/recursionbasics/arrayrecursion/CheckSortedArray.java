package codingninjas.lecture3.recursionbasics.arrayrecursion;

public class CheckSortedArray {
    /*public static boolean checkSorted(int[] array) {
        if (array.length <= 1) {
            return true;
        }
        int[] smallInput = new int[array.length - 1];
        for (int i = 1; i <array.length ; i++) {
            smallInput[i-1] = array[i];
        }
        boolean small = checkSorted(smallInput);
        if (!small) {
            return false;
        }
        if (array[0] <= array[1]){
            return true;
        } else {
            return false;
        }
    }*/

    /**
     * more optimized code
     * @param
     * @return
     */
    /*public static boolean checkSorted(int[] array) {
        if (array.length <= 1) {
            return true;
        }
        if (array[0] > array[1]) {
            return false;
        }
        int[] smallInput = new int[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            smallInput[i - 1] = array[i];
        }
        boolean small = checkSorted(smallInput);
        if (small){
            return true;
        } else
            return false;
     }*/

    public static boolean checkBetterSorted(int[] array, int startIndex) {
        if (startIndex >= array.length - 1) {
            return true;
        }

        if (array[startIndex] > array[startIndex + 1]) {
            return false;
        }

        boolean smallAns = checkBetterSorted(array, startIndex+1);
        return smallAns;
    }

    public static void main(String[] args) {
        //int[] input = {2,1,3,6,9};
        int[] input = {1,2,3,6,9};
        System.out.println(checkBetterSorted(input, 0));
    }
}