import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class LectorSospechosos {

    Object json = JsonParser.parseReader(new FileReader("Sospechosos.json"));
    JsonArray jsonArray = (JsonArray) json;
    Gson gson = new Gson();
    ArrayList<Sospechoso> suspectList = new ArrayList<Sospechoso>();

    public LectorSospechosos() throws FileNotFoundException {
    }

    public void leer(){
        jsonArray.forEach( s -> {
            Sospechoso suspect = gson.fromJson(s.getAsJsonObject(),Sospechoso.class);
            suspectList.add(suspect);
        });

        suspectList.get(0).printSospechoso();


    }
}
