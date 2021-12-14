package MainObjects;

import java.util.Random;
import Lists.Cities;

public class Planisphere {

    private int index = 0;
    DoubleLinkedList<City> suspectCities = new DoubleLinkedList<>();

    Cities cities = new Cities();

    public Planisphere(Cities cities, StolenItem stolenItem) {
        this.cities = cities;
        // this.setWrongCities();
        this.createPath(stolenItem);
    }

    public Planisphere() {

    }

    private void createPath(StolenItem stolenItem) {
        City origin = cities.find(stolenItem.origin());
        int difficulty = 5; // ACÁ HABRÍA QUE SACAR UNA RELACIÓN ENTRE VALUE Y CANT DE CIUDADES
        cities.remove(origin);
        Random random = new Random();
        for (int i = 0; i < (difficulty - 1); i++){
            int randomInt = random.nextInt(cities.size());
            City nextCity = cities.get(randomInt);
            origin.setNextCity(nextCity);
            cities.add(origin);
            origin = nextCity;
            cities.remove(origin);
        }
    }

    public City currentCity() {
        return cities.get(index);
    }

    public City getNextCity() {
        return cities.get(index+1);
    }

    public void goForward() {

    }

    public City getCity(String city) {
        return cities.find(city);
    }

    public void startCity(StolenItem stolenItem) {
        suspectCities.insert(cities.find(stolenItem.origin()));
    }

}
