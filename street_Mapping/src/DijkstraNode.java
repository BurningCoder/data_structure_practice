
public class DijkstraNode extends Node{
    private DijkstraNode parent;
    private double shortestD;
    DijkstraNode(Node x){
        super(x.getId(),x.getLatitude(),x.getLongitude(),x.getEdgeStore());
        shortestD = Double.POSITIVE_INFINITY;
        parent = null;
    }
    public DijkstraNode getParent() {
        return parent;
    }
    public double getShortestD() {
        return shortestD;
    }
    public void setParent(DijkstraNode parent) {
        this.parent = parent;
    }
    public void setShortestD(double shortestD) {
        this.shortestD = shortestD;
    }
}
