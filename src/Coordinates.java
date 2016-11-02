import java.util.ArrayList;
import java.awt.geom.Point2D;

/**
 * The Coordinates class calculates which coordinates should be graphed
 */
public class Coordinates {
    private ArrayList<Point2D.Double> coordinateList;

    /**
     * Constructor for the Coordinates class
     * @param width Width of the JFrame needed to calculate the x-axis boundary
     * @param zoom Which zoom should be used
     */
    public Coordinates(int width, int zoom) {
        coordinateList = new ArrayList<>();

        // Calculate y-values for all x-values in the boundary
        for (double x = -width/(2*zoom); x <= width/(2*zoom); x += 0.1) {
            // The equation that should be used
            double y = Math.pow(x, 3) + 3*Math.pow(x, 2);
            coordinateList.add(new Point2D.Double(x, y));
        }
    }

    /**
     * getCoordinates returns a list of coordinates to be drawn
     * @return List of coordinates
     */
    public ArrayList<Point2D.Double> getCoordinates() {
        return coordinateList;
    }
}
