package cartoon;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

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

        _tail1 = new Rectangle(326.5, 40, 6, 25);
        _tail2 = new Rectangle(365, 83, 25, 6);
        _tail3 = new Rectangle(270, 83, 25, 6);
        _tail4 = new Rectangle(326.5, 105, 6, 25);

        _star1.setFill(Color.YELLOW);
        _star2.setFill(Color.YELLOW);
        _tail1.setFill(Color.WHITE);
        _tail2.setFill(Color.WHITE);
        _tail3.setFill(Color.WHITE);
        _tail4.setFill(Color.WHITE);


        starPane.getChildren().addAll(_star1, _star2, _tail1, _tail2, _tail3, _tail4);
    }


    public void setXLoc(double x) {
        _star1.setTranslateX(x - 10);
        _tail1.setX(x + 10);


    }

    public double getXLoc() {
        return _star1.getTranslateX();
    }



}
