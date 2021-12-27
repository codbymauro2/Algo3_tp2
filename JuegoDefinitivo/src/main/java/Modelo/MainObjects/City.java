package Modelo.MainObjects;

import Modelo.MainObjects.Buildings.Airport;
import Modelo.MainObjects.Buildings.Bank;
import Modelo.MainObjects.Buildings.Building;
import Modelo.MainObjects.Buildings.Library;

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
    private ArrayList<City> connections;

    public City(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates  = coordinates;
    }

    @Override
    public boolean equals(Object city) {
        return (Objects.equals(this.name, ((City) city).getName()) && coordinates.equals(((City) city).getCoordinates()));
    }

    public String getName() {
        return name;
    }

    public City getNextCity() {
//        if(this.isFinalCity())
//            return new FinalCity();
        return suspect.getNextCity(this);
    }

    public void setNextCity(City nextCity){
        this.nextCity = nextCity;
    }

    public Coordinates getCoordinates() {return coordinates; }

    public void setSuspect(Suspect suspect) {
        this.suspect = suspect;
    }

    public Suspect getSuspect() { return this.suspect; }

    public boolean correctCity() { return suspect.passedThrough(this); }

    public double calculateDistanceTo(City city) {
        return coordinates.distanceKms(city.getCoordinates());
    }

    public void setConnections(ArrayList<City> connections) {
        this.connections = connections;
    }

    public ArrayList<City> getConnections() {
        return connections;
    }

    public ArrayList<Building> getBuildings() {
        ArrayList<Building> buildings = new ArrayList<>();
        buildings.add(this.bank);
        buildings.add(this.airport);
        buildings.add(this.library);
        return buildings;
    }

    public Airport getAirport() {
        //if (this.airport == null) return new Airport(?????);
        return this.airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Bank getBank() {
        return this.bank;
    }

    public Library getLibrary() {
        return this.library;
    }

    public boolean isFinalCity() {
        return suspect.isInCity(this);
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

}
