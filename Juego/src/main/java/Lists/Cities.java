package Lists;
import MainObjects.City;
import MainObjects.DoubleLinkedList;
import MainObjects.StolenItem;

import java.util.ArrayList;

public class Cities {

    private ArrayList<City> cities;
    private City startCity;

    public Cities(){
        cities = new ArrayList<>();
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

}
