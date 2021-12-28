import Modelo.MainObjects.City;
import Modelo.MainObjects.FinalCityException;
import Modelo.MainObjects.Game;
import Modelo.MainObjects.Suspect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestGameButtons {
    private Game game;

    @Test
    public void test01ButtonsInFinalCityWork() throws FileNotFoundException {
        this.game = new Game();
        game.setPlayer("Messi"); //Rookie, pasa por 4 ciudades (3 pistas)
        game.startGame();
        game.initializeCase();

        int amountOfClues = game.getThief().getPath().size() - 1;
        City previousCity = game.getCurrentCity();
        for (int i = 0; i < amountOfClues; i++) {
            try {
                previousCity = game.getCurrentCity();
                game.travel(previousCity.getNextCity());
            } catch (FinalCityException ignored) {}
        }
        Assertions.assertTrue(game.getCurrentCity().isFinalCity());
        ArrayList<City> possibleCities = game.getTravelCities();
        Assertions.assertEquals(4, possibleCities.size());
        game.travel(previousCity);
        try {
            game.travel(previousCity.getNextCity());
        } catch (FinalCityException ignored) {}

        Assertions.assertTrue(game.getCurrentCity().isFinalCity());
        ArrayList<Suspect> suspects = game.filterFeatures(game.getThief().getFeatures());
        game.emitWarrant(suspects.get(0));
        game.gunAttack();
        Assertions.assertTrue(game.end());
    }
}
