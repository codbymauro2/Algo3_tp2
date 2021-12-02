import com.google.gson.*;
import java.io.*;
import java.util.ArrayList;

public class StolenItemsReader {

    Object json = JsonParser.parseReader(new FileReader("ObjetosRobados.json"));
    JsonArray jsonArray = (JsonArray) json;
    Gson gson = new Gson();
    ArrayList<StolenItems> stolenItems;

    public StolenItemsReader(ArrayList<StolenItems> stolenItems) throws FileNotFoundException {
        this.stolenItems = stolenItems;
    }

    public void read() {
        jsonArray.forEach( s -> {
            StolenItems objetoRobado = gson.fromJson(s.getAsJsonObject(), StolenItems.class);
            stolenItems.add(objetoRobado);
        });
    }
}

