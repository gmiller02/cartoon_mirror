package cartoon;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 * This class constructs a composite shape in the shape of a star. It uses both polygons and rectangles
 * to achieve this. This class is contained in a separeate pane called starPane to allow for ease of
 * movement in the cartoon. This class also contains methods that are used in EventHandlers to move
 * the star across the screen, which are explained in more detail below.
 */


public class Star {
    private Polygon _star1;
    private Polygon _star2;
    private Rectangle _tail1;
    private Rectangle _tail2;
    private Rectangle _tail3;
    private Rectangle _tail4;

    public Star(Pane starPane) {
        _star1 = new Polygon();
        _star2 = new Polygon();

        _star1.getPoints().addAll(new Double[]{
                330.0, 100.0,
                300.0, 80.0,
                360.0, 80.0
        });

        _star2.getPoints().addAll(new Double[]{
                330.0, 70.0,
                300.0, 90.0,
                360.0, 90.0
        });

        _tail1 = new Rectangle(Constants.TAIL1_X, Constants.TAIL1_Y, Constants.V_RECTANGLE_WIDTH, Constants.V_RECTANGLE_HEIGHT);
        _tail2 = new Rectangle(Constants.TAIL2_X, Constants.TAIL2_Y, Constants.H_RECTANGLE_WIDTH, Constants.H_RECTANGLE_HEIGHT);
        _tail3 = new Rectangle(Constants.TAIL3_X, Constants.TAIL3_Y, Constants.H_RECTANGLE_WIDTH, Constants.H_RECTANGLE_HEIGHT);
        _tail4 = new Rectangle(Constants.TAIL4_X, Constants.TAIL4_Y, Constants.V_RECTANGLE_WIDTH, Constants.V_RECTANGLE_HEIGHT);

        _star1.setFill(Color.YELLOW);
        _star2.setFill(Color.YELLOW);
        _tail1.setFill(Color.WHITE);
        _tail2.setFill(Color.WHITE);
        _tail3.setFill(Color.WHITE);
        _tail4.setFill(Color.WHITE);


        starPane.getChildren().addAll(_star1, _star2, _tail1, _tail2, _tail3, _tail4);
    }

    /**
     * This method sets the X locations of the polygons and rectangles that make up Star. The polygons and rectangles
     * are set using setTranslateX because that method specifically allows them to move across the screen.
     *
     * @param x
     */


    public void setXLoc(double x) {
        _star1.setTranslateX(x);
        _star2.setTranslateX(x);
        _tail1.setTranslateX(x);
        _tail2.setTranslateX(x);
        _tail3.setTranslateX(x);
        _tail4.setTranslateX(x);

    }

    /**
     * This method does the same as the above method, but with the y placements.
     * @param y
     */

    public void setYLoc(double y) {
        _star1.setTranslateY(y);
        _star2.setTranslateY(y);
        _tail1.setTranslateY(y);
        _tail2.setTranslateY(y);
        _tail3.setTranslateY(y);
        _tail4.setTranslateY(y);
    }

    /**
     * The bottom two methods return the x and y positions of the _star1 shape. Since this polygon is in
     * the center of my entire composite shape, I called the getTranslateX and Y on that paticular shape.
     * @return
     */

    public double getXLoc() {
        return _star1.getTranslateX();
    }

    public double getYLoc() {return _star1.getTranslateY();}


    }




