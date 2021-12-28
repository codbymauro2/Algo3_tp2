package Vista.Eventos;

import Modelo.MainObjects.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CreditsOptionEventHandler implements EventHandler<ActionEvent> {


    private Stage stage;

    public CreditsOptionEventHandler(Stage stage){
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        CreditContainer creditContainer = new CreditContainer(stage);
        Scene creditScene = new Scene(creditContainer, 1180, 660);
        stage.setScene(creditScene);
    }
}
