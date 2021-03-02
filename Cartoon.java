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

    // TODO: this is your top-level logic class! It should contain your event handlers, other "game" logic, and an instance of your composite shape!
    public Cartoon(BorderPane _root, Pane starPane, VBox labelPane, HBox buttonPane) {
        Pane skyPane = new Pane();
        skyPane.setPrefSize(500, 400);
        skyPane.setStyle("-fx-background-color: #000000");
        _root.setTop(skyPane);


        _moon = new Circle(100, 100, 50, Color.WHITE);
        _newMoon = new Circle(120, 100, 50, Color.BLACK);
        _newMoon.setVisible(true);
        skyPane.getChildren().addAll(_moon, _newMoon);
        skyPane.addEventHandler(KeyEvent.KEY_PRESSED, new KeyHandler());
        skyPane.setFocusTraversable(true);
        _house = new Rectangle(100, 100, Color.SADDLEBROWN);
        _roof = new Polygon();
        _roof.getPoints().addAll(new Double[]{
                400.0, 250.0,
                350.0, 300.0,
                450.0, 300.0
        });
        _roof.setFill(Color.FIREBRICK);
        _star = new Star(starPane);
        _root.getChildren().addAll(_house, _roof, starPane);
        this.setXLoc();

        new VBox();
        _label = new Label("Star Label");
        labelPane.getChildren().add(_label);
        _root.setBottom(labelPane);
        labelPane.setAlignment(Pos.CENTER);

        new HBox();
        Button quit = new Button("Quit");
        quit.setOnAction(new ClickHandler());
        buttonPane.getChildren().add(quit);

    }



    public void setXLoc() {
        _house.setX(350);
        _house.setY(300);
    }

    public void setUpTimeline() {
        KeyFrame kf = new KeyFrame(Duration.seconds(3), new TimeHandler());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private class TimeHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            _star.setXLoc(_star.getXLoc() - 10);

            if (_star.getXLoc() == 250) {
                _label.setText("Make a wish!");
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
