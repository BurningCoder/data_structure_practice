import java.util.ArrayList;

public class Node {


    private double latitude, longitude;
    private String id;
    private ArrayList<Edge> edgeStore;
    Node(String id){
        this.id = id;
        edgeStore = new ArrayList<>();
    }
    Node(String id, double latitude, double longitude){
        edgeStore = new ArrayList<>();
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    Node(String id, double latitude, double longitude, ArrayList<Edge> edgeStore){
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.edgeStore = edgeStore;
    }
    public void addEdge(Edge x){
        edgeStore.add(x);
    }
    public double getLatitude(){
        return latitude;
    }
    public double getLongitude(){
        return longitude;
    }

    public String getId() {
        return id;
    }
    public ArrayList<Edge> getEdgeStore() {
        return edgeStore;
    }
}
