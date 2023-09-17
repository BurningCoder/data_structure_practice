import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Mapping extends JFrame implements ComponentListener {
    private final boolean shortest;
    private final DijkstraNode finalEndPoint;
    private drawingCanvas canvas;
    private final HashMap<String, Node> nodeStore;
    private final double xmax, xmin, ymax,ymin;
    private double zoomIndexX, zoomIndexY;
    private final int width,height;
    // use for distramapping
    public Mapping(int w, int h,double xmax,double xmin,double ymax, double ymin, boolean shortest,DijkstraNode endPoint, HashMap<String,Node> nodeStore){
        super("map");
        this.xmax = xmax;
        this.xmin = xmin;
        this.ymax = ymax;
        this.ymin = ymin;
        this.nodeStore = nodeStore;
        this.finalEndPoint = endPoint;
        this.width = w;
        this.height = h;
        zoomIndexX = 0;
        zoomIndexY = 0;
        this.shortest = shortest;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentListener(this);
        setSize(width,height);
        setVisible(true);
    }
    //use for normal mapping
    public Mapping(int w, int h,double xmax,double xmin,double ymax, double ymin,HashMap<String,Node> nodeStore){
        super("map");
        this.xmax = xmax;
        this.xmin = xmin;
        this.ymax = ymax;
        this.ymin = ymin;
        this.nodeStore = nodeStore;
        this.finalEndPoint = null;
        this.width = w;
        this.height = h;
        zoomIndexX = 0;
        zoomIndexY = 0;
        this.shortest = false;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentListener(this);
        setSize(width,height);
        setVisible(true);
    }
    private drawingCanvas drawMap(int w, int h){
        double diffX =Math.abs(xmax - xmin), diffY = Math.abs(ymax - ymin);
        zoomIndexX = (w-20)/diffX;
        zoomIndexY = (h-20)/diffY;
        //System.out.println(zoomIndexX + " " + zoomIndexY);
        double inXmin = (xmin + 1000) * zoomIndexX, inYmax = ymax*(-1 * zoomIndexY);
        drawingCanvas x = new drawingCanvas();
        //traverse the whole hashtable to add each line into the graph
        for(String key: nodeStore.keySet()){
            Node curNode = nodeStore.get(key);
            ArrayList<Edge> edges = curNode.getEdgeStore();
            double curx = curNode.getLongitude(), cury = curNode.getLatitude();
            curx =(curx + 1000) *zoomIndexX - inXmin;
            cury = -1*zoomIndexY*cury - inYmax;
            for(Edge path: edges){
                String id;
                //getting each lines' two point
                if(path.getA().getId().equals(curNode.getId())) id = path.getB().getId();
                else id = path.getA().getId();
                Node toNode = nodeStore.get(id);
                // transform the real world latitude and longitude into jFrame coordinate
                double tox = toNode.getLongitude(), toy = toNode.getLatitude();
                tox = (tox + 1000) *zoomIndexX - inXmin;
                toy = -1*zoomIndexY*toy - inYmax;
                x.addLine(curx,cury,tox,toy,false);
            }
        }
        // drawing the shortest bth with red color
        if(shortest){
            DijkstraNode endPoint = finalEndPoint;
            while(true){
                //the same process as the upper except for the color
                double curx = endPoint.getLongitude(), cury = endPoint.getLatitude();
                endPoint = endPoint.getParent();
                if(endPoint.getParent() == null) break;
                double tox = endPoint.getLongitude(), toy = endPoint.getLatitude();
                curx =(curx + 1000) *zoomIndexX - inXmin;
                cury = -1*zoomIndexY*cury - inYmax;
                tox = (tox + 1000) *zoomIndexX - inXmin;
                toy = -1*zoomIndexY*toy - inYmax;
                x.addLine(curx,cury,tox,toy,true);
            }
        }
        return x;
    }
    @Override
    public void componentResized(ComponentEvent e) {
        //redraw the hole map when the line is changed
        getContentPane().removeAll();
        int w = getWidth();
        int h = getHeight();
        canvas = drawMap(w, h);
        add(canvas);
        revalidate();
    }
    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
