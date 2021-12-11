package Lists;
import MainObjects.City;
import MainObjects.DoubleLinkedList;
import java.util.ArrayList;

public class Cities {

    ArrayList<City> cities = new ArrayList<>();

    public void add(City city) {
        cities.add(city);
    }

    public void remove (City city) { cities.remove(city); }

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

}
