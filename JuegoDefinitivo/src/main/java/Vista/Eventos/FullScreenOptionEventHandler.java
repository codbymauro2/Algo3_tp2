package Vista.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class FullScreenOptionEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    MenuItem fullScreenOption;

    public FullScreenOptionEventHandler(Stage stage, MenuItem fullScreenOption) {
        this.stage = stage;
        this.fullScreenOption = fullScreenOption;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        if (!stage.isFullScreen()) {
            stage.hide();
            stage.setFullScreen(true);
            fullScreenOption.setDisable(true);
            stage.show();
        }
    }
}
