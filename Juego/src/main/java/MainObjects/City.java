package java.MainObjects;
import java.MainObjects.Buildings.Airport;
import java.MainObjects.Buildings.Bank;
import java.MainObjects.Buildings.Library;
import MainObjects.Timer;

import java.MainObjects.Buildings.Building;
import java.util.ArrayList;

public class City {

    private String name, flag, currency, geography, leader;
    private ArrayList<String> landmarks, industries, animals, people, languages, art, religion, misc;
    private City nextCity;
    private Clues clues;

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
        String clue;
        int opcion = 1; //pedirle al usuario que elija un edificio
        switch(opcion) {
            case BANK:
                building = bank;
                clue = nextCity.clues.getEconomicClue();
                break;
            case AIRPORT:
                building = airport;
                clue = nextCity.clues.getMigrationClue();
                break;
            case LIBRARY:
                building = library;
                clue = nextCity.clues.getCulturalClue();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + opcion);
        }
        building.enter(timer, clue);
    }

    public void distanceNextCity() {
    }
}
