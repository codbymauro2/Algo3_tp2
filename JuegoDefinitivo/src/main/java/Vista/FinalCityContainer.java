package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.*;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.*;


public class FinalCityContainer extends BorderPane {

    private final Stage stage;
    private final Game game;
    ApplicationMenuBar menuBar;
    VBox centralContainer;

    public FinalCityContainer (Stage stage, Game game) {
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
        Label cityDescription = new Label(game.getCityDescription());
        cityDescription.getStyleClass().add("description-label");
        screen.getStyleClass().add("right-screen");
        screen.getChildren().add(cityDescription);

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
        VBox cityImageBox = new VBox(5);
        cityImageBox.getStyleClass().add("city-image-box");

        String string = ("-fx-background-image: url('/images/cities/" + game.getCityName().replaceAll(" ", "") + ".jpg'" + ");");
        cityImageBox.setStyle(string + "-fx-background-repeat: stretch;" + "-fx-background-size: 450 400;" + "-fx-background-position: center center;");

        VBox showCities = new VBox();
        showCities.getStyleClass().add("bottom-box");
        HBox leftCities = new HBox();
        HBox rightCities = new HBox();
        showCities.getChildren().addAll(leftCities, rightCities);
        showCities.getStyleClass().add("bottom-box");

        // PANTALLA IZQUIERDA
        VBox left = new VBox(5);
        left.setPrefSize(426, 570);
        left.getChildren().addAll(timeVbox, cityImageBox, showCities);

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

        ConnectionsButtonEventHandler connectionsButtonEventHandlerEventHandler = new ConnectionsButtonEventHandler(game, stage, showCities);
        buttonBar.setConnectionsAction(connectionsButtonEventHandlerEventHandler);
        
        EmitWarrantEventHandler emitWarrantEventHandler = new EmitWarrantEventHandler(game, stage);
        buttonBar.setWarrantAction(emitWarrantEventHandler);

        FinalCityInvestigateButtonEventHandler finalCityInvestigateButtonEventHandler = new FinalCityInvestigateButtonEventHandler(game,stage);
        buttonBar.setFinalInvestigateAction(finalCityInvestigateButtonEventHandler);

        this.setCenter(centralContainer);
    }
}
