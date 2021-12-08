package MainObjects.Buildings;

import MainObjects.City;

public class Library extends Building {

    // private int entries;
    public void enterBuilding(City nextCity, int clueDifficulty){
        String clue = nextCity.getLibrary().getClue(clueDifficulty);
        System.out.println(clue);
    }
}