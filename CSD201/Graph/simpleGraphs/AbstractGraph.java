public abstract class AbstractGraph extends VertexList {
    public static final int MAXTYPE = 4;
    public static final int  UNDIRECTED=0;
    public static final int DIRECTED=1;
    public static final int UNDIRECTED_WEIGHTED=2;
    public static final int DIRECTED_WEIGHTED=3;
    public int graphType=0;
    public AbstractGraph() {
        super();
    }
    public AbstractGraph(int graphType) {
        super();
        if(graphType>=0&&graphType<MAXTYPE)
            this.graphType=graphType;
        else throw new RuntimeException("Invalid graph type!");
    }
    public abstract boolean loadGraph();
    public void addAdj(String srcKey, String destKey) {
        Vertex src = addVertex(srcKey);
        Vertex dest = addVertex(destKey);
        AdjInfo adj = new AdjInfo(dest,1);
        src.adjList.add(adj);
    }
    public void addAdj(String srcKey, String destKey, double weight) {
        Vertex src = addVertex(srcKey);
        Vertex dest = addVertex(destKey);
        AdjInfo adj = new AdjInfo(dest,weight);
        src.adjList.add(adj);
    }
    public AdjInfo getAdjInfo(Vertex src, Vertex dest) {
        AdjInfo adj = new AdjInfo(dest,1);
        OrderedList<AdjInfo> adjList = src.adjList;
        return adjList.search(adj);
    }
}