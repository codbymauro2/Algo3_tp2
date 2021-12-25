package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class PrincipalContainer extends BorderPane {

    private final Stage stage;
    private final Game game;
    ApplicationMenuBar menuBar;
    VBox centralContainer;

    public PrincipalContainer (Stage stage, Game game) {
        this.game = game;
        this.stage = stage;
        this.setMenu();
        this.setCentro();
    }

    private void setMenu() {
        this.menuBar = new ApplicationMenuBar(stage);
        this.setTop(menuBar);
    }

    private void setCentro() {
        // CONTENEDOR PANTALLA/BOTONES
        VBox vRightContainer = new VBox(0);
        vRightContainer.getStyleClass().add("right-side-box");

        // PANTALLA DERECHA DE JUEGO
        VBox screen = new VBox(0);
        screen.getStyleClass().add("right-screen");

        // BOTONERA
        ButtonBar buttonBar = new ButtonBar(20);
        buttonBar.getStyleClass().add("button-box");
        vRightContainer.getChildren().addAll(screen, buttonBar);

        // ESPACIO PARA CIUDAD ACTUAL Y TIEMPO RESTANTE
        VBox timeVbox = new VBox();
        timeVbox.getStyleClass().add("time-box");

        Label textSpace = new Label(game.getCityName());
        Label textTime = new Label(game.time());
        textTime.getStyleClass().add("time-label");
        textSpace.getStyleClass().add("city-label");

        timeVbox.getChildren().addAll(textSpace, textTime);

        // CIUDADES
        VBox nameBox = new VBox(5);
        nameBox.setAlignment(Pos.TOP_CENTER);
        nameBox.setPrefSize(500, 500);
        nameBox.setPadding(new Insets(100, 0, 0, 0));
        String string = ("-fx-background-image: url('/images/cities" + game.getCityName() + ".jpg'" + ");");
        nameBox.setStyle(string +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: 450 400;" +
                "-fx-background-position: center center;" );

        VBox showCities = new VBox();
        showCities.setAlignment(Pos.CENTER);
        showCities.setPrefSize(420, 200);
        showCities.setBackground(new Background(new BackgroundFill(Paint.valueOf("black"), CornerRadii.EMPTY, Insets.EMPTY)));
        showCities.setBorder(new Border(new BorderStroke(Paint.valueOf("white"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));

        // PANTALLA IZQUIERDA
        VBox left = new VBox(5);
        left.setPrefSize(426, 570);
        left.getChildren().addAll(timeVbox, nameBox, showCities);

        // PANTALLA DERECHA
        VBox right = new VBox(5);
        right.setPrefSize(713, 570);
        right.getChildren().addAll(vRightContainer);

        // PANTALLA COMPLETA
        HBox fullScreen = new HBox(20);
        fullScreen.getChildren().addAll(left, right);

        centralContainer = new VBox(fullScreen);
        centralContainer.getStyleClass().add("central-container");

        // EVENTOS DE LOS BOTONES
        TravelButtonEventHandler travelButtonEventHandler = new TravelButtonEventHandler(game, stage);
        buttonBar.setTravelAction(travelButtonEventHandler);

        ConnectionsButtonEventHandler connectionsButtonEventHandlerEventHandler = new ConnectionsButtonEventHandler(game, stage);
        buttonBar.setConnectionsAction(connectionsButtonEventHandlerEventHandler);

        InvestigateButtonEventHandler investigateButtonEventHandler = new InvestigateButtonEventHandler(game, stage);
        buttonBar.setInvestigateAction(investigateButtonEventHandler);

        EmitWarrantEventHandler emitWarrantEventHandler = new EmitWarrantEventHandler(game, stage);
        buttonBar.setWarrantAction(emitWarrantEventHandler);

        this.setCenter(centralContainer);
    }

    public ApplicationMenuBar getMenuBar() {
        return menuBar;
    }
}

