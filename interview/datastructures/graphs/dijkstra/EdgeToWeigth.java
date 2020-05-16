package interview.datastructures.graphs.dijkstra;

public class EdgeToWeigth<T> implements Comparable<EdgeToWeigth>{
    T vertex;
    int weight;

    public EdgeToWeigth(T vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EdgeToWeigth{" +
                "vertex='" + vertex + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(EdgeToWeigth o) {
        return this.weight - o.weight;
    }
}
