package codingninjas.lecture18.graph1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

    public static ArrayList<Integer> getPathHelper(int edges[][], int sv, boolean visited[]) {
        return null;
    }

    public static void printDfsHelper(int edges[][], int sv, boolean visited[]) {
        System.out.println(sv);
        visited[sv] = true;
        int n = edges.length;
        for (int i = 0; i < n; i++) {
            if (edges[sv][i] == 1 && !visited[i]) {
                printDfsHelper(edges, i, visited);
            }
        }
    }

    public static void dfs(int edges[][]) {
        boolean visited[] = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                printDfsHelper(edges, i, visited);
            }
        }
        for (int i = 0; i < visited.length; i++) {
            System.out.print(visited[i] + " ");
        }
    }

    public static void printBFSHelper(int edges[][], int sv, boolean visited[]) {
        Queue<Integer> queue = new LinkedList<>();
        int n = edges.length;
        queue.add(sv);
        visited[sv] = true;
        while (!queue.isEmpty()) {
            int front = queue.poll();
            System.out.println(front);
            for (int i = 0; i < n; i++) {
                if (edges[front][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void BFS(int edge[][]) {
        boolean visited[] = new boolean[edge.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                printBFSHelper(edge, i, visited);
            }
        }
        for (int i = 0; i < visited.length; i++) {
            System.out.print(visited[i] + " ");
        }
    }

    public static void main(String[] args) {
        int v;
        int e;
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        int edges[][] = new int[v][v];

        for (int i = 0; i < e; i++) {
            int fv = sc.nextInt();
            int sv = sc.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }
        //print(edges);

        System.out.println("Graph Data:");
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length; j++) {
                System.out.print(edges[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=====================");
        BFS(edges);
    }
}
