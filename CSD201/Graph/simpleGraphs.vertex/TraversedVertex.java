public class TraversedVertex implements Comparable<TraversedVertex> {
    public Vertex v;
    public int num;
    public TraversedVertex(Vertex v, int num) {
        this.v = v;
        this.num = num;
    }
    @Override
    public String toString() {
        return "("+v.key+","+v.num+")";
    }
    @Override
    public int compareTo(TraversedVertex o) {
        return num < o.num ? -1: num > o.num? 1: 0;
    }
    
}
