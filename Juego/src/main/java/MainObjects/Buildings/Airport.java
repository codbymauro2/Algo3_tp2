package MainObjects.Buildings;

import MainObjects.City;

public class Airport extends Building {

    // private int entries;
    public void enterBuilding(City nextCity, int clueDifficulty){
        String clue = nextCity.getAirport().getClue(clueDifficulty);
        System.out.println(clue);
    }

}