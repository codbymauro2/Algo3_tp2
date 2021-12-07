package Lists;
import MainObjects.City;
import MainObjects.StolenItems;

import java.util.ArrayList;

public class CitiesList  {

    ArrayList<City> cities = new ArrayList<City>();

    public void add(City city) {
        cities.add(city);
    }

    public void assign(StolenItemsList stolenItems){
        //random object;
    }

    public int size() {
        return cities.size();
    }

    public City get(int i) {
        return cities.get(i);
    }
}
