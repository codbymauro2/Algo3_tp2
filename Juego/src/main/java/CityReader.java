import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class CityReader {

    Object json = JsonParser.parseReader(new FileReader("Ciudades.json"));
    JsonArray jsonArray = (JsonArray) json;
    Gson gson = new Gson();
    ArrayList<City> cityList;

    public CityReader(ArrayList<City> cityList) throws FileNotFoundException {
        this.cityList = cityList;
    }

    public void read() {
        jsonArray.forEach( s -> {
            City city = gson.fromJson(s.getAsJsonObject(), City.class);
            cityList.add(city);
        });
    }
}
