package Vista;

import Modelo.MainObjects.City;
import Modelo.MainObjects.Game;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CityButtonsBox extends VBox {
    Game game;
    ArrayList<Button> citiesToChoose;

    public CityButtonsBox(Game game) {
        this.game = game;
        citiesToChoose = new ArrayList<Button>();
    }

    public void addCities(Button cityToChoose1, Button cityToChoose2, Button cityToChoose3, Button cityToChoose4) {
        citiesToChoose.add(cityToChoose1);
        citiesToChoose.add(cityToChoose2);
        citiesToChoose.add(cityToChoose3);
        citiesToChoose.add(cityToChoose4);
    }

    public void hide() {
        citiesToChoose.forEach(c -> {
            c.setVisible(false);
            c.setDisable(true);
        });
    }

    public void show(ArrayList<City> travelCities) {
        for (int i = 0; i < citiesToChoose.size(); i++) {
            citiesToChoose.get(i).setVisible(true);
            citiesToChoose.get(i).setDisable(false);
            citiesToChoose.get(i).setText(travelCities.get(i).getName());
            citiesToChoose.get(i).setPrefSize(100, 50);
        }
    }

    public VBox getVBox() {
        VBox vBox = new VBox();
        vBox.setPrefSize(400, 420);
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(10);
        citiesToChoose.forEach( c -> {
            c.setMaxWidth(420);
            vBox.getChildren().add(c);
        });
        return vBox;
    }
}
