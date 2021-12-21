package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.DirectionButtonHandler;
import Vista.Eventos.EnterNameEventHandler;
import Vista.Eventos.MoveButtonHandler;
import Vista.Eventos.TravelButtonEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.*;



public class PrincipalContainer extends BorderPane {

    ApplicationMenuBar menuBar;
    Game game;
    GameView gameView;
    Canvas canvasCentral;
    VBox centralContainer;

    public PrincipalContainer (Stage stage, Game game) {
        this.setMenu(stage);
        this.setCentro(game);
        this.game = game;
    }

    private void setMenu(Stage stage) {
        this.menuBar = new ApplicationMenuBar(stage);
        this.setTop(menuBar);
    }

    private void setCentro(Game game) {

        // BOTON VIAJAR
        Button travelButton = new Button("",new ImageView(new Image("travelButton.png")));
        travelButton.setPrefSize(128,113);

        // BOTON INVESTIGAR
        Button investigateButton = new Button("",new ImageView(new Image("emitOrderButton.png")));
        investigateButton.setPrefSize(128,113);

        // BOTON CIUDADES
        Button emitOrderButton = new Button("",new ImageView(new Image("citiesButtton.png")));
        emitOrderButton.setPrefSize(128,113);

        // BOTON ENTRAR EDIFICIO
        Button enterBuildingButton = new Button("",new ImageView(new Image("enterButton.png")));
        enterBuildingButton.setPrefSize(128,113);


        // CONTENEDOR PANTALLA/BOTONES
        VBox vRightContainer = new VBox(0);

        // PANTALLA DERECHA DE JUEGO
        VBox screen = new VBox(0);
        screen.setPrefSize(813,682);
        screen.setBackground(new Background(new BackgroundFill(Paint.valueOf("black"), CornerRadii.EMPTY, Insets.EMPTY)));
        screen.setBorder(new Border(new BorderStroke(Paint.valueOf("white"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));
                        // Aca seteo la etiqueta nomás, podemos ver de reubicar todo esto en una función
        Label knownPlayer = new Label();
        knownPlayer.setMinWidth(75);
        knownPlayer.setMinHeight(75);
        knownPlayer.setWrapText(true);
        double fontSize = 30.0;
        knownPlayer.setFont(new Font(fontSize));
        knownPlayer.setTextFill(Color.color(1,0,0));
        knownPlayer.setPadding(new Insets(0,10,0,10));
                        // Hasta acá
        screen.getChildren().addAll(knownPlayer);

        // BOTONES
        HBox buttonBar = new HBox(20);
        buttonBar.setPrefSize(813,230);
        buttonBar.setBackground(new Background(new BackgroundFill(Paint.valueOf("grey"), CornerRadii.EMPTY, Insets.EMPTY)));
        buttonBar.getChildren().addAll(travelButton,investigateButton,emitOrderButton,enterBuildingButton);
        buttonBar.setAlignment(Pos.CENTER);
        buttonBar.setPadding(new Insets(10,10,10,10));

        vRightContainer.getChildren().addAll(screen,buttonBar);

        // ESPACIO PARA CIUDAD ACTUAL Y TIEMPO RESTANTE
        VBox timeVbox = new VBox();
        timeVbox.setPrefSize(420,80);
        timeVbox.setBackground(new Background(new BackgroundFill(Paint.valueOf("black"), CornerRadii.EMPTY, Insets.EMPTY)));
        timeVbox.setBorder(new Border(new BorderStroke(Paint.valueOf("white"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));
        Label textTime = new Label(game.time());
        Label textSpace = new Label(game.space());
        textSpace.setTextFill(Color.web("#fcfcfc", 0.9));
        textTime.setTextFill(Color.web("#fcfcfc", 0.9));
        textSpace.setAlignment(Pos.TOP_CENTER);
        textTime.setAlignment(Pos.TOP_CENTER);
        textSpace.setFont(Font.font ("Verdana", 20));
        textTime.setFont(Font.font ("Verdana", 20));
        timeVbox.getChildren().addAll(textSpace, textTime);

        // INGRESO DE NOMBRE
        VBox enterName = new VBox(5);
        enterName.setPrefSize(400,490);
        enterName.setAlignment(Pos.TOP_CENTER);
        enterName.setPadding(new Insets(0,10,0,10));
        Label labelName = new Label("Detective al teclado, por favor indentifíquese:");
        TextField playerTextField = new TextField();

        // EVENTOS DE LOS BOTONES
        TravelButtonEventHandler travelButtonEventHandler = new TravelButtonEventHandler(screen);
        travelButton.setOnAction(travelButtonEventHandler);


        EnterNameEventHandler enterNameEventHandler = new EnterNameEventHandler(gameView, game, playerTextField, knownPlayer);
        playerTextField.setOnAction(enterNameEventHandler);

        enterName.getChildren().addAll(labelName,playerTextField);

        canvasCentral = new Canvas(200, 200);
        gameView = new GameView(game, canvasCentral);
        gameView.paint();

        // PANTALLA IZQUIERDA
        VBox left = new VBox(5);
        left.setPrefSize(426,570);
        left.setBorder(new Border(new BorderStroke(Paint.valueOf("black"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        left.getChildren().addAll(timeVbox,enterName);

        // PANTALLA DERECHA
        VBox right = new VBox(5);
        right.setPrefSize(713,570);
        right.setBorder(new Border(new BorderStroke(Paint.valueOf("black"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        right.getChildren().addAll(vRightContainer);

        // PANTALLA COMPLETA
        HBox fullScreen = new HBox(20);
        fullScreen.getChildren().addAll(left,right);
        fullScreen.setBorder(new Border(new BorderStroke(Paint.valueOf("black"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        fullScreen.setPadding(new Insets(10));

        centralContainer = new VBox(fullScreen);
        centralContainer.setAlignment(Pos.CENTER);
        centralContainer.setSpacing(20);
        centralContainer.setPadding(new Insets(25));

        this.setCenter(centralContainer);
    }


    public ApplicationMenuBar getMenuBar() {
        return menuBar;
    }

    public Game getGame(){
        return this.game;
    }

}

