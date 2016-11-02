import javax.swing.JFrame;

/**
 * The Window class sets up the JFrame and draws the components
 *
 * @author      Oskar Eriksson
 * @version     1.0
 */
public class Window {
    private JFrame frame;
    private Drawing draw;
    private int width;
    private int height;
    private int zoom;

    /**
     * Constructor for the Window class
     */
    public Window() {
        width = 640;
        height = 480;
        zoom = 32;

        // Set up JFrame
        System.out.println("Setting up JFrame");
        frame = new JFrame();
        frame.setSize(width, height);
        frame.setTitle("Grapher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up drawing, send the coordinates and draw to frame
        draw = new Drawing(width, height, zoom, new Coordinates(width, zoom).getCoordinates());
        frame.add(draw);

        // When everything is done, make frame visible
        frame.setVisible(true);
    }

}

