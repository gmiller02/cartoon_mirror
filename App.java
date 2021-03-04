package cartoon;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Here's cartoon! Your first JavaFX assignment!
 * Before you start coding your cartoon, take a look at
 * the lecture slides and JavaFX Guide for all the
 * information you'll need (and more!).
 *
 * My cartoon preforms the following functions:
 * Moon changes from a crescent to a full moon when left arrow key pressed.
 * Moon changes from a full moon to a crescent when right arrow key pressed.
 * If the 'quit' button is pressed, the program will quit.
 * If the 'q' button is pressed, the program will quit.
 * The star travels across the screen until it has traveled a horizontal distance of 450. Then, it is re-set to a place
 * close to its original location.
 * Once the timeline updates and the shape starts moving, the label changes to 'make a wish!'
 *
 */

public class App extends Application {

    @Override
    public void start(Stage stage) {
        PaneOrganizer organizer = new PaneOrganizer();
        stage.setScene(new Scene(organizer.getRoot(),500, 500));
        stage.setTitle("Stage");
        stage.show();
        // Create top-level object, set up the scene, and show the stage here.
    }

    /*
    * Here is the mainline! No need to change this.
    */
    public static void main(String[] argv) {
        // launch is a method inherited from Application
        launch(argv);
    }
}
