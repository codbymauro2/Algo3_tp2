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
    public boolean equals(Object city) {
        return (Objects.equals(this.name, ((City) city).getName()) && coordinates.equals(((City) city).getCoordinates()));
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

    private Coordinates getCoordinates() {return coordinates; }

    public void setSuspect(Suspect suspect) {
        this.suspect = suspect;
    }

    public Suspect getSuspect() { return this.suspect; }

    public boolean correctCity() { return suspect.passedThrough(this); }

    public int calculateDistanceTo(City city) {
        return coordinates.distanceKms(city.getCoordinates());
    }
}


/*
public class Planisphere {

    private int index, difficulty;
    Stack<City> suspectCities; //ciudades por donde paso el sospechoso
    Cities cities; //todas las ciudades, incluyendo por las que paso el sospechoso
    ArrayList<City> allCities;
    Stack<City> stack;
    City origin;
    Suspect suspect;

    public Planisphere(Cities cities) throws FileNotFoundException {
        this.index = 0;
        this.cities = cities;
        this.origin = cities.getStartCity();
        this.difficulty = 5;
        this.allCities = new ArrayList<City>();
        this.copyCities();
        this.suspectCities = createPath();

        // this.setWrongCities();
    }

    private void copyCities() {
        for (int i = 0; i < cities.size(); i++){ allCities.add(cities.get(i)); }
    }


    private Stack<City> createPath() {
        Stack<City> suspectCities = new Stack<>();
        allCities.remove(origin);
        Random random = new Random();
        for (int i = 0; i < difficulty - 1; i++) {
            if (allCities.size() == 0) break;
            int randomInt = random.nextInt(allCities.size());
            City nextCity = allCities.get(randomInt);
            origin.setNextCity(nextCity);
            suspectCities.push(origin);
            origin = nextCity;
            allCities.remove(origin);
        }
        Coordinates coordinates = new Coordinates(0.00, 0.00);
        City suspectCurrenCity = new City("Ganador", coordinates);
        origin.setNextCity(suspectCurrenCity);
        //suspectCities.peek();
        reverseStack(suspectCities);
        return suspectCities;
    }


    public static <City> void reverseStack(Stack<City> stack) {
        if (stack.isEmpty()) {
            return;
        }
        // Remove bottom element from stack
        City bottom = stack.pop();

        // Reverse everything else in stack
        reverseStack(stack);

        // Add original bottom element to top of stack
        stack.push(bottom);
    }

    public City currentCity() {
        return cities.get(index);
    }

    public City getNextCity() {
        return cities.get(index+1);
    }

    public void goForward() {

    }

    public Stack<City> getStack(){
        return stack;
    }

    public City getCity(String city) {
        return cities.find(city);
    }

    public City getOrigin() {
        return origin;
    }
}
*/



