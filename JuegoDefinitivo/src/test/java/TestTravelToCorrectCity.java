import Modelo.Lists.Cities;
import Modelo.Lists.Suspects;
import Modelo.MainObjects.*;
import Modelo.Readers.CityReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.mockito.Mockito.spy;

public class TestTravelToCorrectCity {
    @Test
    public void DetectiveTravelToCorrectAndInCorrectCitiesInRealSimulationGame() throws FileNotFoundException {
        Player player = new Player("Agustin",0);

        Cities cities = new Cities();
        CityReader cityReader = new CityReader(cities);
        cityReader.read();

        //System.out.println(cities.find("Lima").getName());

        StolenItem stolenItem = new StolenItem("Incan Gold Mask","Comun","Lima");
        cities.startCity(stolenItem);

        Suspects suspects = new Suspects();
        Suspect suspect = spy(new Suspect("Merey Laroc", new Feature("Female"), new Feature("Mountain Climbing"), new Feature("Brown"), new Feature("Jewelry"), new Feature("Limousine")));
        suspects.add(suspect);

        cities.setSuspect(suspect);
        //el random es el setea a las ciudades por las que paso el robber la ciudad siguiente por la que paso
        suspects.randomSuspect(cities, 5);

        PoliceStation policeStation = new PoliceStation(suspects, cities);

        Police police = policeStation.assignRange(player);

        //se le setea porque siempre empieza en la ciudad en la cual se robo el objeto
        police.setCurrentCity(cities.find(stolenItem.origin()));

        cities.setPossibleCities(police);
        ArrayList<City> travelCities = police.getConnections();
        //1: ciudad anterior, 2: ciudad siguiente/random, 3: random, 4: random
        police.travel(travelCities.get(0));

        //String pista = police.enter(police.getCurrentCity().getNextCity().getAirport());

        //Assertions.assertEquals(pista, "Pista facil del aeropuerto"+ police.getCurrentCity().getNextCity().getName());

        //cities.setPossibleCities(police);
        //ArrayList<City> travelCities2 = police.getConnections();


    }
}
