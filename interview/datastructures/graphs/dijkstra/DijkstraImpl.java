package interview.datastructures.graphs.dijkstra;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraImpl implements Dijkstra{

    /**
     * Shortest path Dijkstra algorithm using BFS traversal.
     * @param list
     * @param path
     * @param visited
     * @param srcNode
     * @param destNode
     * @return
     */
    @Override
    public LinkedHashMap<String, String> dijstraBfsTraversal(List<Edge> list, LinkedHashMap<String, String> path,
                                             LinkedList<EdgeToWeigth> visited,
                                             Edge<String> srcNode, Edge<String> destNode) {

        /**
         * PQ queue is instantitated and source node is added in the queue.
         */
        PriorityQueue<EdgeToWeigth> queue = new PriorityQueue<>();
        queue.add(new EdgeToWeigth(srcNode.src, 0));

        /**
         * The loop will run till queue is not empty
         */
        while (!queue.isEmpty()) {
            EdgeToWeigth<String> edge = queue.poll();
            visited.add(edge);

            if (edge.vertex.equalsIgnoreCase(destNode.dest))
                break;

            enqueue(list, edge, queue, visited, path);
        }
        return path;
    }

    /**
     * Enqueueing unvisited node into the PQ queue
     * @param list
     * @param edge
     * @param queue
     * @param visited
     * @param path
     * @return
     */
    private PriorityQueue<EdgeToWeigth> enqueue(List<Edge> list, EdgeToWeigth edge,
                                                PriorityQueue<EdgeToWeigth> queue,
                                                LinkedList<EdgeToWeigth> visited,
                                                LinkedHashMap<String, String> path) {
        for (Edge<String> e : list) {
            if(e.src.equalsIgnoreCase(String.valueOf(edge.vertex)) && !visited.equals(new EdgeToWeigth(e.dest, e.weight))) {
                int srcToDestWeight = edge.weight + e.weight;
                queue.add(new EdgeToWeigth(e.dest, srcToDestWeight));
                path.put(e.dest, e.src);
            }
        }
        return queue;
    }
}