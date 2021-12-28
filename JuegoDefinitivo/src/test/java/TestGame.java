import Modelo.MainObjects.City;
import Modelo.MainObjects.FinalCityException;
import Modelo.MainObjects.Game;
import Modelo.MainObjects.Suspect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestGame {
    private Game game;

    @Test
    public void test01CatchesSuspectWithoutWarrantWinsGame() throws FileNotFoundException {
        this.game = new Game();
        game.setPlayer("Messi"); //Rookie, pasa por 4 ciudades (3 pistas)
        game.startGame();
        game.initializeCase();

        int amountOfClues = 3;
        for (int i = 0; i < amountOfClues; i++) {
            try {
                String clue = game.deployLibraryClue();
                City currentCity = game.getCurrentCity();
                // Verificamos que la pista sea la de la ciudad siguiente
                Assertions.assertTrue(clue.contains(currentCity.getNextCity().getName()));
                game.travel(currentCity.getNextCity());
            } catch(FinalCityException ignored) {}
        }
        Assertions.assertTrue(game.getCurrentCity().isFinalCity());

        // Emitimos la orden de arresto
        ArrayList<Suspect> suspects = game.filterFeatures(game.getThief().getFeatures());
        game.emitWarrant(suspects.get(0));


        // Entramos al edificio final
        game.gunAttack();

        // Verificamos que se haya ganado el juego
        Assertions.assertTrue(game.end());
    }

    @Test
    public void test02CatchesSuspectWithoutWarrantLoosesGame() throws FileNotFoundException {
        this.game = new Game();
        game.setPlayer("Messi"); //Rookie, pasa por 4 ciudades (3 pistas)
        game.startGame();
        game.initializeCase();

        int amountOfClues = 3;
        for (int i = 0; i < amountOfClues; i++) {
            try {
                String clue = game.deployLibraryClue();
                City currentCity = game.getCurrentCity();
                // Verificamos que la pista sea la de la ciudad siguiente
                Assertions.assertTrue(clue.contains(currentCity.getNextCity().getName()));
                game.travel(currentCity.getNextCity());
            } catch(FinalCityException ignored) {}
        }
        Assertions.assertTrue(game.getCurrentCity().isFinalCity());

        // Entramos al edificio final
        game.gunAttack();

        // Verificamos que se haya ganado el juego
        Assertions.assertFalse(game.end());
    }

    @Test
    public void test03RunsOutOfTimeLoosesGame() throws FileNotFoundException {
        this.game = new Game();
        game.setPlayer("Messi"); //Rookie, pasa por 4 ciudades (3 pistas)
        game.startGame();
        game.initializeCase();

        while (!game.isOutOfTime()) {
            game.deployAirportClue();
        }

        Assertions.assertFalse(game.end());
    }
}
