import Modelo.Lists.Cities;
import Modelo.Lists.Suspects;
import Modelo.MainObjects.*;
import Modelo.MainObjects.Buildings.Airport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.spy;

public class TestCitiesToShow {


    public Cities cityBuilder() {
        Cities cities = new Cities();
        Coordinates coordinates = new Coordinates(45.50, -73.57);
        cities.add(new City("Mexico", coordinates));
        cities.add(new City("Montreal", coordinates));
        cities.add(new City("Baghdad", coordinates));
        cities.add(new City("Beijing", coordinates));
        cities.add(new City("Athens", coordinates));
        cities.add(new City("Montevideo", coordinates));
        cities.add(new City("NewDelhi", coordinates));
        cities.add(new City("Dublin", coordinates));
        return cities;
    }

    public Suspect setGame(Cities cities) {
        StolenItem stolenItem = new StolenItem("Incan Gold Mask", "Valioso", "Lima");
        cities.startCity(stolenItem);
        Suspects suspects = new Suspects();
        Suspect suspect = spy(new Suspect("Merey Laroc", new Feature("Female"), new Feature("Mountain Climbing"), new Feature("Brown"), new Feature("Jewelry"), new Feature("Limousine")));
        suspects.add(suspect);
        cities.setSuspect(suspect);
        suspects.randomSuspect(cities, 3);
        return suspect;
    }

    @Test
    public void Test01ShowCitiesFromOrigin() {
        Cities cities = cityBuilder();
        City lima = new City("Lima", new Coordinates(45.50, -73.57));
        cities.add(lima);
        Suspect suspect = setGame(cities);
        Detective detective = new Detective();
        detective.setCurrentCity(lima);
        cities.setPossibleCities(detective);
        ArrayList<City> possibleCities = detective.getConnections();

        possibleCities.forEach(c -> {
            Assertions.assertNotEquals(c, lima);
        });

        Assertions.assertTrue(possibleCities.contains(suspect.getPath().get(1)));
        Assertions.assertFalse(suspect.getPath().contains(possibleCities.get(1)));
        Assertions.assertFalse(suspect.getPath().contains(possibleCities.get(2)));
        Assertions.assertFalse(suspect.getPath().contains(possibleCities.get(3)));
    }

    @Test
    public void Test02ShowCitiesFromCorrectCity() {
        Cities cities = cityBuilder();
        City lima = new City("Lima", new Coordinates(45.50, -73.57));
        cities.add(lima);
        Suspect suspect = setGame(cities);
        Detective detective = new Detective();
        detective.setCurrentCity(lima);
        City nextCity = suspect.getPath().get(1);
        detective.travel(nextCity);
        cities.setPossibleCities(detective);
        ArrayList<City> possibleCities = detective.getConnections();

        Assertions.assertTrue(possibleCities.contains(lima));
        Assertions.assertFalse(possibleCities.contains(nextCity));
        Assertions.assertTrue(possibleCities.contains(suspect.getPath().get(2)));
    }


    @Test
    public void Test03ShowCitiesFromIncorrectCity() {
        Cities cities = cityBuilder();
        City lima = new City("Lima", new Coordinates(45.50, -73.57));
        cities.add(lima);
        Suspect suspect = setGame(cities);
        Detective detective = new Detective();
        detective.setCurrentCity(lima);
        detective.travel(cities.get(0));
        detective.travel(cities.get(1));
        cities.setPossibleCities(detective);
        ArrayList<City> possibleCities = detective.getConnections();

        possibleCities.forEach(c -> {
            Assertions.assertFalse(suspect.getPath().contains(c));
        });
     }

    @Test
    public void Test04GetConnectionsTwiceShowsSameCities() {
        Cities cities = cityBuilder();
        City lima = new City("Lima", new Coordinates(45.50, -73.57));
        cities.add(lima);
        Suspect suspect = setGame(cities);
        Detective detective = new Detective();
        detective.setCurrentCity(lima);
        cities.setPossibleCities(detective);
        ArrayList<City> possibleCities1 = detective.getConnections();
        cities.setPossibleCities(detective);
        ArrayList<City> possibleCities2 = detective.getConnections();

        for (int i = 0; i < possibleCities1.size(); i++) {
            Assertions.assertEquals(possibleCities1.get(i), possibleCities2.get(i));
        }
    }

    @Test
    public void Test04() {
        Cities cities = cityBuilder();
        City lima = new City("Lima", new Coordinates(45.50, -73.57));
        Clue clueAirport = new Clue("Pista Aeropuerto Facil","Pista Aeropuerto Media","Pista Aeropuerto Dificil");
        Airport airport = new Airport(clueAirport);
        cities.add(lima);
        Suspect suspect = setGame(cities);
        lima.getNextCity().setAirport(airport);
        Detective detective = new Detective();
        detective.setCurrentCity(lima);
        //para peti
        //String pista = detective.enter(detective.getCurrentCity().getAirport());
        //Assertions.assertEquals(pista, "Pista Aeropuerto Media");
    }

}