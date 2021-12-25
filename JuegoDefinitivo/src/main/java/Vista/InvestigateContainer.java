package Vista;

import Modelo.MainObjects.Buildings.Airport;
import Modelo.MainObjects.Buildings.Bank;
import Modelo.MainObjects.Buildings.Building;
import Modelo.MainObjects.Buildings.Library;
import Modelo.MainObjects.Game;
import Vista.Eventos.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class InvestigateContainer extends BorderPane {

    private Stage stage;
    private Game game;
    private VBox centralContainer;
    private ApplicationMenuBar menuBar;


    public InvestigateContainer(Stage stage, Game game) {
        this.stage = stage;
        this.game = game;
        centralContainer = new VBox();
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

        // PANTALLA DERECHA DE JUEGO
        VBox screen = new VBox(0);
        screen.setPrefSize(813, 682);
        screen.setAlignment(Pos.TOP_CENTER);
        screen.setPadding(new Insets(20,0,0,0));
        screen.setBackground(new Background(new BackgroundFill(Paint.valueOf("black"), CornerRadii.EMPTY, Insets.EMPTY)));
        screen.setBorder(new Border(new BorderStroke(Paint.valueOf("white"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));
        Label clueLabel = new Label();
        clueLabel.setTextFill(Color.web("#ffffff", 0.9));
        clueLabel.setFont(Font.font("Verdana", 20));

        // BOTONERA
        ButtonBar buttonBar = new ButtonBar(20);
        buttonBar.getStyleClass().add("button-box");

        screen.getChildren().addAll(clueLabel);
        vRightContainer.getChildren().addAll(screen, buttonBar);

        // ESPACIO PARA CIUDAD ACTUAL Y TIEMPO RESTANTE
        VBox timeVbox = new VBox();
        timeVbox.getStyleClass().add("time-box");

        Label textTime = new Label(game.time());
        Label textSpace = new Label(game.getCityName());
        textTime.getStyleClass().add("time-label");
        textSpace.getStyleClass().add("city-label");

        timeVbox.getChildren().addAll(textSpace, textTime);

        HBox enterBuildingOptions = new HBox(5);
        enterBuildingOptions.getStyleClass().add("travel-box");


        // BOTONES EDIFICIOS
        ArrayList<Building> buildings = game.getBuildings();

        System.out.println(buildings.size());


        Building building1 = buildings.get(0);
        Building building2 = buildings.get(1);
        Building building3 = buildings.get(2);

        EnterBankEventHandler enterBankEventHandler = new EnterBankEventHandler(game, clueLabel);
        EnterAirportEventHandler enterAirportEventHandler = new EnterAirportEventHandler(game, clueLabel);
        EnterLibraryEventHandler enterLibraryEventHandler = new EnterLibraryEventHandler(game, clueLabel);

        Button building1Button = new Button();
        building1Button.setText(building1.getName());
        Button building2Button = new Button(building2.getName());
        building2Button.setText(building2.getName());
        Button building3Button = new Button(building3.getName());
        building3Button.setText(building3.getName());

        building1Button.setOnAction(enterBankEventHandler);
        building2Button.setOnAction(enterAirportEventHandler);
        building3Button.setOnAction(enterLibraryEventHandler);

        enterBuildingOptions.getChildren().addAll(building1Button,building2Button,building3Button);



        // ESPACIO PARA MOSTRAR CIUDADES
        VBox showCities = new VBox();
        showCities.setAlignment(Pos.CENTER);
        showCities.setPrefSize(420, 200);
        showCities.setBackground(new Background(new BackgroundFill(Paint.valueOf("black"), CornerRadii.EMPTY, Insets.EMPTY)));
        showCities.setBorder(new Border(new BorderStroke(Paint.valueOf("white"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));


        // PANTALLA IZQUIERDA
        VBox left = new VBox(5);
        left.setPrefSize(426, 570);
        left.setBorder(new Border(new BorderStroke(Paint.valueOf("black"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        left.getChildren().addAll(timeVbox, enterBuildingOptions, showCities);

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

        // EVENTOS DE LOS BOTONES
        TravelButtonEventHandler travelButtonEventHandler = new TravelButtonEventHandler(game, stage);
        buttonBar.setTravelAction(travelButtonEventHandler);

        ConnectionsButtonEventHandler connectionsButtonEventHandlerEventHandler = new ConnectionsButtonEventHandler(game, stage);
        buttonBar.setConnectionsAction(connectionsButtonEventHandlerEventHandler);

        this.setCenter(centralContainer);

    }



}
