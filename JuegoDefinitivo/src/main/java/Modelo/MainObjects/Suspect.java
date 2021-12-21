package Modelo.MainObjects;

import Modelo.Lists.Cities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.stream.IntStream;

public class Suspect {

    private String name, gender,hobby, accessory,vehicle,hair;
    private ArrayList<Feature> features;
    private boolean isRobber, isArrested;
    private java.util.ArrayList<City> path;

    public Suspect(String name, Feature feature1, Feature feature2, Feature feature3, Feature feature4, Feature feature5) {
        this.name = name;
        this.features = new ArrayList<>();
        this.features.add(feature1);
        this.features.add(feature2);
        this.features.add(feature3);
        this.features.add(feature4);
        this.features.add(feature5);
        this.isRobber = false;
        this.isArrested = false;
    }

    @Override
    public boolean equals(Object obj){
        return this.name.equals( ( (Suspect) obj).getName() );
    }

    public String getName() {
        return name;
    }

    public boolean isGender(Feature feature) { return this.features.get(0).equals(feature); }

    public boolean hasHobby(Feature feature) {
        return this.features.get(1).equals(feature);
    }

    public boolean hasHair(Feature feature) {
        return this.features.get(2).equals(feature);
    }

    public boolean hasAccessory(Feature feature) { return this.features.get(3).equals(feature); }

    public boolean hasVehicle(Feature feature) { return this.features.get(4).equals(feature); }

    public void convertToRobber() {
        this.isRobber = true;
    }

    public void arrest() {
        isArrested = true;
    }

    public void setNextCity(City city) { this.path.add(city); }

    public boolean passedThrough(City city) {
        return path.contains(city);
    }

    public boolean isInCity(City city) {
        if (path.size() == 0) { return false; }
        return city.equals(path.get(path.size() - 1));
    }

    public ArrayList<City> getPath(){
        return path;
    }

    public void createPath(Cities cities, int difficulty) {
        ArrayList<City> path = new ArrayList<>();
        City origin = cities.getStartCity();
        Random random = new Random();
        for (int i = 0; i < difficulty; i++) {
            cities.remove(origin);
            path.add(origin);
            if (cities.size() == 0) break;
            int randomInt = random.nextInt(cities.size());
            City nextCity = cities.get(randomInt);
            origin.setNextCity(nextCity);
            origin = nextCity;
        }
        Coordinates coordinates = new Coordinates(0.00, 0.00);
        City suspectCurrenCity = new City("Ganador", coordinates);
        origin.setNextCity(suspectCurrenCity);
        this.path = path;
    }

    public City getNextCity(City city) {
        return path.get(path.indexOf(city) + 1);
    }
}
