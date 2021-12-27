package Vista.Eventos;

import Modelo.MainObjects.Feature;
import Modelo.MainObjects.Game;
import Modelo.MainObjects.Suspect;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Collection;

public class EmitWarrantButtonEventHandler implements EventHandler<ActionEvent> {


    private Game game;
    private Feature sex, hair, hobby, accessory, vehicle;
    private VBox allCBX;
    private Label searchResult;

    public EmitWarrantButtonEventHandler(Game game, VBox allCBX, Label searchResult) {
        this.game = game;
        this.allCBX = allCBX;
        this.searchResult = searchResult;
    }

    @Override
    public void handle(ActionEvent event) {
        ArrayList<Suspect> suspects = game.filterFeatures(this.setFeatures());
        ArrayList<Label> suspectsToShow = new ArrayList<Label>();

        String filterResult;

        if (suspects.size() == 1){
            game.emitWarrant(suspects.get(0));
            filterResult =  "Bingo! We have found only one suspect that fits the description.\n"
                            +"An arrest warrant has been issued for " + suspects.get(0).getName() + ".";
        }

        else if (suspects.size() > 1) {
            filterResult = "The suspects that match your description are:\n";
            for (Suspect s : suspects) {
                filterResult += s.getName() + "\n";
            }

        }
        else filterResult = "There are no suspects that fit the description.";

        searchResult.setText(filterResult);

    }

    private ArrayList<Feature> setFeatures() {
        sex = new Feature(( (ComboBox<String>) allCBX.getChildren().get(0) ).getValue());
        hair = new Feature(( (ComboBox<String>) allCBX.getChildren().get(1) ).getValue());
        hobby = new Feature(( (ComboBox<String>) allCBX.getChildren().get(2) ).getValue());
        accessory = new Feature(( (ComboBox<String>) allCBX.getChildren().get(3) ).getValue());
        vehicle = new Feature(( (ComboBox<String>) allCBX.getChildren().get(4) ).getValue());
        ArrayList<Feature> features = new ArrayList<>();
        features.add(sex);
        features.add(hair);
        features.add(hobby);
        features.add(accessory);
        features.add(vehicle);

        return features;
    }


}
