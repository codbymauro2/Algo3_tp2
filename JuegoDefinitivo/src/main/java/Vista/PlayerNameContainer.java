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

public class PlayerNameContainer extends BorderPane {

    ApplicationMenuBar menuBar;
    Scene nextScene;
    Game game;
    VBox centralContainer;
    Stage stage;

    public PlayerNameContainer(Game game, Stage stage) throws InterruptedException {
        this.stage = stage;
        this.game = game;
        this.setMenu();
        this.setCentro();
    }

    private void setCentro() throws InterruptedException {

        // CONTENEDOR PANTALLA/BOTONES
        VBox vRightContainer = new VBox(0);

        // PANTALLA DERECHA DE JUEGO
        VBox screen = new VBox(0);
        screen.setPrefSize(813, 682);
        screen.setBackground(new Background(new BackgroundFill(Paint.valueOf("black"), CornerRadii.EMPTY, Insets.EMPTY)));
        screen.setBorder(new Border(new BorderStroke(Paint.valueOf("white"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));

        // BOTONERA
        ButtonBar buttonBar = new ButtonBar(20);
        buttonBar.setDisable();

        vRightContainer.getChildren().addAll(screen, buttonBar);

        // ESPACIO PARA CIUDAD ACTUAL Y TIEMPO RESTANTE
        VBox timeVbox = new VBox();
        timeVbox.setAlignment(Pos.CENTER);
        timeVbox.setPrefSize(420, 80);
        timeVbox.setBackground(new Background(new BackgroundFill(Paint.valueOf("black"), CornerRadii.EMPTY, Insets.EMPTY)));
        timeVbox.setBorder(new Border(new BorderStroke(Paint.valueOf("white"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        Label textTime = new Label(game.time());
        Label textSpace = new Label(game.getCityName());
        textSpace.setTextFill(Color.web("#BDB629", 0.9));
        textTime.setTextFill(Color.web("#fcfcfc", 0.9));
        textSpace.setAlignment(Pos.TOP_CENTER);
        textTime.setAlignment(Pos.TOP_CENTER);
        textSpace.setFont(Font.font("Verdana", 20));
        textTime.setFont(Font.font("Verdana", 20));
        timeVbox.getChildren().addAll(textSpace, textTime);

        // INGRESO DE NOMBRE
        VBox nameBox = new VBox(5);
        nameBox.setAlignment(Pos.TOP_CENTER);
        Label name = new Label("INGRESE SU NOMBRE: ");
        TextField enterName = new TextField();
        enterName.setBackground(Background.EMPTY);
        enterName.setPadding(new Insets(0, 50, 0, 50));
        nameBox.setPrefSize(500, 500);
        nameBox.setPadding(new Insets(100, 0, 0, 0));
        nameBox.setStyle("-fx-background-image: url('images/paper.png');" +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: 450 575;" +
                "-fx-background-position: center center;");
        TextField playerDescription = new TextField();
        playerDescription.setBackground(Background.EMPTY);
        playerDescription.setPadding(new Insets(0, 50, 0, 50));
        playerDescription.setAlignment(Pos.TOP_CENTER);
        playerDescription.setFont(Font.font ("Verdana", 11));
        TextField suspectDescription = new TextField();
        suspectDescription.setPrefSize(5,5);
        suspectDescription.setBackground(Background.EMPTY);
        suspectDescription.setPadding(new Insets(0, 50, 0, 50));
        suspectDescription.setAlignment(Pos.TOP_CENTER);
        suspectDescription.setFont(Font.font ("Verdana", 11));
        TextField stolenItemDescription = new TextField();
        stolenItemDescription.setBackground(Background.EMPTY);
        stolenItemDescription.setPadding(new Insets(0, 50, 0, 50));
        stolenItemDescription.setAlignment(Pos.TOP_CENTER);
        stolenItemDescription.setFont(Font.font ("Verdana", 11));
        nameBox.getChildren().addAll(name, enterName, playerDescription, suspectDescription, stolenItemDescription);

        EnterNameView enterNameView = new EnterNameView(nameBox, game);
        EnterNameEventHandler enterNameEventHandler = new EnterNameEventHandler(game, stage, enterNameView);
        enterName.setOnAction(enterNameEventHandler);

        // PANTALLA IZQUIERDA
        VBox left = new VBox(5);
        left.setPrefSize(426, 570);
        left.setBorder(new Border(new BorderStroke(Paint.valueOf("black"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        left.getChildren().addAll(timeVbox, nameBox);

        // PANTALLA DERECHA
        VBox right = new VBox(5);
        right.setPrefSize(713, 570);
        right.setBorder(new Border(new BorderStroke(Paint.valueOf("black"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        right.getChildren().addAll(vRightContainer);

        // PANTALLA COMPLETA
        HBox fullScreen = new HBox(20);
        fullScreen.getChildren().addAll(left, right);
        fullScreen.setBorder(new Border(new BorderStroke(Paint.valueOf("black"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        fullScreen.setPadding(new Insets(10));

        centralContainer = new VBox(fullScreen);
        centralContainer.setAlignment(Pos.CENTER);
        centralContainer.setSpacing(20);
        centralContainer.setPadding(new Insets(25));

        this.setCenter(centralContainer);

    }

    private void setMenu() {
        this.menuBar = new ApplicationMenuBar(stage);
        this.setTop(menuBar);
    }

}
