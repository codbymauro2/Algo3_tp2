package MainObjects;
import MainObjects.Buildings.Airport;
import MainObjects.Buildings.Bank;
import MainObjects.Buildings.Building;
import MainObjects.Buildings.Library;

import java.util.ArrayList;
import java.util.Objects;

public class City {

    // VIEJOS ATRIBUTOS
    private City nextCity;

    // NUEVOS ATRIBUTOS
    private String name;
    private Coordinates coordinates;
    private Bank bank;
    private Library library;
    private Airport airport;
    private Building buildingToEnter;
    private Suspect suspect;

    public City(String name, double latitude, double longitude) {
        this.name = name;
        this.coordinates  = new Coordinates(latitude,longitude);
    }

    @Override
    public boolean equals(Object city){
        return (Objects.equals(this.name, ((City) city).getName()));
    }

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

    public void setNextCity(City nextCity){
        this.nextCity = nextCity;
    }

    public int distanceNexCity() { return coordinates.distance(nextCity.getCoordinates()); }

    private Coordinates getCoordinates() {return coordinates; }

    public void setSuspect(Suspect suspect) {
        this.suspect = suspect;
    }

    public boolean correctCity() {

        return suspect.passedThrough(this);

    }
}



