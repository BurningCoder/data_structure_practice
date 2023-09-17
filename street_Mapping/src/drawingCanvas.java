import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class drawingCanvas extends JComponent {
    private boolean x = false;
    private final ArrayList<Line> lines = new ArrayList<Line>();
    public void setColor(boolean x){
        this.x = x;
    }
    //adding the lines
    public void addLine(double x1, double y1, double x2, double y2,boolean x) {
        if(x){
            this.lines.add(new Line(x1, y1, x2, y2,true));
        }
        else{
            this.lines.add(new Line(x1,y1,x2,y2,false));
        }


    }
    // drawing the line
    public void paintComponent(Graphics g) {
        for(final Line r : lines) {
            r.paint(g);
        }
    }
}
