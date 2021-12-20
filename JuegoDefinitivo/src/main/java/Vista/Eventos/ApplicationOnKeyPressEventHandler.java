package Vista.Eventos;

import Vista.ApplicationMenuBar;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ApplicationOnKeyPressEventHandler implements EventHandler<KeyEvent> {

    private Stage stage;
    private ApplicationMenuBar menuBar;

    public ApplicationOnKeyPressEventHandler(Stage stage, ApplicationMenuBar menuBar) {
        this.stage = stage;
        this.menuBar = menuBar;
    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getCode() == KeyCode.C) {
            stage.setMaximized(true);
            menuBar.applicationMaximize();
        }
    }
}
