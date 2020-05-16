package interview.datastructures.graphs.dijkstra;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public interface Dijkstra {
    public LinkedHashMap<String, String> dijstraBfsTraversal(List<Edge> list, LinkedHashMap<String, String> path,
                                                    LinkedList<EdgeToWeigth> visited,
                                                    Edge<String> srcNode, Edge<String> destNode);
}
