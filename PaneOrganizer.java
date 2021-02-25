package cartoon;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;



public class PaneOrganizer {
    private BorderPane _root;
    private Circle _moon;

    //TODO: use this class to set up your panes, your quit button, and to create an instance of your top-level logic class!
    public PaneOrganizer() {
        _root = new BorderPane();
        _root.setStyle("-fx-background-color: #FFFFFF;");
        this.createPanes();
    }

    public BorderPane getRoot() {
        return _root;
    }

    private void createPanes() {
        Pane grassPane = new Pane();
        Pane skyPane = new Pane();
        grassPane.setPrefSize(500, 100);
        skyPane.setPrefSize(500, 400);
        grassPane.setStyle("-fx-background-color: #222b13");
        skyPane.setStyle("-fx-background-color: #000000");
        _root.setBottom(grassPane);
        _root.setTop(skyPane);
        _moon = new Circle(100, 100, 50, Color.WHITE);
        skyPane.getChildren().addAll(_moon);




    }

}
