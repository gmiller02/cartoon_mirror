package cartoon;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;



public class PaneOrganizer {
    private BorderPane _root;


    //TODO: use this class to set up your panes, your quit button, and to create an instance of your top-level logic class!
    public PaneOrganizer() {
        _root = new BorderPane();
        _root.setStyle("-fx-background-color: #FFFFFF;");
        Pane skyPane = new Pane();
        skyPane.setPrefSize(500, 400);
        skyPane.setStyle("-fx-background-color: #000000");
        _root.setTop(skyPane);
        new Cartoon(_root);
        this.createPanes();
    }

    public BorderPane getRoot() {
        return _root;
    }

    public void createPanes() {
        Pane grassPane = new Pane();
        grassPane.setPrefSize(500, 100);
        grassPane.setStyle("-fx-background-color: #222b13");
        _root.setBottom(grassPane);

    }

}
