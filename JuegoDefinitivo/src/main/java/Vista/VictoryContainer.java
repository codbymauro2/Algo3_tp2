package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.ContinueButtonEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VictoryContainer extends VBox {

    Stage stage;

    public VictoryContainer(Game game, Stage stage) {
        super();
        this.getStylesheets().add(getClass().getResource("/stylesheets/gameScene.css").toExternalForm());
        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(60);
        this.setPadding(new Insets(100));
        Image image = new Image("/images/end.png");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(backgroundImage));

        VBox screen = new VBox();

        Label label = new Label("Good work " + game.getRank() + "! The thief has been arrested and the stolen item has been returned. Are you ready for your next case?");
        label.getStyleClass().add("end-label");

        Button continueButton = new Button();
        continueButton.setText("Continue");
        continueButton.setMinSize(75,25);

        ContinueButtonEventHandler continueButtonEventHandler = new ContinueButtonEventHandler(stage);
        continueButton.setOnAction(continueButtonEventHandler);
        continueButton.getStyleClass().add("end-button");

        this.getChildren().addAll(label, continueButton);
    }

}

