package cartoon;

import javafx.animation.Animation;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.event.EventHandler;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * This class creates other shapes/labels/buttons that are not my main composite shape and the Eventhandlers
 * that are responsible for their function. The shapes that do not move include a rectangle called
 * _grass and a house that is made of a rectangle and a polygon. The moon element of this cartoon is
 * made of two shapes, a moon and a 'newMoon'. If you click the left arrow key, the newMoon that
 * overlaps the moon will disappear and the seemingly crescent moon will become a full moon. If you
 * click the right arrow key, the newMoon will re-appear and make the moon a crescent again.
 * This class contains an instance of the Star class, which I have already made header comments for in
 * its own class.
 * This class also creates a label that changes relative to the position of the star, which in turn
 * updates based on the timeline.
 * This class creates a quit button that quits the program, and a ClickHandler method that implements
 * EventHandler so that it is able to be clicked.
 */


public class Cartoon {
    private Circle _moon;
    private Rectangle _house;
    private Polygon _roof;
    private Circle _newMoon;
    private Star _star;
    private Label _label;
    private Rectangle _grass;

    // TODO: this is your top-level logic class! It should contain your event handlers, other "game" logic, and an instance of your composite shape!
    public Cartoon(BorderPane _root, Pane starPane, VBox labelPane, HBox buttonPane) {
        Pane cartoonPane = new Pane();
        cartoonPane.setPrefSize(500, 400);
        cartoonPane.setStyle("-fx-background-color: #000000");
        _root.setTop(cartoonPane);


        _moon = new Circle(Constants.MOON_X, Constants.MOON_Y, Constants.CIRCLE_RADIUS, Color.WHITE);
        _newMoon = new Circle(Constants.NEWMOON_X, Constants.MOON_Y, Constants.CIRCLE_RADIUS, Color.BLACK);
        _newMoon.setVisible(true);
        cartoonPane.getChildren().addAll(_moon, _newMoon);
        cartoonPane.addEventHandler(KeyEvent.KEY_PRESSED, new KeyHandler());
        cartoonPane.setFocusTraversable(true);
        _house = new Rectangle(Constants.HOUSE_SIDE, Constants.HOUSE_SIDE, Color.SADDLEBROWN);
        _roof = new Polygon();
        _roof.getPoints().addAll(new Double[]{
                400.0, 250.0,
                350.0, 300.0,
                450.0, 300.0
        });
        _roof.setFill(Color.FIREBRICK);
        _grass = new Rectangle(Constants.GRASS_WIDTH,Constants.GRASS_HEIGHT);
        _grass.setFill(Color.DARKGREEN);
        _star = new Star(starPane);
        _root.getChildren().addAll(_house, _roof, starPane, _grass);
        this.setXLoc();


        _label = new Label("Get Ready...");
        labelPane.getChildren().add(_label);
        _root.setCenter(labelPane);
        labelPane.setAlignment(Pos.CENTER);

        Button quit = new Button("Quit");
        quit.setOnAction(new ClickHandler());
        buttonPane.getChildren().add(quit);
        _root.setBottom(buttonPane);
        buttonPane.setAlignment(Pos.BOTTOM_RIGHT);

        this.setUpTimeline();

    }

    /**
     * This method sets the X and Y locations of my house shapes and the Y location of my grass shape.
     */


    public void setXLoc() {
        _house.setX(Constants.HOUSE_X);
        _house.setY(Constants.HOUSE_Y);
        _grass.setY(Constants.GRASS_Y);
    }

    /**
     * This method sets up the timeline that I use to move my star composite shape. Every keyFrame
     * is two seconds long and the animation repeats indefinitly.
     */

    public void setUpTimeline() {
        KeyFrame kf = new KeyFrame(Duration.seconds(2), new TimeHandler());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * TimeHandler is responsible for the animation segment of my cartoon, in paticular the movement of the
     * star shape and the label that responds to the movement of the star shape. The handle method uses
     * methods from the star class (setXLoc and getXLoc) to translate the shape across the screen until it
     * vanishes. In order to change the label based on the timeline updates, I used an if statement. If the
     * star leaves its original position, the label will update and change. Once the star moves a total of
     * 4 times, it is re-set to another position in the pane, and moves across the screen again. I used
     * an if statement to acomplish this.
     */

    private class TimeHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            // sets X and Y locations of the star to move in a diagonal line across the screen
            _star.setXLoc(_star.getXLoc() - 100);
            _star.setYLoc(_star.getYLoc() + 80);

            //changes label text once the star leaves its original position

            if (_star.getXLoc() < 0) {
                _label.setText("Make a wish!");
            }
            else {
                _label.setText("Get Ready...");
            }

            //If the shape is translated along the x axis 450 spaces, it will return to a set X and y location


            if (_star.getXLoc() < -450) {
                _star.setXLoc(-10);
                _star.setYLoc(50);
            }


        }
    }

    /**
     * This class makes the program quit when the quit button is clicked by implementing Eventhandler.
     */

    private class ClickHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent Event) {
            Platform.exit();
        }
    }

    /**
     * This class implements the class Eventhandler to create a class keyHandler. The handle method in this class
     * uses a switch statement and the boolean method 'setVisible' so that if the left or right
     * arrow keys are clicked, the setVisible method will be set to either true or false. Clicking Q
     * will quit the program.
     */



    private class KeyHandler implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent e) {
            KeyCode keyPressed = e.getCode();

            switch (keyPressed) {
                case LEFT:
                    _newMoon.setVisible(false);
                    break;
                case RIGHT:
                    _newMoon.setVisible(true);
                    break;
                case Q:
                    Platform.exit();
                    break;
            }
            e.consume();
        }
    }




    
}
