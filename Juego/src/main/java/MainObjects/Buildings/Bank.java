package MainObjects.Buildings;

import MainObjects.City;
import MainObjects.Clue;
import MainObjects.Timer;

public class Bank extends Building {

    public void enterBuilding(City nextCity, int clueDifficulty){
        String clue = nextCity.getBank().getClue(clueDifficulty);
        System.out.println(clue);
    }

    // VIEJOS ATRIBUTOS
    // private int entries;

    // NUEVOS ATRIBUTOS

}