package interview.datastructures.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * Test Case: 1
 * 6
 * 7
 * 0 1
 * 0 2
 * 1 3
 * 2 3
 * 4 5
 * 1 2
 *
 * Test Case: 2
 * 5
 * 7
 * 0 1
 * 0 2
 * 1 3
 * 1 2
 * 2 3
 */
public class GraphBFS {

    public static void graphBFSTraversal(int[][] edges, int i, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            int polledData = queue.poll();
            System.out.println(polledData);
            for (int j = 0; j < edges.length; j++) {
                if (edges[polledData][j] == 1 && !visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
    }

    public static void printBFSGraphTraversal(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                graphBFSTraversal(edges, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] graph = new int[V][V];

        for (int i = 0; i < graph.length; i++) {
            int fv = sc.nextInt();
            int sv = sc.nextInt();

            graph[fv][sv] = 1;
            graph[sv][fv] = 1;
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Traversing in BFS manner");
        printBFSGraphTraversal(graph);
    }
}