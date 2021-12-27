package Modelo.Readers;

import Modelo.Lists.Players;
import Modelo.MainObjects.Player;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class PlayerReader implements Reader {

    JsonElement json;
    JsonArray jsonArray;
    Gson gson;
    Players players;

    public PlayerReader(Players players) throws FileNotFoundException {
        json = JsonParser.parseReader(new FileReader("Players.json"));
        gson = new Gson();
        this.players = players;
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
            players.add(player);
        });
    }

}
