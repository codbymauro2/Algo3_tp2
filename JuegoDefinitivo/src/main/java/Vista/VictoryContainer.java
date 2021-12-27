package Vista;

import Modelo.MainObjects.Game;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.border.Border;
import java.io.FileNotFoundException;
import java.io.IOException;

public class VictoryContainer extends BorderPane {

    private final Game game;
    private final Stage stage;

    public VictoryContainer(Game game, Stage stage) throws IOException {
        this.game = game;
        this.stage = stage;
        this.game.updatePlayers();
        this.setStyle("-fx-background-image: url('/images/victory.jpg')");
    }

}
