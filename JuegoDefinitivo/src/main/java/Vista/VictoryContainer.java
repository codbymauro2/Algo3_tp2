package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.ContinueButtonEventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;

public class VictoryContainer extends BorderPane {

    private final Game game;
    private final Stage stage;

    public VictoryContainer(Game game, Stage stage) throws IOException {
        this.game = game;
        this.stage = stage;
        this.game.updatePlayers();
        this.getStyleClass().add("end-screen");

        VBox screen = new VBox();
        screen.getStyleClass().add("end-screen");

        Label label = new Label("Good work" + game.getRank() + " ! The thief has been arrested and the stolen item has been returned. Are you ready for your next case?");
        Button continueButton = new Button();
        continueButton.getStyleClass().add("end-button");
        ContinueButtonEventHandler continueButtonEventHandler = new ContinueButtonEventHandler(stage);
        continueButton.setOnAction(continueButtonEventHandler);

        screen.getChildren().addAll(continueButton, label);
        this.getChildren().addAll(screen);

        //this.setStyle("-fx-background-image: url('/images/victory.jpg')");
    }

}
