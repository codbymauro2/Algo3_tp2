import com.google.gson.*;
import java.io.*;
import java.util.ArrayList;

public class StolenItemsReader implements Reader{

    JsonElement json;
    JsonArray jsonArray;
    Gson gson;
    ArrayList<StolenItems> stolenItems;

    public StolenItemsReader(ArrayList<StolenItems> stolenItems) throws FileNotFoundException {
        json = JsonParser.parseReader(new FileReader("ObjetosRobados.json"));
        gson = new Gson();
        this.stolenItems = stolenItems;
        if(!checkFiles(json))
            jsonArray = (JsonArray) json;
    }

    public void read() {
        jsonArray.forEach( s -> {
            StolenItems stolenItem = gson.fromJson(s.getAsJsonObject(), StolenItems.class);
            stolenItems.add(stolenItem);
        });
    }

    @Override
    public boolean checkFiles(JsonElement json) {
        return json.isJsonNull();
    }
}

