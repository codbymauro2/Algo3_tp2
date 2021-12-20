package MainObjects;

import Lists.Cities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.stream.IntStream;

public class Suspect {

    private String name, gender,hobby, accessory,vehicle,hair;
    private boolean isRobber, isArrested;
    private Feature feature;
    private java.util.ArrayList<City> path;

    public Suspect(String name, String gender,String hair, String hobby, String accessory, String vehicle, Feature feature) {
        this.name = name;
        this.feature = feature;
        this.gender = gender;
        this.hair = hair;
        this.accessory = accessory;
        this.vehicle = vehicle;
        this.hobby = hobby;
        this.isRobber = false;
        this.isArrested = false;
    }

    public Suspect(String name, String gender, String hobby, String hair, String accessory, String vehicle) {
        this.name = name;
        this.gender = gender;
        this.hair = hair;
        this.accessory = accessory;
        this.vehicle = vehicle;
        this.hobby = hobby;
        this.isRobber = false;
        this.isArrested = false;
    }

    public Suspect(String[] array) {
        this.name = array[0];
        this.gender = array[1];
        this.hobby = array[2];
        this.accessory = array[3];
        this.vehicle = array[4];
    }

    @Override
    public boolean equals(Object obj){
        return this.name.equals( ( (Suspect) obj).getName() );
    }

    public String getName() {
        return name;
    }

    public boolean hasHair(String hair) {
        return this.hair.equals(hair);
    }

    public boolean hasHobby(String hobby) {
        return this.hobby.equals(hobby);
    }

    public boolean isGender(String gender) { return this.gender.equals(gender); }

    public boolean hasAccessory(String accessory) { return this.accessory.equals(accessory); }

    public boolean hasVehicle(String vehicle) { return this.vehicle.equals(vehicle); }

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

}
