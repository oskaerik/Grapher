import javax.swing.JComponent;
import java.util.ArrayList;
import java.awt.geom.Point2D;
import java.awt.Graphics;
import java.awt.Color;

/**
 * The Drawing class tells the Window class which components should be drawn on the JFrame
 */
public class Drawing extends JComponent {
    private ArrayList<Point2D.Double> coordinates;
    private int width;
    private int height;
    private int zoom;

    /**
     * Constructor for the Drawing class
     * @param width Width of the JFrame
     * @param height Height of the JFrame
     * @param zoom How much the graphing tool should zoom in
     * @param input Which coordinates the liens should be drawn between
     */
    public Drawing(int width, int height, int zoom, ArrayList<Point2D.Double> input) {
        coordinates = new ArrayList<>(input);
        this.width = width;
        this.height = height;
        this.zoom = zoom;
    }

    /**
     * Draws the lines between the coordinates
     * @param g Graphics from java.awt.Graphics
     */
    public void paintComponent(Graphics g) {
        g.drawLine(0, height/2, width, height/2); // x-axis
        g.drawLine(width/2, 0, width/2, height); // y-axis
        for (int i = 0; i < coordinates.size()-1; i++ ) {
            g.setColor(Color.RED);
            // Formula for printing x: pixel = zoom*x + width/2
            // Formula for printing y: pixel = height/2 - zoom*y
            int x1 = (int)Math.round(coordinates.get(i).getX()*zoom + width/2);
            int y1 = (int)Math.round(height/2 - coordinates.get(i).getY()*zoom);
            int x2 = (int)Math.round(coordinates.get(i+1).getX()*zoom + width/2);
            int y2 = (int)Math.round(height/2 - coordinates.get(i+1).getY()*zoom);
            g.drawLine(x1, y1, x2, y2);
        }
    }
}
