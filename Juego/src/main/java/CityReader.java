import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class CityReader implements Reader{

    JsonElement json;
    Gson gson = new Gson();
    JsonArray jsonArray;
    ArrayList<City> cityList;

    public CityReader(ArrayList<City> cityList) throws FileNotFoundException {
        json = JsonParser.parseReader(new FileReader("Ciudades.json"));
        if(!checkFiles(json))
            jsonArray = (JsonArray) json;
        this.cityList = cityList;
        this.read();
    }

    public void read() {
        jsonArray.forEach( s -> {
            City city = gson.fromJson(s.getAsJsonObject(), City.class);
            cityList.add(city);
        });
    }

    @Override
    public boolean checkFiles(JsonElement json) {
        return json.isJsonNull();
    }
}
