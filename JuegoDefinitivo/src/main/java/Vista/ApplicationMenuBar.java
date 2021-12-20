package Vista;

import Vista.Eventos.AboutOptionEventHandler;
import Vista.Eventos.ExitOptionEventHandler;
import Vista.Eventos.FullScreenOptionEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;

public class ApplicationMenuBar extends MenuBar {

    MenuItem fullScreenOption = new MenuItem("Pantalla completa");

    public ApplicationMenuBar(Stage stage) {

        Menu menuFile = new Menu("Archivo");
        Menu menuView = new Menu("Ver");
        Menu menuHelp = new Menu("Ayuda");

        MenuItem exitOption = new MenuItem("Salir");
        MenuItem openOption = new MenuItem("Abrir");
        MenuItem aboutOption = new MenuItem("Acerca de...");

        ExitOptionEventHandler exitOptionHandler = new ExitOptionEventHandler();
        exitOption.setOnAction(exitOptionHandler);

        AboutOptionEventHandler aboutHandler = new AboutOptionEventHandler();
        aboutOption.setOnAction(aboutHandler);

        FullScreenOptionEventHandler fullScreenHandler = new FullScreenOptionEventHandler(stage, fullScreenOption);
        fullScreenOption.setOnAction(fullScreenHandler);

        fullScreenOption.setDisable(true);

        menuFile.getItems().addAll(openOption, new SeparatorMenuItem(), exitOption);
        menuHelp.getItems().addAll(aboutOption);
        menuView.getItems().addAll(fullScreenOption);

        this.getMenus().addAll(menuFile, menuView, menuHelp);
    }

    public void applicationMaximize() {
        fullScreenOption.setDisable(false);
    }
}
