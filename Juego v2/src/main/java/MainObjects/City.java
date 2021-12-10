package MainObjects;
import MainObjects.Buildings.Airport;
import MainObjects.Buildings.Bank;
import MainObjects.Buildings.Building;
import MainObjects.Buildings.Library;

import java.util.ArrayList;

public class City {

    // VIEJOS ATRIBUTOS
    private String flag, currency, geography, leader;
    private ArrayList<String> landmarks, industries, animals, people, languages, art, religion, misc;
    private City nextCity;
    private final int BANK = 1;
    private final int AIRPORT = 2;
    private final int LIBRARY = 3;

    // NUEVOS ATRIBUTOS
    private String name;
    private float latitude, longitude;
    private Bank bank;
    private Library library;
    private Airport airport;
    private Building buildingToEnter;

    public String getName() {
        return name;
    }

    public City getNextCity() {
        return nextCity;
    }

    public Bank getBuilding(Bank bank) {
        return this.bank;
    }

    public Library getBuilding(Library library) {
        return this.library;
    }
}
