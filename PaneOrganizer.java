package cartoon;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.HBox;



public class PaneOrganizer {
    private BorderPane _root;


    //TODO: use this class to set up your panes, your quit button, and to create an instance of your top-level logic class!
    public PaneOrganizer() {
        _root = new BorderPane();
        _root.setStyle("-fx-background-color: #FFFFFF;");
        Pane starPane = new Pane();
        new Cartoon(_root, starPane, new VBox(), new HBox());
    }

    public BorderPane getRoot() {
        return _root;
    }



}
