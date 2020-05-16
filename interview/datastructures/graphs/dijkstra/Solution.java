package interview.datastructures.graphs.dijkstra;

import java.util.*;

/**
 * 2 1 1
 * 2 3 1
 * 3 4 1
 * =====================
 * A B 4
 * A C 3
 * B F 5
 * B E 12
 * C D 7
 * C E 10
 * D E 3
 * E Z 5
 * F Z 16
 * ======================
 * A D 100
 * A B 10
 * B C 12
 * C D 15
 */

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Edge> list = new ArrayList<>();

        String terminatedChar = "";

        /**
         * Creating the graph using list.
         */
        while (!terminatedChar.equalsIgnoreCase("-1")) {
            System.out.println("Enter source node:");
            String src = scanner.next();
            System.out.println("Enter destination node:");
            String dest = scanner.next();
            System.out.println("Enter weight of edge between src " + src + " and destination " + dest);
            int weight = scanner.nextInt();
            list.add(new Edge(src, dest, weight));
            System.out.println("Press any key to continue, If you want to terminate. Press -1");
            terminatedChar = scanner.next();
        }

        /**
         * Graph stored inside list with source, destination, weight
         */
        System.out.println(list);

        Dijkstra dijkstra = new DijkstraImpl();

        /**
         * getting source node data from user
         */
        System.out.println("Enter source node data:");
        String srcNodeData = scanner.next();
        Edge<String> src = new Edge(srcNodeData, "", 0);

        /**
         * getting destination node data from user
         */
        System.out.println("Enter destination node data:");
        String destNodeData = scanner.next();
        Edge<String> dest = new Edge("", destNodeData, 0);

        //path map currently empty
        LinkedHashMap<String, String> path = new LinkedHashMap<>();

        //visited list currently empty
        LinkedList<EdgeToWeigth> visited = new LinkedList<>();

        /**
         * calling bfs traversal to find the shortest path from source to destination
         */
        path = dijkstra.dijstraBfsTraversal(list, path, visited, src, dest);

        //printin the path map
        System.out.println(path);

        /**
         * printing the path fetched from path map
         */
        LinkedList<String> key = new LinkedList<>(path.keySet());
        String pathKey = key.get(key.size() - 1);
        StringBuilder sb = new StringBuilder();
        sb.append(key.get(key.size() - 1));
        for (int i = key.size() - 1; i >= 0 ; i--) {
            if (path.containsKey(pathKey)) {
                pathKey = path.get(pathKey);
                sb.append(pathKey);
            }
        }
        sb.reverse();
        String str = sb.toString();
        if(!str.contains(dest.dest)) {
            str += dest.dest;
            System.out.println(str);
        } else {
            System.out.println(str);
        }
    }
}
