package MainObjects;
import MainObjects.Buildings.Airport;
import MainObjects.Buildings.Bank;
import MainObjects.Buildings.Building;
import MainObjects.Buildings.Library;

import java.util.ArrayList;

public class City {

    private String name, flag, currency, geography, leader;
    private ArrayList<String> landmarks, industries, animals, people, languages, art, religion, misc;
    private City nextCity;
    private Bank bank;
    private Library library;
    private Airport airport;
    private final int BANK = 1;
    private final int AIRPORT = 2;
    private final int LIBRARY = 3;

    public String getName() {
        return name;
    }

    public City getNextCity() {
        return nextCity;
    }

    public void selectBuilding(Timer timer) {
        Building building;
        int opcion = 1; //pedirle al usuario que elija un edificio
        switch(opcion) {
            case BANK:
                building = bank;
                break;
            case AIRPORT:
                building = airport;
                break;
            case LIBRARY:
                building = library;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + opcion);
        }
        building.enter(this.nextCity, timer, this.nextCity.clue()); //???
    }

    private Clue clue() {
        return new Clue();
    }

    public void distanceNextCity() {
    }
}
