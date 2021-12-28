package Vista;

import Modelo.MainObjects.City;
import Modelo.MainObjects.Game;
import Vista.Eventos.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TravelContainer extends BorderPane {

    private final Stage stage;
    private final Game game;
    private VBox centralContainer;
    private ApplicationMenuBar menuBar;
    private ButtonBar buttonBar;
    private MainContainer mainContainer;
    private VBox timeVbox;
    private Label textTime;
    private Label textSpace;
    private ArrayList<City> travelCities;

    public TravelContainer(Stage stage, Game game) {
        this.stage = stage;
        this.game = game;
        this.travelCities = game.getTravelCities();
        this.centralContainer = new VBox();
        this.setMenu();
        this.setCenter();
    }

    private void setMenu() {
        this.menuBar = new ApplicationMenuBar(stage);
        this.setTop(menuBar);
    }

    private void setCenter() {

        mainContainer =  new MainContainer(this.game, this.stage);
        buttonBar = new ButtonBar(20);
        buttonBar.getStyleClass().add("button-box");
        mainContainer.setCenter();
        mainContainer.setNameTime( getTimeName() );
        mainContainer.setCitiesBox();
        mainContainer.setFullScreen();
        mainContainer.setLeftScreen( getLeftScreen(travelCities) );
        mainContainer.setRightScreen( getScreen() ) ;
        mainContainer.setButtonBar(buttonBar);
        this.setButtonBarActions();
        mainContainer.buildContainer();
        this.setCenter(mainContainer);
    }

    private VBox getScreen() {
        Canvas canvas = new Canvas(728, 410);
        MapView mapView = new MapView(canvas, travelCities, game.getCurrentCity());
        VBox screen = new VBox(canvas);
        screen.getStyleClass().add("map");
        return screen;
    }

    private VBox getTimeName() {
        timeVbox = new VBox();
        timeVbox.getStyleClass().add("time-box");
        textTime = new Label(game.time());
        textSpace = new Label(game.getCityName());
        textTime.getStyleClass().add("time-label");
        textSpace.getStyleClass().add("city-label");
        timeVbox.getChildren().addAll(textSpace, textTime);
        return timeVbox;
    }

    private VBox getLeftScreen(ArrayList<City> travelCities) {

        VBox travelOptions = new VBox(5);
        travelOptions.getStyleClass().add("travel-box");

        Button cityToChoose1 = new Button(travelCities.get(0).getName());
        Button cityToChoose2 = new Button(travelCities.get(1).getName());
        Button cityToChoose3 = new Button(travelCities.get(2).getName());
        Button cityToChoose4 = new Button(travelCities.get(3).getName());

        cityToChoose1.getStyleClass().add("travel-button");
        cityToChoose2.getStyleClass().add("travel-button");
        cityToChoose3.getStyleClass().add("travel-button");
        cityToChoose4.getStyleClass().add("travel-button");

        TravelToCityEventHandler travelToCity1EventHandler = new TravelToCityEventHandler(game, stage, travelCities.get(0));
        TravelToCityEventHandler travelToCity2EventHandler = new TravelToCityEventHandler(game, stage, travelCities.get(1));
        TravelToCityEventHandler travelToCity3EventHandler = new TravelToCityEventHandler(game, stage, travelCities.get(2));
        TravelToCityEventHandler travelToCity4EventHandler = new TravelToCityEventHandler(game, stage, travelCities.get(3));

        cityToChoose1.setOnAction(travelToCity1EventHandler);
        cityToChoose2.setOnAction(travelToCity2EventHandler);
        cityToChoose3.setOnAction(travelToCity3EventHandler);
        cityToChoose4.setOnAction(travelToCity4EventHandler);

        travelOptions.getChildren().addAll(cityToChoose1, cityToChoose2, cityToChoose3, cityToChoose4);

        return travelOptions;
    }

    private void setButtonBarActions() {
        InvestigateButtonEventHandler investigateButtonEventHandler = new InvestigateButtonEventHandler(game, stage);
        buttonBar.setInvestigateAction(investigateButtonEventHandler);

        TravelButtonEventHandler travelButtonEventHandler = new TravelButtonEventHandler(game, stage);
        buttonBar.setTravelAction(travelButtonEventHandler);

        EmitWarrantEventHandler emitWarrantEventHandler = new EmitWarrantEventHandler(game, stage);
        buttonBar.setWarrantAction(emitWarrantEventHandler);
    }
}