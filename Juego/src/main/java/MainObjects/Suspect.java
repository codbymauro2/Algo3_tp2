package MainObjects;

import Lists.Cities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.stream.IntStream;

public class Suspect {

    private String Name, Gender, Hobby, Hair, Accessory, Vehicle;
    private boolean isRobber, isArrested;
    private java.util.ArrayList<City> path;

    public Suspect(String name, String gender, String hobby, String hair, String accessory, String vehicle) {
        this.Name = name;
        this.Gender = gender;
        this.Hobby = hobby;
        this.Hair = hair;
        this.Accessory = accessory;
        this.Vehicle = vehicle;
        this.isRobber = false;
        this.isArrested = false;
        this.path = createPath();
    }

    public Suspect(String[] array) {
        this.Name = array[0];
        this.Gender = array[1];
        this.Hobby = array[2];
        this.Accessory = array[3];
        this.Vehicle = array[4];
    }

    @Override
    public boolean equals(Object obj){
        return this.Name.equals( ( (Suspect) obj).getName() );
    }

    public String getName() {
        return Name;
    }

    public boolean hasHair(String hair) {
        return this.Hair.equals(hair);
    }

    public boolean hasHobby(String hobby) {
        return this.Hobby.equals(hobby);
    }

    public boolean isGender(String gender) { return this.Gender.equals(gender); }

    public boolean hasAccessory(String accessory) { return this.Accessory.equals(accessory); }

    public boolean hasVehicle(String vehicle) { return this.Vehicle.equals(vehicle); }

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

    private ArrayList<City> createPath(Cities cities, City origin, int difficulty) {
        ArrayList<City> path = new ArrayList<>();
        cities.remove(origin);
        Random random = new Random();
        int bound = difficulty - 1;
        for (int i = 0; i < bound; i++) {
            int randomInt = random.nextInt(cities.size());
            City nextCity = cities.get(randomInt);
            origin.setNextCity(nextCity);
            path.add(origin);
            origin = nextCity;
            cities.remove(origin);
        }        
        Coordinates coordinates = new Coordinates(0.00, 0.00);
        City suspectCurrenCity = new City("Ganador", coordinates);
        origin.setNextCity(suspectCurrenCity);
        return path;
    }

}
