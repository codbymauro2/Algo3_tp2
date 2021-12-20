package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.DirectionButtonHandler;
import Vista.Eventos.EnterNameEventHandler;
import Vista.Eventos.MoveButtonHandler;
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
import javafx.stage.Stage;

import java.awt.*;


public class PrincipalContainer extends BorderPane {

    ApplicationMenuBar menuBar;
    GameView gameView;
    Canvas canvasCentral;
    VBox centralContainer;

    public PrincipalContainer (Stage stage, Game game) {
        this.setMenu(stage);
        this.setCentro(game);
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

        // INGRESO DE NOMBRE
        VBox enterName = new VBox(5);
        enterName.setPrefSize(400,490);
        enterName.setAlignment(Pos.TOP_CENTER);
        enterName.setPadding(new Insets(0,10,0,10));
        Label labelName = new Label("Detective al teclado, por favor ingrese su nombre:");
        TextField playerTextField = new TextField();
        EnterNameEventHandler enterNameEventHandler = new EnterNameEventHandler(gameView,game,playerTextField);
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
}