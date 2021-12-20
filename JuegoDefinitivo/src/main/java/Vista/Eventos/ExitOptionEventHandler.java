package Vista.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ExitOptionEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        System.exit(0);
    }
}

