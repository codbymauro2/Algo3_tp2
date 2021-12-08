package Readers;

import MainObjects.Player;
import Lists.PlayersList;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;


public class PlayerReader implements Reader {

    JsonElement json;
    JsonArray jsonArray;
    Gson gson;
    PlayersList playersList;

    public PlayerReader(PlayersList playersList) throws FileNotFoundException {
        json = JsonParser.parseReader(new FileReader("Players.json"));
        gson = new Gson();
        this.playersList = playersList;
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
            Player player = gson.fromJson(s.getAsJsonObject(), Player.class);
            playersList.add(player);
        });
    }

}
