public class Edge {
    private String id;
    private Node a, b;
    private boolean drawing = false;
    private double distance;
    Edge(Node a, Node b, double distance){
        this.a  = a;
        this.b = b;
        this.distance = distance;
    }
    Edge(Node a, Node b, String id){
        this.a = a;
        this.b = b;
        this.distance = calDistance(a.getLatitude(),b.getLatitude(),a.getLongitude(),b.getLongitude());
        this.id = id;
    }
    //calDistance is copied form the website: https://www.geeksforgeeks.org/haversine-formula-to-find-distance-between-two-points-on-a-sphere/
    private double calDistance(double latitude1, double latitude2, double longitude1, double longitude2){
        double lat = Math.toRadians(latitude2 - latitude1);
        double log = Math.toRadians(longitude2 - longitude1);
        latitude1 = Math.toRadians(latitude1);
        latitude2 = Math.toRadians(latitude2);
        double a = Math.pow(Math.sin(lat / 2), 2) + Math.pow(Math.sin(log / 2), 2) * Math.cos(latitude1) * Math.cos(latitude2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c * 0.621371;
    }
    public Node getA(){return a;}
    public Node getB(){return b;}
    public double getDistance(){return distance;}

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
