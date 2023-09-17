import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        In a = new In(args[0]);
        boolean show = false, direction = false;
        int zoomIndex = 100000;
        String start = new String(),target = new String() ;
        double xmin = Double.POSITIVE_INFINITY,xmax = Double.NEGATIVE_INFINITY,ymin=Double.POSITIVE_INFINITY,ymax = Double.NEGATIVE_INFINITY;
        String[] testString = a.readAllStrings();
        // reading the input txt file
        HashMap<String, Node> nodeStore = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i < testString.length;i +=4 ){
            //add node
            if(testString[i].equals("i")){
                String id = testString[i + 1 ];
                double lat = Double.parseDouble(testString[i + 2]);
                double log = Double.parseDouble(testString[i + 3]);
                Node newNode = new Node(id,lat,log);
                xmax = Math.max(log,xmax);
                xmin = Math.min(log,xmin);
                ymax = Math.max(lat,ymax);
                ymin = Math.min(lat,ymin);
                nodeStore.put(id,newNode);
                //adding node
            }
            else{
                String id = testString[i + 1 ];
                Node node1 = nodeStore.get(testString[i +2 ]);
                Node node2 = nodeStore.get(testString[i + 3]);
                Edge newEdge = new Edge(node1,node2,id);
                node1.addEdge(newEdge);
                node2.addEdge(newEdge);
                // add edge
            }
        }
        for(int i = 1; i < args.length;i++){
            if(args[i].equals("--show")) show = true;
            else if(args[i].equals("--directions")){
                direction = true;
                start = args[i + 1];
                target = args[i + 2];
                i = i + 2;
            }
        }
        DijkstraNode endPoint = null;
        if(direction){
            endPoint = dijkstra(start,target,nodeStore);
            if(endPoint.getParent() == null){
                direction = false;
                // points are not connected to each other
                System.out.println("two points are not connected together");
            }
            else{
                DijkstraNode tmp = endPoint;
                ArrayList<String> strings = new ArrayList<>();
                double sum = tmp.getShortestD();
                while(tmp.getParent() != null){
                    strings.add(tmp.getId());
                    tmp = tmp.getParent();
                }
                for(int i = 0; i < strings.size(); i++){
                    System.out.println(strings.get(strings.size()-1-i));
                }
                System.out.println("the total distance is "+sum + "mile" );
            }
        }
        if(show){
            if(direction){
                new Mapping(500,500,xmax,xmin,ymax,ymin,true,endPoint,nodeStore);
            }
            else {
                new Mapping(500,500,xmax,xmin,ymax,ymin,nodeStore);
            }
        }
    }
    // the dijkstra algorithm return the target node
    public static DijkstraNode dijkstra(String startID, String targetID,HashMap<String,Node> allNode){
        String x = startID;
        HashMap<String,DijkstraNode> DisMap = new HashMap<>();
        HashMap<String,DijkstraNode> Visited = new HashMap<>();
        // adding all notes into the map
        for(String y: allNode.keySet()){
            DisMap.put(y,new DijkstraNode(allNode.get(y)));
        }
        DisMap.get(startID).setShortestD(0);
        for(String ignored : DisMap.keySet()){
            ArrayList<Edge> edges ;
            // if targetID is in the shortest path or all the node is traverse then return
            if(Visited.containsKey(targetID)||x.equals("")){
                break;
            }
            edges = DisMap.get(x).getEdgeStore();
            // traverse all the edges
            for (Edge edge : edges) {
                String near;
                if (x.equals(edge.getA().getId())) near = edge.getB().getId();
                else near = edge.getA().getId();
                // if note is not visited, then check its distance
                if (!Visited.containsKey(near)) {
                    double dist = DisMap.get(x).getShortestD() + edge.getDistance();
                    //update the distance of each node
                    if (dist < DisMap.get(near).getShortestD()) {
                        DisMap.get(near).setShortestD(dist);
                        DisMap.get(near).setParent(DisMap.get(x));
                    }
                }
            }
            Visited.put(x,DisMap.get(x));
            String cur = "";
            // get the smallest distance points in the map
            double min = Double.POSITIVE_INFINITY;
            for(String y: DisMap.keySet()){
                if(!Visited.containsKey(y) && min > DisMap.get(y).getShortestD()){
                    cur = y;
                    min = DisMap.get(y).getShortestD();
                }
            }
            x = cur;
        }
        return DisMap.get(targetID);
    }
}
