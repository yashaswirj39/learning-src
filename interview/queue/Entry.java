package interview.queue;

public class Entry implements Comparable<Entry>{

    String key;
    int element;

    public Entry() {
    }

    public Entry(String key, int element) {
        this.element = element;
        this.key = key;
    }

    @Override
    public int compareTo(Entry o) {
        return this.element - o.element; // This will store the data in ascending order;
        //return o.element - this.element; //This will store the data in reverse order
    }
}
