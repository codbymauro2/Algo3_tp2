package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.ContinueButtonEventHandler;
import javafx.scene.layout.BorderPane;
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

        Button continueButton = new Button();
        ContinueButtonEventHandler continueButtonEventHandler = new ContinueButtonEventHandler(stage);
        continueButton.setOnAction(continueButtonEventHandler);
        this.getChildren().addAll(continueButton);

        this.setStyle("-fx-background-image: url('/images/victory.jpg')");
    }

}
