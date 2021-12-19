
import Modelo.Lists.Cities;
import Modelo.MainObjects.City;
import Modelo.MainObjects.DoubleLinkedList;
import Modelo.Readers.CityReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDoubleLinkedList {

    @Test
    public void test01() throws IOException {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(5);
        list.goForward();
        Assertions.assertEquals(list.getCurrent().getData(),2);
    }
    @Test
    public void test02() throws IOException {
        Cities cities = new Cities();
        CityReader cityReader = new CityReader(cities);
        cityReader.read();
        DoubleLinkedList<City> list = new DoubleLinkedList<>();
        cities.connect(list);
        list.goForward();
        Assertions.assertEquals(list.getCurrent().getData().getName(),"Mexico");
    }
}
