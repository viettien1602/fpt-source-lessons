public class AdjInfo implements Comparable<AdjInfo> {
    public Vertex dest;
    public double weight=1;
    public AdjInfo(Vertex dest) {
        this.dest = dest;
    }
    public AdjInfo(Vertex dest, double weight) {
        this.dest = dest;
        this.weight = weight;
    }
    @Override
    public int compareTo(AdjInfo o) {
        return dest.compareTo(o.dest);
    }
    @Override
    public String toString() {
        return "(" + dest.key + "," + weight + ")";
    }
    public double getWeight() {
        return weight;
    }
}