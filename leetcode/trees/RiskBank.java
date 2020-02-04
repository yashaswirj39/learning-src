package leetcode.trees;

public class RiskBank {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        int[] arr = {1, 2, 3, 7, 5};

        int actualSum = 12;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            if (sum > actualSum || sum == actualSum) {
                break;
            } else {
                sum = sum + arr[i];
            }
        }

        if (sum > actualSum){
            for (int i = 0; i < arr.length; i++) {
                if (sum > actualSum){
                    sum = sum - arr[i];
                } else if (sum == actualSum){
                    break;
                }
            }
        }
    }
}
