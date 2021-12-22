package Modelo.Lists;

import Modelo.MainObjects.*;

import java.util.ArrayList;
import java.util.Random;

public class Cities {

    private ArrayList<City> cities;
    private City startCity;

    public Cities(){
        cities = new ArrayList<>();
    }

    public void setSuspect(Suspect suspect){
        cities.forEach(c -> {
            c.setSuspect(suspect);
        });
    }

    public void printCities() {
        cities.forEach(c -> {
            System.out.println(c.getName());
        });
    }
    public void add(City city) {
        cities.add(city);
    }

    public int size() {
        return cities.size();
    }

    public City get(int i) {
        return cities.get(i);
    }

    public void connect(DoubleLinkedList<City> list) {
        cities.forEach(list::insert);
    }

    public City find(String city) {
        return cities.stream().filter(s -> city.equals(s.getName()))
                .findAny()
                .orElse(null);
    }

    public void remove(City city) {
        cities.remove(city);
    }

    public void startCity(StolenItem stolenItem) {
        this.startCity = this.find(stolenItem.origin());
    }

    public City getStartCity() {
        return startCity;
    }

    public void getCitiesToShow() {

    }

    public void setPossibleCities(Police police) {
        City currentCity = police.getCurrentCity();
        if (currentCity.getConnections() != null) return;
        City previousCity = police.previousCity();
        Suspect suspect = currentCity.getSuspect();

        ArrayList<City> possibleCities = new ArrayList<>();
        if (previousCity != null) { possibleCities.add(previousCity); }
        if (suspect.passedThrough(currentCity)) {
            possibleCities.add(suspect.getNextCity(currentCity));
        }

        int numberOfCities = 4;
        ArrayList<City> availableCities = new ArrayList<>(cities);
        Random random = new Random();
        for (int i = possibleCities.size(); i < numberOfCities; i++) {
            int randomInt = random.nextInt(availableCities.size());
            possibleCities.add(availableCities.get(randomInt));
            availableCities.remove(randomInt);
        }

        currentCity.setConnections(possibleCities);
    }
}
