import Lists.CitiesList;
import MainObjects.City;
import Readers.CityReader;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCityRead {

    @Test
    public void TestQuantityCitys() throws IOException {
        CitiesList cityList = new CitiesList();
        CityReader reader = new CityReader(cityList);
        reader.read();
        assertEquals(cityList.size(),1);
    }

    @Test
    public void TestCityName() throws IOException {
        CitiesList cityList = new CitiesList();
        CityReader reader = new CityReader(cityList);
        reader.read();
        assertEquals(cityList.get(0).getName(),"Athens");
    }
}
