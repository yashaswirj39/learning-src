package interview.datastructures.graph;

import java.util.Scanner;

public class GraphDFS {

    public static void graphDFSTraversal(int[][] edges, int sv, boolean[] visited) {
        System.out.println(sv);
        visited[sv] = true;
        for (int j = 0; j < edges.length; j++) {
            if (edges[sv][j] == 1 && !visited[j]) {
                graphDFSTraversal(edges, j, visited);
            }
        }
    }

    public static void printDFSGraphTraversal(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                graphDFSTraversal(edges, i, visited);
            }
        }

        for (int i = 0; i < visited.length; i++) {
            System.out.println(i);
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
        printDFSGraphTraversal(graph);
    }
}