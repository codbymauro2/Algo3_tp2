
import Modelo.Lists.Cities;
import Modelo.Lists.Suspects;
import Modelo.MainObjects.*;
import Modelo.Readers.CityReader;
import Modelo.Readers.SuspectReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

public class TestCoordinates {

    private Police police;
    private Player player;
    private Cities cities;
    private CityReader cityReader;
    private StolenItem stolenItem;
    private PoliceStation policeStation;
    private Suspects suspects;
    private SuspectReader suspectReader;

    @Test
    public void Test01CDistanceBetweenCoordinates()  {
        Coordinates coordinates = new Coordinates(-54.807222,-68.304444); //Ushuaia
        Coordinates otherCoordinates = new Coordinates(-53.783333,-67.7); // Rio Grande

        Assertions.assertEquals(coordinates.distanceKms(otherCoordinates),120);
    }

    @Test
    public void Test02TimeReducedCorrectly() {
        Rookie rookie = new Rookie();
        Detective detective = new Detective();
        Coordinates montrealCoordinates = new Coordinates(45.50, -73.57);
        Coordinates mexicoCoordinates = new Coordinates(19.43, -99.13);
        City montreal = new City("Montreal", montrealCoordinates);
        City mexico = new City("Mexico", mexicoCoordinates);

        rookie.setCurrentCity(montreal);
        rookie.travel(mexico);
        detective.setCurrentCity(montreal);
        detective.travel(mexico);

        double distance = montreal.calculateDistanceTo(mexico);

        Assertions.assertEquals(152 - (distance*900), rookie.getTimeLeftInHours());
        Assertions.assertEquals(152 - (distance*1100), detective.getTimeLeftInHours());
    }

    @Test
    public void Test03PoliceGoesThroughCities() {


        this.player = new Player("Mauro",6);

        Cities cities = new Cities();
        Coordinates coordinates = new Coordinates(19.43, -99.13);
        City lima =  new City("Lima", coordinates);
        City mexico = new City("Mexico", coordinates);
        City montreal = new City("Montreal", coordinates);
        City baghdad = new City("Baghdad", coordinates);
        City beijing = new City("Beijing", coordinates);

        cities.add(lima);
        cities.add(mexico);
        cities.add(montreal);
        cities.add(baghdad);
        cities.add(beijing);

        StolenItem stolenItem = new StolenItem("Incan Gold Mask","Valioso","Lima");
        cities.startCity(stolenItem);
        Assertions.assertEquals(cities.getStartCity(),lima);

        Suspects suspects = new Suspects();
        Suspect suspect = spy(new Suspect("Merey Laroc", new Feature("Female"), new Feature("Mountain Climbing"), new Feature("Brown"),new Feature("Jewelry"),new Feature( "Limousine")));
        suspects.add(suspect);

        cities.setSuspect(suspect);
        suspects.randomSuspect(cities, 5);
        suspects.getRobber().getPath().forEach(c -> {
            System.out.println(c.getName());
        });


    }
}
