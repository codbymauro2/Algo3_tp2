package Vista;

import Modelo.MainObjects.Game;
import javafx.animation.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.sql.Time;

public class EnterNameView {

    private final VBox nameBox;
    private final Game game;


    public EnterNameView(VBox nameBox, Game game) {
        this.nameBox = nameBox;
        this.game = game;
    }

    public void update() {
        nameBox.getChildren().remove(0);
        nameBox.getChildren().remove(0);

        Label name = (Label) nameBox.getChildren().get(0);

        String string = "Welcome " + game.getPlayerName() + " " + game.getRank() + " " + "The trasure "
                + "has been identified " + game.getStolenItemName() + " ." + game.getThiefGender() +
                " suspect reported" + "from " + game.getCityName();

        int delay = 500;
        char c;

        Timeline timeline =  new Timeline();

        for (char aux: string.toCharArray ()) {
            System.out.println(delay);
            timeline.getKeyFrames().add( new KeyFrame(Duration.millis(delay), event -> name.setText(name.getText() + aux)));
            delay += 50;
        }

        timeline.play();


//        Timeline timeline = new Timeline(
////                new KeyFrame(Duration.millis(500), event -> ((TextField) nameBox.getChildren().get(0)).setText("Welcome ")),
////                new KeyFrame(Duration.millis(1000), event -> ((TextField) nameBox.getChildren().get(0)).appendText(game.getPlayerName() + " ")),
////                new KeyFrame(Duration.millis(1500), event -> ((TextField) nameBox.getChildren().get(0)).appendText(game.getRank() + " ")),
////                new KeyFrame(Duration.millis(2000), event -> ((TextField) nameBox.getChildren().get(1)).appendText("The treasure ")),
////                new KeyFrame(Duration.millis(2500), event -> ((TextField) nameBox.getChildren().get(1)).appendText("has been identified ")),
////                new KeyFrame(Duration.millis(3000), event -> ((TextField) nameBox.getChildren().get(1)).appendText(game.getStolenItemName())),
////                new KeyFrame(Duration.millis(3500), event -> ((TextField) nameBox.getChildren().get(2)).appendText(game.getThiefGender() + " suspect reported ")),
////                new KeyFrame(Duration.millis(4000), event -> ((TextField) nameBox.getChildren().get(2)).appendText("from " + game.getCityName()))
////                  new KeyFrame(Duration.millis(500), event -> name.setText("Welcome ") ),
////                new KeyFrame(Duration.millis(1000), event -> name.setText( name.getText() + game.getPlayerName() + " ") ),
////                new KeyFrame(Duration.millis(1500), event -> name.setText( name.getText() + game.getRank() + " ") ),
////                new KeyFrame(Duration.millis(2000), event -> name.setText( name.getText() + "The treasure ") ),
////                new KeyFrame(Duration.millis(2500), event -> name.setText( name.getText() + "has been identified ") ),
////                new KeyFrame(Duration.millis(3000), event -> name.setText( name.getText() + game.getStolenItemName()) ),
////                new KeyFrame(Duration.millis(3500), event -> name.setText( name.getText() + game.getThiefGender()) ),
////                new KeyFrame(Duration.millis(4000), event -> name.setText( name.getText() + " suspect reported " ) ),
////                new KeyFrame(Duration.millis(4500), event -> name.setText( name.getText() + "from " + game.getCityName() ) )
////                new KeyFrame(Duration.millis(3000), event -> name.setText( name.getText() + game.getStolenItemName()) ),
////                new KeyFrame(Duration.millis(3000), event -> name.setText( name.getText() + game.getStolenItemName()) ),
////                new KeyFrame(Duration.millis(3000), event -> name.setText( name.getText() + game.getStolenItemName()) ),
//
//        );
//        timeline.play();
    }
}
