package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.EnterNameEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.*;

public class PlayerNameContainer extends BorderPane {
    ApplicationMenuBar menuBar;
    Game game;
    VBox centralContainer;
    Stage stage;

    public PlayerNameContainer(Game game, Stage stage)  {
        this.stage = stage;
        this.game = game;
        this.setMenu();
        this.setCentro();
    }

    private void setCentro()  {
        // CONTENEDOR PANTALLA/BOTONES
        VBox vRightContainer = new VBox(0);
        vRightContainer.getStyleClass().add("right-side-box");

        // PANTALLA DERECHA DE JUEGO
        VBox screen = new VBox(0);
        screen.getStyleClass().add("right-screen");

        // BOTONERA
        ButtonBar buttonBar = new ButtonBar(20);
        buttonBar.getStyleClass().add("button-box");
        buttonBar.setDisable();

        vRightContainer.getChildren().addAll(screen, buttonBar);

        // ESPACIO PARA CIUDAD ACTUAL Y TIEMPO RESTANTE
        VBox timeVbox = new VBox();
        timeVbox.getStyleClass().add("time-box");

        Label textTime = new Label(game.time());
        Label textSpace = new Label(game.getCityName());
        textTime.getStyleClass().add("time-label");
        textSpace.getStyleClass().add("city-label");

        timeVbox.getChildren().addAll(textSpace, textTime);

        // INGRESO DE NOMBRE
        VBox nameBox = new VBox(5);
        nameBox.getStyleClass().add("name-box");

        Label name = new Label("IDENTIFY YOURSELF: ");
        name.getStyleClass().add("name-label");

        TextField enterName = new TextField();
        enterName.getStyleClass().add("welcome-label");
        enterName.setBackground(Background.EMPTY);
        enterName.setPadding(new Insets(0, 50, 0, 50));
        nameBox.setPrefSize(500, 500);
        nameBox.setPadding(new Insets(100, 0, 0, 0));
        nameBox.setStyle("-fx-background-image: url('images/paper.png');" +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: 450 575;" +
                "-fx-background-position: center center;");

        Label labelName = new Label();
        labelName.getStyleClass().add("welcome-label");
        labelName.setBackground(Background.EMPTY);
        labelName.setPadding(new Insets(0, 50, 0, 50));
        labelName.setAlignment(Pos.TOP_CENTER);
        labelName.setFont(Font.font ("Verdana", 11));

        nameBox.getChildren().addAll(name, enterName, labelName);

        EnterNameView enterNameView = new EnterNameView(nameBox, game);
        EnterNameEventHandler enterNameEventHandler = new EnterNameEventHandler(game, stage, enterNameView);
        enterName.setOnAction(enterNameEventHandler);

        // PANTALLA IZQUIERDA
        VBox left = new VBox(5);
        left.setPrefSize(426, 570);
        left.getChildren().addAll(timeVbox, nameBox);

        // PANTALLA DERECHA
        VBox right = new VBox(5);
        right.setPrefSize(713, 570);
        right.getChildren().addAll(vRightContainer);

        // PANTALLA COMPLETA
        HBox fullScreen = new HBox(20);
        fullScreen.getChildren().addAll(left, right);

        centralContainer = new VBox(fullScreen);
        centralContainer.getStyleClass().add("central-container");

        this.setCenter(centralContainer);
    }

    private void setMenu() {
        this.menuBar = new ApplicationMenuBar(stage);
        this.setTop(menuBar);
    }
}
