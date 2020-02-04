package Hackerrank.Arrays.medium;

import java.util.*;

public class NewYearChaos {
    private static void minimumBribes(int[] oldArray) {
        Map<Integer, Integer> oldMap = new HashMap<>();
        Map<Integer, Integer> newMap = new HashMap<>();
        int[] newArray = Arrays.copyOf(oldArray, oldArray.length);
        Arrays.sort(newArray);
        for (int i = 0; i < oldArray.length; i++) {
            oldMap.put(oldArray[i], i);
            newMap.put(newArray[i], i);
        }
        int sum = 0;
        boolean chaotic = false;
        for (int i = 0; i < newMap.size(); i++) {
            if (oldArray[i] == newArray[i]){
                continue;
            } else {
                int oldArrayIndex = oldMap.get(oldArray[i]);
                int newArrayIndex = newMap.get(oldArray[i]);
                int diff = Math.abs(newArrayIndex - oldArrayIndex);
                if (diff > 2){
                    chaotic = true;
                    break;
                } else {
                    if (diff == 1 && newArrayIndex > oldArrayIndex){
                        int temp = newArray[newArrayIndex];
                        newMap.put(newArray[newArrayIndex], newArrayIndex);
                        newArray[newArrayIndex] = newArray[newArrayIndex - 1];
                        newArray[newArrayIndex - 1] = temp;
                        newMap.put(newArray[newArrayIndex - 1], newArrayIndex - 1);
                        sum++;
                    } else if (diff == 1 && oldArrayIndex > newArrayIndex){
                        int temp = newArray[newArrayIndex + 1];
                        int index = newMap.get(oldArray[i]);
                        newArray[newArrayIndex + 1] = newArray[index];
                        newMap.put(newArray[newArrayIndex + 1], newArrayIndex + 1);
                        newArray[index] = temp;
                        newMap.put(newArray[index], index);
                        sum++;
                    } else if (diff == 2){
                        int count = diff;
                        while (count > 0){
                            int temp = newArray[newArrayIndex];
                            newArray[newArrayIndex] = newArray[newArrayIndex - 1];
                            newMap.put(newArray[newArrayIndex], newArrayIndex);
                            newArray[newArrayIndex - 1] = temp;
                            newMap.put(newArray[newArrayIndex - 1], newArrayIndex - 1);
                            count--;
                            newArrayIndex--;
                            sum++;
                        }
                    }
                }
            }
        }
        if (chaotic) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        int sizeOfArray = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            int[] array = new int[sizeOfArray];
            for (int j = 0; j < sizeOfArray; j++) {
                array[j] = sc.nextInt();
            }
            minimumBribes(array);
        }
    }
}