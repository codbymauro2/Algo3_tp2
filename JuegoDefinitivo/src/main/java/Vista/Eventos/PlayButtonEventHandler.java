package Vista.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlayButtonEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene nextScene;

    public PlayButtonEventHandler(Stage stage, Scene nextScene) {
        this.stage = stage;
        this.nextScene = nextScene;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(nextScene);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(false);
    }
}
