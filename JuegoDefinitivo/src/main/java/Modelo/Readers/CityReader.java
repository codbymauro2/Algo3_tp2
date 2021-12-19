package Modelo.Readers;

import Modelo.Lists.Cities;
import Modelo.MainObjects.City;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class CityReader implements Reader {

    JsonElement json;
    Gson gson = new Gson();
    JsonArray jsonArray;
    ArrayList<City> cityList;
    Cities cities;

    public CityReader(Cities cities) throws FileNotFoundException {
        json = JsonParser.parseReader(new FileReader("Ciudades.json"));
        gson = new Gson();
        this.cities = cities;
    }

    public void read() {
        if(!checkFiles(json)){
            storeData();
        }
    }

    @Override
    public void storeData() {
        jsonArray = (JsonArray) json;
        jsonArray.forEach(s -> {
            City city = gson.fromJson(s.getAsJsonObject(), City.class);
            cities.add(city);
        });
    }

    @Override
    public boolean checkFiles(JsonElement json) {
        return json.isJsonNull();
    }
}
