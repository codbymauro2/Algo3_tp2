package Vista.Eventos;

import Modelo.MainObjects.Game;
import Vista.PlayerNameContainer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlayButtonEventHandler implements EventHandler<ActionEvent> {

    private Game game;
    Stage stage;


    public PlayButtonEventHandler(Stage stage, Game game) {
        this.game = game;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        PlayerNameContainer playerNameContainer = new PlayerNameContainer(game,stage);
        Scene playerScene = new Scene(playerNameContainer, 1180, 660);
        playerScene.getStylesheets().add(getClass().getResource("/stylesheets/welcomeScene.css").toExternalForm());
        stage.setScene(playerScene);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(false);
    }
}
