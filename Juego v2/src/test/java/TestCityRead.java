import Lists.Cities;
import Readers.CityReader;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCityRead {
    public final int easy = 0;
    public final int medium = 1;
    public final int hard = 2;

    @Test
    public void TestQuantityCitys() throws IOException {
        Cities cityList = new Cities();
        CityReader reader = new CityReader(cityList);
        reader.read();
        assertEquals(cityList.size(),3);
    }

    @Test
    public void TestCityName() throws IOException {
        Cities cityList = new Cities();
        CityReader reader = new CityReader(cityList);
        reader.read();
        assertEquals(cityList.get(1).getName(),"Mexico");
    }

    @Test
    public void TestCityBankClue() throws IOException {
        Cities cities = new Cities();
        CityReader reader = new CityReader(cities);
        reader.read();
        //System.out.println(cities.get(0).getBank().getClueSize());
//        assertEquals(cities.get(0).getClue(cities.get(1).getBank(),easy), "Pista facil de banco de Mexico");
    }

}

