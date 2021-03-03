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



    public void setXLoc() {
        _house.setX(Constants.HOUSE_X);
        _house.setY(Constants.HOUSE_Y);
        _grass.setY(Constants.GRASS_Y);
    }

    public void setUpTimeline() {
        KeyFrame kf = new KeyFrame(Duration.seconds(2), new TimeHandler());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private class TimeHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            _star.setXLoc(_star.getXLoc() - 100);
            _star.setYLoc(_star.getYLoc() + 80);

            if (_star.getXLoc() < 0) {
                _label.setText("Make a wish!");
            }
            else {
                _label.setText("Get Ready...");
            }

            if (_star.getXLoc() < 1) {
                _star.setXLoc(_star.getXLoc());
                _star.setYLoc(_star.getYLoc());
            }

        }
    }

    private class ClickHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent Event) {
            Platform.exit();
        }
    }



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
