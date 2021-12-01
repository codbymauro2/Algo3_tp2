import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class LectorCiudades {

    Object json = JsonParser.parseReader(new FileReader("Ciudades.json"));
    JsonArray jsonArray = (JsonArray) json;
    Gson gson = new Gson();
    ArrayList<Ciudad> cityList = new ArrayList<Ciudad>();

    public LectorCiudades() throws FileNotFoundException {
    }

    public void leer() {
        jsonArray.forEach( s -> {
            Ciudad city = gson.fromJson(s.getAsJsonObject(),Ciudad.class);
            cityList.add(city);
        });

        System.out.println(cityList.get(0).getName());
    }
}
