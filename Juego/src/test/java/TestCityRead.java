import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCityRead {

    @Test
    public void TestQuantityCitys() throws IOException {
        ArrayList<City> cityList = new ArrayList<City>();
        CityReader reader = new CityReader(cityList);
        reader.read();
        assertEquals(cityList.size(),1);
    }

    @Test
    public void TestCityName() throws IOException {
        ArrayList<City> cityList = new ArrayList<City>();
        CityReader reader = new CityReader(cityList);
        reader.read();
        assertEquals(cityList.get(0).getName(),"Athens");
    }
}
