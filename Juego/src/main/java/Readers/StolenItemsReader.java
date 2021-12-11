package Readers;

import Lists.StolenItemsList;
import MainObjects.Player;
import MainObjects.StolenItems;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class StolenItemsReader implements Reader {

    JsonElement json;
    JsonArray jsonArray;
    Gson gson;
    StolenItemsList stolenItems;

    public StolenItemsReader(StolenItemsList stolenItems) throws FileNotFoundException {
        json = JsonParser.parseReader(new FileReader("ObjetosRobados.json"));
        gson = new Gson();
        this.stolenItems = stolenItems;
    }

    @Override
    public void read() {
        if(!checkFiles(json)){
            storeData();
        }
    }

    @Override
    public boolean checkFiles(JsonElement json) {
        return json.isJsonNull();
    }

    public void storeData(){
        jsonArray = (JsonArray) json;
        jsonArray.forEach(s -> {
            StolenItems stolenItem = gson.fromJson(s.getAsJsonObject(), StolenItems.class);
            stolenItems.add(stolenItem);
        });
    }

}


