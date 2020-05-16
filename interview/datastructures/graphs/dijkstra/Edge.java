package interview.datastructures.graphs.dijkstra;

public class Edge<T> {
    T src;
    T dest;
    int weight;

    public Edge(T src, T dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "src=" + src +
                ", dest=" + dest +
                ", weight=" + weight +
                '}';
    }
}
