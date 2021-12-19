
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
    private Planisphere planisphere;
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

        assertEquals(coordinates.distance(otherCoordinates),120);
    }

    public void TestPoliceGoesThroughCities() {


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
        assertEquals(cities.getStartCity(),lima);

        Suspects suspects = new Suspects();
        Suspect suspect = spy(new Suspect("Merey Laroc", "Female", "Mountain Climbing", "Brown", "Jewelry", "Limousine"));
        suspects.add(suspect);

        cities.setSuspect(suspect);
        suspects.randomSuspect();



    }
}
