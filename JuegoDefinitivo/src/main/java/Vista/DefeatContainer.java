package Vista;

import Modelo.MainObjects.Game;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DefeatContainer extends BorderPane {

    private final Game game;
    private final Stage stage;

    public DefeatContainer(Game game, Stage stage)  {
        this.game = game;
        this.stage = stage;
        this.setStyle("-fx-background-image: url('/images/CarmenMap.jpg')");
    }

}
