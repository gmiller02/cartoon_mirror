package cartoon;

import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;

public class Cartoon {
    private Circle _moon;
    private Rectangle _house;
    private Polygon _roof;
    // TODO: this is your top-level logic class! It should contain your event handlers, other "game" logic, and an instance of your composite shape!
    public Cartoon(BorderPane _root) {
        _moon = new Circle(100, 100, 50, Color.WHITE);
        _root.getChildren().addAll(_moon);
        _house = new Rectangle(100, 100, Color.SADDLEBROWN);
        _roof = new Polygon();
        _roof.getPoints().addAll(new Double[]{
                400.0, 250.0,
                350.0, 300.0,
                450.0, 300.0
        });
        _roof.setFill(Color.FIREBRICK);
        _root.getChildren().addAll(_house, _roof);
        this.setXLoc();

    }

    public void setXLoc() {
        _house.setX(350);
        _house.setY(300);
    }

    public double getXLoc() {
        return _house.getX();
    }




    
}
