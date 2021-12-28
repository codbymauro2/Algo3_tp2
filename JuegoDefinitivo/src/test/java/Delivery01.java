import Modelo.Lists.Cities;
import Modelo.Lists.Suspects;
import Modelo.MainObjects.*;
import Modelo.MainObjects.Buildings.Airport;
import Modelo.MainObjects.Buildings.Bank;
import Modelo.MainObjects.Buildings.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.IntStream;

import static org.mockito.Mockito.*;

public class Delivery01 {

    @Test
    public void Case01RookieVisitsBankInMontreal() throws IOException {
        Clue clueBank = new Clue("Pista Banco Facil","Pista Banco Media","Pista Banco Dificil");
        Bank bank = new Bank(clueBank);

        Cities cities = new Cities();
        City montreal = new City("Montreal", new Coordinates(45.50, -73.57));
        cities.add(montreal);
        City mexico = new City("Mexico", new Coordinates(45.50, -73.57));
        cities.add(mexico);
        StolenItem stolenItem = new StolenItem("Tesoro Nacional Montreal","Comun","Montreal");
        cities.startCity(stolenItem);

        Suspects suspects = new Suspects();
        Suspect suspect = spy(new Suspect("Merey Laroc", new Feature("Female"), new Feature("Mountain Climbing"), new Feature("Brown"), new Feature("Jewelry"), new Feature("Limousine")));
        suspects.add(suspect);
        cities.setSuspect(suspect);
        suspects.randomSuspect(cities, 5);

        PoliceStation policeStation = new PoliceStation(suspects);
        policeStation.setSuspect();

        Rookie rookie = new Rookie(policeStation);
        rookie.takeCase(cities.find(stolenItem.origin()));
        rookie.setCurrentCity(montreal);
        rookie.getCurrentCity().getNextCity().setBank(bank);

        Assertions.assertEquals(rookie.getCurrentCity().getName(), montreal.getName());
        Assertions.assertTrue(rookie.enter(bank).contains("Pista Banco Facil."));
    }

    @Test
    public void Case02DetectiveVisitsBankAndLibraryInMontreal() throws IOException {
        Clue clueBank = new Clue("Pista Banco Facil","Pista Banco Media","Pista Banco Dificil");
        Clue clueLibrary = new Clue("Pista Libreria Facil","Pista Libreria Media","Pista Libreria Dificil");
        Bank bank = new Bank(clueBank);
        Library library = new Library(clueLibrary);

        Cities cities = new Cities();
        City montreal = new City("Montreal", new Coordinates(45.50, -73.57));
        cities.add(montreal);
        City mexico = new City("Mexico", new Coordinates(45.50, -73.57));
        cities.add(mexico);
        StolenItem stolenItem = new StolenItem("Tesoro Nacional Montreal","Comun","Montreal");
        cities.startCity(stolenItem);

        Suspects suspects = new Suspects();
        Suspect suspect = spy(new Suspect("Merey Laroc", new Feature("Female"), new Feature("Mountain Climbing"), new Feature("Brown"), new Feature("Jewelry"), new Feature("Limousine")));
        suspects.add(suspect);
        cities.setSuspect(suspect);
        suspects.randomSuspect(cities, 5);

        PoliceStation policeStation = new PoliceStation(suspects);
        policeStation.setSuspect();

        Detective detective = new Detective(policeStation);
        detective.takeCase(cities.find(stolenItem.origin()));
        detective.setCurrentCity(montreal);
        detective.getCurrentCity().getNextCity().setBank(bank);
        detective.getCurrentCity().getNextCity().setLibrary(library);

        Assertions.assertEquals(detective.getCurrentCity().getName(), montreal.getName());
        Assertions.assertTrue(detective.enter(bank).contains("Pista Banco Media."));
        Assertions.assertTrue(detective.enter(library).contains("Pista Libreria Media."));
    }

    @Test
    public void Case03DetectiveTravelsFromMontrealToMexico() throws IOException {
        Detective detective = new Detective();
        Coordinates coordinates = new Coordinates(45.50, -73.57);
        City montreal = new City("Montreal", coordinates);
        City mexico = new City("Mexico", coordinates);
        detective.setCurrentCity(montreal);
        Assertions.assertNotEquals(detective.getCurrentCity(),mexico);
        detective.travel(mexico);
        Assertions.assertEquals(detective.getCurrentCity(),mexico);
    }

    @Test
    public void Case04DetectiveVisitsAirportAndPortMultipleTimes() {
        Clue clueAirport = new Clue("Pista Banco Facil","Pista Banco Media","Pista Banco Dificil");
        Clue cluePort = new Clue("Pista Libreria Facil","Pista Libreria Media","Pista Libreria Dificil");
        Airport airport = new Airport(clueAirport);
        Library port = new Library(cluePort);

        Cities cities = new Cities();
        City montreal = new City("Montreal", new Coordinates(45.50, -73.57));
        cities.add(montreal);
        City mexico = new City("Mexico", new Coordinates(45.50, -73.57));
        cities.add(mexico);
        StolenItem stolenItem = new StolenItem("Tesoro Nacional Montreal","Comun","Montreal");
        cities.startCity(stolenItem);

        Suspects suspects = new Suspects();
        Suspect suspect = spy(new Suspect("Merey Laroc", new Feature("Female"), new Feature("Mountain Climbing"), new Feature("Brown"), new Feature("Jewelry"), new Feature("Limousine")));
        suspects.add(suspect);
        cities.setSuspect(suspect);
        suspects.randomSuspect(cities, 5);

        PoliceStation policeStation = new PoliceStation(suspects);
        policeStation.setSuspect();

        Detective detective = new Detective(policeStation);
        detective.takeCase(cities.find(stolenItem.origin()));
        detective.setCurrentCity(montreal);
        detective.getCurrentCity().getNextCity().setAirport(airport);
        detective.getCurrentCity().getNextCity().setLibrary(port);

        ArrayList<String> airportClues = new ArrayList<>();
        ArrayList<String> portClues = new ArrayList<>();

        IntStream.range(0, 5).forEach(i -> {
            airportClues.add(detective.enter(airport));
        });
        IntStream.range(0, 55).forEach(i -> {
            portClues.add(detective.enter(port));
        });

        Assertions.assertEquals(5, airportClues.size());
        Assertions.assertEquals(55, portClues.size());
    }

    @Test
    public void Case05DetectiveIsStabbedAndSleeps() {
        Detective detective = new Detective();
        Knife knife = new Knife();
        Assertions.assertEquals(detective.getTimeLeftInHours(),152);
        detective.beAttacked(knife);
        Assertions.assertEquals(detective.getTimeLeftInHours(),150);
        detective.sleep();
        Assertions.assertEquals(detective.getTimeLeftInHours(),142);
    }

}


