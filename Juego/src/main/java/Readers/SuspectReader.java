package Readers;

import Lists.Suspects;
import MainObjects.Suspect;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class SuspectReader implements Reader {

    JsonElement json;
    JsonArray jsonArray;
    Gson gson;
    Suspects suspectList;

    public SuspectReader(Suspects suspectList) throws FileNotFoundException {
        json = JsonParser.parseReader(new FileReader("Sospechosos.json"));
        this.suspectList = suspectList;
        gson = new Gson();
        if(!checkFiles(json)){
            jsonArray = (JsonArray) json;
        }
    }

    public void read(){
        jsonArray.forEach( s -> {
            Suspect suspect = gson.fromJson(s.getAsJsonObject(), Suspect.class);
            suspectList.add(suspect);
        });
    }

    @Override
    public void storeData() {

    }

    @Override
    public boolean checkFiles(JsonElement json) {
        return json.isJsonNull();
    }
}
