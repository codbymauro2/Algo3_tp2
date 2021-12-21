package Vista.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
import javafx.scene.image.Image;

import java.awt.*;

public class TravelButtonEventHandler implements EventHandler<ActionEvent> {

    VBox screen;

    public TravelButtonEventHandler(VBox screen){
        this.screen = screen;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        screen.getChildren().clear();
        Image image = new Image("CarmenMap.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
        screen.setBackground(new Background(backgroundImage));
    }
}
