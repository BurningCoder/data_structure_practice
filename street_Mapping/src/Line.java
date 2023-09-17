import java.awt.*;
import java.awt.geom.Line2D;

public class Line {
    public boolean x = false;
    public final double x1;
    public final double x2;
    public final double y1;
    public final double y2;
    public Line(double x1, double y1, double x2, double y2,boolean x) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.x = x;
    }
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Line2D line2D = new Line2D.Double(x1,y1,x2,y2);
        if(x) g2d.setColor(Color.red);
        g2d.draw(line2D);
    }
}