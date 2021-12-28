package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.CreditsOptionEventHandler;
import Vista.Eventos.ExitOptionEventHandler;
import Vista.Eventos.PlayButtonEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class WelcomeContainer extends VBox {

    Stage stage;

    public WelcomeContainer(Stage stage, Game game) {
        super();
        this.stage = stage;
        this.getStyleClass().add("image");

        Button enterButton = new Button();
        enterButton.setText("Jugar");
        enterButton.setMinSize(75,25);

        Button creditsButton = new Button();
        creditsButton.setText("Creditos");
        creditsButton.setMinSize(75,25);

        Button exitButton = new Button();
        exitButton.setText("Salir");
        exitButton.setMinSize(75,25);

        PlayButtonEventHandler playButtonHandler = new PlayButtonEventHandler(stage, game);
        enterButton.setOnAction(playButtonHandler);

        ExitOptionEventHandler exitOptionHandler = new ExitOptionEventHandler();
        exitButton.setOnAction(exitOptionHandler);

      CreditsOptionEventHandler creditOptionEventHandler = new CreditsOptionEventHandler(stage);
      creditsButton.setOnAction(creditOptionEventHandler);

        this.getChildren().addAll(enterButton,creditsButton,exitButton);
    }

}
