package Vista;

import Modelo.MainObjects.City;
import Modelo.MainObjects.Game;
import Vista.Eventos.*;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ConnectionsContainer extends BorderPane {
    private final Stage stage;
    private final Game game;
    private VBox centralContainer;
    private ApplicationMenuBar menuBar;

    public ConnectionsContainer(Stage stage, Game game) {
        this.stage = stage;
        this.game = game;
        this.centralContainer = new VBox();
        this.setMenu();
        this.setCenter();
    }

    private void setMenu() {
        this.menuBar = new ApplicationMenuBar(stage);
        this.setTop(menuBar);
    }

    private void setCenter() {
        // CONTENEDOR PANTALLA/BOTONES
        VBox vRightContainer = new VBox(0);
        vRightContainer.getStyleClass().add("right-side-box");

        // MAPA
        VBox screen = new VBox(0);
        screen.getStyleClass().add("map");

        // BOTONERA
        ButtonBar buttonBar = new ButtonBar(20);
        buttonBar.getStyleClass().add("button-box");

        vRightContainer.getChildren().addAll(screen, buttonBar);

        // ESPACIO PARA CIUDAD ACTUAL Y TIEMPO RESTANTE
        VBox timeVbox = new VBox();
        timeVbox.getStyleClass().add("time-box");

        Label textTime = new Label(game.time());
        Label textSpace = new Label(game.getCityName());
        textTime.getStyleClass().add("time-label");
        textSpace.getStyleClass().add("city-label");

        timeVbox.getChildren().addAll(textSpace, textTime);

        // CIUDADES POSIBLES
        VBox travelOptions = new VBox(5);
        travelOptions.getStyleClass().add("travel-box");
        ArrayList<City> travelCities = game.getTravelCities();

        Label cityToChoose1 = new Label(travelCities.get(0).getName());
        Label cityToChoose2 = new Label(travelCities.get(1).getName());
        Label cityToChoose3 = new Label(travelCities.get(2).getName());
        Label cityToChoose4 = new Label(travelCities.get(3).getName());

        cityToChoose1.getStyleClass().add("connections-label");
        cityToChoose2.getStyleClass().add("connections-label");
        cityToChoose3.getStyleClass().add("connections-label");
        cityToChoose4.getStyleClass().add("connections-label");

        travelOptions.getChildren().addAll(cityToChoose1,cityToChoose2,cityToChoose3,cityToChoose4);

        // PANTALLA IZQUIERDA
        VBox left = new VBox(5);
        left.setPrefSize(426, 570);
        left.getChildren().addAll(timeVbox, travelOptions);

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
        EmitWarrantEventHandler emitWarrantEventHandler = new EmitWarrantEventHandler(game, stage);
        buttonBar.setWarrantAction(emitWarrantEventHandler);

        InvestigateButtonEventHandler investigateButtonEventHandler = new InvestigateButtonEventHandler(game,stage);
        buttonBar.setInvestigateAction(investigateButtonEventHandler);

        TravelButtonEventHandler travelButtonEventHandler = new TravelButtonEventHandler(game, stage);
        buttonBar.setTravelAction(travelButtonEventHandler);

        this.setCenter(centralContainer);
    }
}
