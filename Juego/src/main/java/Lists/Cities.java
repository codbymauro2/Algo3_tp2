package Lists;
import MainObjects.City;

import java.util.ArrayList;

public class Cities {

    ArrayList<City> cities = new ArrayList<City>();

    public City getCity(String name) {
        City city = this.cities.stream().
                filter(c -> name.equals(c.getName())).
                findAny().
                orElse(null);

        return city;
    }

    public void add(City city) {
        cities.add(city);
    }

    public void assign(StolenItems stolenItems){
        //random object;
    }

    public int size() {
        return cities.size();
    }

    public City get(int i) {
        return cities.get(i);
    }

}
