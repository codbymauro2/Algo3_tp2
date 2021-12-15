import Lists.Cities;
import MainObjects.*;
import Readers.CityReader;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Stack;

public class TestPlanisphere {


    @Test
    public void ConectCities() throws FileNotFoundException {
        Cities cities = new Cities();
        CityReader cityReader = new CityReader(cities);
        cityReader.read();
        StolenItem stolenItem = new StolenItem("Oro", "Valioso", "Rusia");
        Planisphere planisphere = new Planisphere(cities);
        Stack<City> stack = planisphere.getStack();
        System.out.println(stack.peek());
    }

}
