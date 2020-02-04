package interview.datastructures.array.arraymath;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ArrayManipulation {
    public static long arrayManipulation(int sizeOfArray, int[][] queries) {

        int result[][] = new int[sizeOfArray][sizeOfArray];
        int counter = 0;
        int max = 0;

        for (int i = 0; i < queries.length; i++) {
            counter++;
            for (int j = 0; j < result.length; j++) {
                if (counter == 1) {
                    if (j >= queries[i][0] - 1 && j <= queries[i][1] - 1) {
                        result[i][j] = queries[i][queries[i].length - 1];
                        if (result[i][j] >= max) max = result[i][j];
                    } else {
                        result[i][j] = 0;
                        if (result[i][j] >= max) max = result[i][j];
                    }
                } else {
                    if (j >= queries[i][0] - 1 && j <= queries[i][1] - 1) {
                        result[i][j] = queries[i][queries[i].length - 1] + result[i - 1][j];
                        if (result[i][j] >= max) max = result[i][j];
                    } else {
                        result[i][j] = result[i - 1][j];
                        if (result[i][j] >= max) max = result[i][j];
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        /*Scanner sc = new Scanner(System.in);
        int sizeOfArray = sc.nextInt();
        int queriesSize = sc.nextInt();
        int queries[][] = new int[queriesSize][queriesSize];

        for (int i = 0; i < queriesSize; i++) {
            for (int j = 0; j < queriesSize; j++) {
                queries[i][j] = sc.nextInt();
            }
        }*/

        try (BufferedReader br = Files.newBufferedReader(Paths.get("/home/yashaswi/Desktop/InputOut.txt"))) {
            String line;
            int count = 0;
            int queries[][] = null;
            int sizeOfArray = 0;
            int queriesSize = 0;
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (count == 0) {
                    sizeOfArray = Integer.parseInt(line.split(" ")[0]);
                    queriesSize = Integer.parseInt(line.split(" ")[1]);
                    queries = new int[queriesSize][queriesSize];
                    count++;
                } else {
                    String inp[] = line.split(" ");
                    for (int j = 0; j < inp.length; j++) {
                        queries[i][j] = Integer.parseInt(inp[j]);
                        System.out.print(queries[i][j] + " " +  " ---> " + i);
                    }
                }
                System.out.println();
                i++;
            }
        }
        //System.out.println(arrayManipulation(sizeOfArray, queries));
    }
}