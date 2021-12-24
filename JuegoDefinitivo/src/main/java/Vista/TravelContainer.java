package Vista;

import Modelo.MainObjects.City;
import Modelo.MainObjects.Game;
import Vista.Eventos.InvestigateButtonEventHandler;
import Vista.Eventos.TravelToCityEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;


public class TravelContainer extends BorderPane {


    private final Stage stage;
    private final Game game;
    private VBox centralContainer;
    private ApplicationMenuBar menuBar;

    public TravelContainer(Stage stage, Game game) {
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

        // PANTALLA DERECHA DE JUEGO
        VBox screen = new VBox(0);
        screen.setPrefSize(813, 682);
        Image image = new Image("images/CarmenMap.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
        screen.setBackground(new Background(backgroundImage));
        screen.setBorder(new Border(new BorderStroke(Paint.valueOf("white"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));

        // BOTONERA
        ButtonBar buttonBar = new ButtonBar(20);

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
        
        // BOTONES VIAJAR
        VBox travelOptions = new VBox(5);
        travelOptions.setAlignment(Pos.TOP_CENTER);
        travelOptions.setPrefSize(500, 500);
        travelOptions.setPadding(new Insets(100, 0, 0, 0));
        travelOptions.setBackground(new Background(new BackgroundFill(Paint.valueOf("black"), CornerRadii.EMPTY, Insets.EMPTY)));
        travelOptions.setBorder(new Border(new BorderStroke(Paint.valueOf("white"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));

        // BOTONES DE PAISES

        ArrayList<City> travelCities = game.getTravelCities();

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

        travelOptions.getChildren().addAll(cityToChoose1,cityToChoose2,cityToChoose3,cityToChoose4);

        // PANTALLA IZQUIERDA
        VBox left = new VBox(5);
        left.setPrefSize(426, 570);
        left.setBorder(new Border(new BorderStroke(Paint.valueOf("black"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        left.getChildren().addAll(timeVbox, travelOptions);

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

        InvestigateButtonEventHandler investigateButtonEventHandler = new InvestigateButtonEventHandler(game,stage);
        buttonBar.setInvestigateAction(investigateButtonEventHandler);

        this.setCenter(centralContainer);


    }
}
