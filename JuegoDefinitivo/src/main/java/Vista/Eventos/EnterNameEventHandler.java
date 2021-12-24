package Vista.Eventos;

import Modelo.MainObjects.Game;
import Vista.EnterNameView;
import Vista.PrincipalContainer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
;


public class EnterNameEventHandler implements EventHandler<ActionEvent> {

    private final EnterNameView enterNameView;
    private Stage stage;
    private Scene nextScene;
    private Game game;

    public EnterNameEventHandler(Game game, Stage stage, EnterNameView enterNameView) {
        this.game = game;
        this.stage = stage;
        this.enterNameView = enterNameView;
    }

    @Override
    public void handle(ActionEvent event) {
        game.setPlayer( ((TextField) event.getSource()).getText() );
        game.initializeCase();
        enterNameView.update();
        PrincipalContainer principalContainer = new PrincipalContainer(stage, game);
        Scene gameScene = new Scene(principalContainer, 1180, 660);
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.millis(7000), event1 ->  stage.setScene(gameScene))
        );
        timeline.play();
    }

}
