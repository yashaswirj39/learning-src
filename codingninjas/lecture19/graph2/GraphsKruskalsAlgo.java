package codingninjas.lecture19.graph2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 6 11
 * 1 3 1
 * 0 1 2
 * 0 3 3
 * 0 2 4
 * 4 5 5
 * 2 3 6
 * 3 5 7
 * 2 1 8
 * 2 4 9
 * 2 5 10
 * 3 4 11
 */

public class GraphsKruskalsAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int E = sc.nextInt();

        Edge[] input = new Edge[E];
        for (int i = 0; i < E; i++) {
            input[i] = new Edge();
            input[i].source = sc.nextInt();
            input[i].destination = sc.nextInt();
            input[i].weight = sc.nextInt();
        }

        kruskals(input, n);
    }

    private static void kruskals(Edge[] input, int n) {

        //custom sort based on weight using comparator.
        Arrays.sort(input);

        //output array
        Edge[] output = new Edge[n - 1];

        //Maintaing parent of every vertex
        int[] parent = new int[n];

        //intializing the parent vertex
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int count = 0;

        int i = 0;

        while (count != n - 1) {

            //get current edge from input array
            Edge currentEdge = input[i];

            //find source of the current edge
            int sourceParent = findParent(currentEdge.source, parent);

            //find destination of the current edge
            int destinationParent = findParent(currentEdge.destination, parent);

            //if parent are not same adding into output array
            if (sourceParent != destinationParent) {
                output[count] = currentEdge;
                count++;

                //marking parent for current edge vertex
                parent[sourceParent] = destinationParent;
            }
            i++;
        }

        //printing the output
        for (int j = 0; j < n - 1; j++) {
            if (output[j].source < output[j].destination)
                System.out.println(output[j].source + " " + output[j].destination + " " + output[j].weight);
            else
                System.out.println(output[j].destination + " " + output[j].source + " " + output[j].weight);
        }
    }

    private static int findParent(int vertex, int[] parent) {
        if (parent[vertex] == vertex) {
            return vertex;
        }
        return findParent(parent[vertex], parent);
    }
}
