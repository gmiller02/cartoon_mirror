package cartoon;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.layout.Pane;

public class Star {
    private Polygon _star1;
    private Polygon _star2;

    public Star(Pane starPane) {
        _star1 = new Polygon();
        _star2 = new Polygon();
        _star1.setFill(Color.YELLOW);
        _star2.setFill(Color.YELLOW);
        starPane.getChildren().addAll(_star1, _star2);
        this.setXLoc();
    }

    public void setXLoc() {
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
    }

}
