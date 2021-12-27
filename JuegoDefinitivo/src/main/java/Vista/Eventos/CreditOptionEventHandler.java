package Vista.Eventos;

import Modelo.MainObjects.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class CreditOptionEventHandler implements EventHandler<ActionEvent> {

    private Game game;
    Stage stage;

    public CreditOptionEventHandler(Game game, Stage stage){
        this.game = game;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        /*
        CreditConteiner creditConteiner = new CreditConteiner(game, stage);
        Scene creditScene = new Scene(creditConteiner, 1180, 660);
         */
        System.out.println("Practical work number 2 of FIUBA's Algorithms and Programming III carried out by:");
    }
}
