package codingninjas.lecture19.graph2;

public class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;

    public Edge() {
    }

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
