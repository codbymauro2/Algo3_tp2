package MainObjects;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import Lists.Cities;
import java.util.Stack;
import java.util.stream.IntStream;

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
        IntStream.range(0, difficulty - 1).forEach(i -> {
            int randomInt = random.nextInt(allCities.size());
            City nextCity = allCities.get(randomInt);
            origin.setNextCity(nextCity);
            suspectCities.push(origin);
            origin = nextCity;
            allCities.remove(origin);
        });
        Coordinates coordinates = new Coordinates(0.00, 0.00);
        City suspectCurrenCity = new City("Ganador", coordinates);
        origin.setNextCity(suspectCurrenCity);
        suspectCities.peek();
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
