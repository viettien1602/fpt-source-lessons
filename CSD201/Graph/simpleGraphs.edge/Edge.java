public class Edge {
    Vertex src;
    Vertex dest;
    double weight = 1;
    public Edge(Vertex src, Vertex dest) {
        this.src = src; this.dest = dest;
    }
    public Edge(Vertex src, Vertex dest, double weight) {
        this.src = src; this.dest = dest;
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "("+src.key + "," +dest.key+","+ weight + ")";
    }
    public Vertex getSrc() {
        return src;
    }
    public void setSrc(Vertex src) {
        this.src = src;
    }
    public Vertex getDest() {
        return dest;
    }
    public void setDest(Vertex dest) {
        this.dest = dest;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
}