package cartoon;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.HBox;

/**
 * This class sets up the panes that make up my Cartoon. These panes include a BorderPane, which
 * allows children to be positioned on the screen in an optional layout format. Another pane included is
 * starPane, which contains the moving composite shape. This pane is seperate from the others to allow
 * it optional movement. This class instantiates a VBox, which contains a label, and an HBox, which
 * contains my quit button, so that these elements can be positioned properly.
 *
 */



public class PaneOrganizer {
    private BorderPane _root;


    //TODO: use this class to set up your panes, your quit button, and to create an instance of your top-level logic class!
    public PaneOrganizer() {
        _root = new BorderPane();
        _root.setStyle("-fx-background-color: #FFFFFF;");
        Pane starPane = new Pane();
        new Cartoon(_root, starPane, new VBox(), new HBox());
    }

    /**
     * This method returns my Borderpane _root so that I am able to access _root from other classes.
     * @return
     */

    public BorderPane getRoot() {
        return _root;
    }



}
