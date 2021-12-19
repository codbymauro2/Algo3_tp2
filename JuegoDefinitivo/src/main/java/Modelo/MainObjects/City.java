package Modelo.MainObjects;

import Modelo.MainObjects.Buildings.Airport;
import Modelo.MainObjects.Buildings.Bank;
import Modelo.MainObjects.Buildings.Building;
import Modelo.MainObjects.Buildings.Library;

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

    public City(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates  = coordinates;
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

    public boolean correctCity() { return suspect.passedThrough(this); }

}



