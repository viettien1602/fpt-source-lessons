public class VertexList extends OrderedList<Vertex> {
    public VertexList() {
        super();
    }
    public Vertex search(String key) {
        Vertex v = new Vertex(key);
        return search(v);
    }
    public Vertex addVertex (String key) {
        Vertex newV = new Vertex(key);
        Vertex t = search(newV);
        if(t!=null) return t;
        this.add(newV);
        return newV;
    }
    public Vertex addVertex (String key, String name) {
        Vertex newV = new Vertex(key, name);
        Vertex t = search(newV);
        if(t!=null) return t;
        this.add(newV);
        return newV;
    }
    public void resetNum() {
        for (Object v: this) ((Vertex)v).num=0;
    }
    @Override
    public String toString() {
        String result="";
        for(Object v: this) {
            result += ((Vertex)v).toString() + "\n";
        }
        return result;
    }
    
}
