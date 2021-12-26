package Modelo.MainObjects;

import Modelo.Lists.Cities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.stream.IntStream;

public class Suspect {

    private ArrayList<String> featureClues;
    private String name, gender, hobby, hair, accessory, vehicle;
    private ArrayList<Feature> features;
    private boolean isRobber, isArrested;
    private java.util.ArrayList<City> path;
    private final int GENDER = 0, HOBBY = 1, HAIR = 2, ACCESSORY = 3, VEHICLE = 4;

    public Suspect(String name, Feature gender, Feature hobby, Feature hair, Feature accessory, Feature vehicle) {
        this.name = name;
        this.features = new ArrayList<>();
        this.features.add(gender);
        this.features.add(hobby);
        this.features.add(hair);
        this.features.add(accessory);
        this.features.add(vehicle);
        this.isRobber = false;
        this.isArrested = false;
    }

    public Suspect() {
        this.isRobber = false;
        this.isArrested = false;
    }

    public void createFeatureClues() {
        featureClues = new ArrayList<>();
        featureClues.add("I heard that the suspect liked " + features.get(HOBBY).getFeature());
        featureClues.add("The suspect had " + features.get(HAIR).getFeature() + " hair");
        featureClues.add("The suspect had a distinctive " + features.get(ACCESSORY).getFeature());
        featureClues.add("The suspect was driving a " + features.get(VEHICLE).getFeature());
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

    public void createPath(Cities cities, int citiesToTravel) {
        ArrayList<City> path = new ArrayList<>();
        City origin = cities.getStartCity();
        origin.setSuspect(this);
        Random random = new Random();
        for (int i = 0; i < citiesToTravel; i++) {
            cities.remove(origin);
            path.add(origin);
            if (cities.size() == 0) break;
            int randomInt = random.nextInt(cities.size());
            City nextCity = cities.get(randomInt);
            origin.setNextCity(nextCity);
            origin = nextCity;
            origin.setSuspect(this);
        }
        Coordinates coordinates = new Coordinates(0.00, 0.00);
        City suspectCurrenCity = new City("Ganador", coordinates);
        origin.setNextCity(suspectCurrenCity);
        this.path = path;
    }

    public City getNextCity(City city) {
        return path.get(path.indexOf(city) + 1);
    }

    public String getGender() {
        return this.features.get(GENDER).getFeature();
    }

    private void createFeatures() {
        Feature gender = new Feature(this.gender);
        Feature hobby = new Feature(this.hobby);
        Feature hair = new Feature(this.hair);
        Feature accessory = new Feature(this.accessory);
        Feature vehicle = new Feature(this.vehicle);
        features.add(gender);
        features.add(hobby);
        features.add(hair);
        features.add(accessory);
        features.add(vehicle);
    }

    public String getFeatureClue(Rookie police) {
        Random random = new Random();
        if (random.nextInt(10) <= 4)
            return "";
        int randomInt = random.nextInt(featureClues.size());
        String featureClue = featureClues.get(randomInt);
        featureClues.remove(randomInt);
        return featureClue;
    }

    public String getFeatureClue(Detective police) {
        Random random = new Random();
        if (random.nextInt(10) <= 3)
            return "";
        int randomInt = random.nextInt(featureClues.size());
        String featureClue = featureClues.get(randomInt);
        featureClues.remove(randomInt);
        return featureClue;
    }

    public String getFeatureClue(Investigator police) {
        Random random = new Random();
        if (random.nextInt(10) <= 2)
            return "";
        int randomInt = random.nextInt(featureClues.size());
        String featureClue = featureClues.get(randomInt);
        featureClues.remove(randomInt);
        return featureClue;
    }

    public String getFeatureClue(Sergeant police) {

        Random random = new Random();
        if (random.nextInt(10) <= 1)
            return "";
        int randomInt = random.nextInt(featureClues.size());
        String featureClue = featureClues.get(randomInt);
        featureClues.remove(randomInt);
        return featureClue;

    }
}
