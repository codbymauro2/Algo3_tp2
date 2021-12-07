package Readers;

import Lists.CitiesList;
import MainObjects.City;
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
    CitiesList citiesList;

    public CityReader(CitiesList citiesList) throws FileNotFoundException {
        json = JsonParser.parseReader(new FileReader("Ciudades.json"));
        gson = new Gson();
        this.citiesList = citiesList;
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
            citiesList.add(city);
        });
    }

    @Override
    public boolean checkFiles(JsonElement json) {
        return json.isJsonNull();
    }
}
