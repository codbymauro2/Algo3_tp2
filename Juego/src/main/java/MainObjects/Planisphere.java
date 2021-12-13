package MainObjects;

import Lists.Cities;

public class Planisphere {

    private int index = 0;
    DoubleLinkedList<City> suspectCities = new DoubleLinkedList<>();

    Cities cities = new Cities();

    public Planisphere(Cities cities) {
        this.cities = cities;
        this.connectCities();
    }

    public Planisphere() {

    }

    private void connectCities() {

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
