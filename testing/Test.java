package testing;

public class Test {
    public static void leftShift(int arr[]){
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num <<= 1;
            System.out.println("left shift ----> " + num);
            num += arr[i];
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        //int[] array = {1,0,1};
        int[] array = {1,0,0,1,0,0,1,1,1,0,0,0,0,0,0};
        leftShift(array);
    }
}
