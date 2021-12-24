import Modelo.Lists.Cities;
import Modelo.Lists.Suspects;
import Modelo.MainObjects.*;
import Modelo.MainObjects.Buildings.Bank;
import Modelo.MainObjects.Buildings.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.stream.IntStream;

import static org.mockito.Mockito.*;

public class Delivery01 {

    @Test
    public void Case01RookieVisitsBankInMontreal() throws IOException {
        Coordinates coordinates = new Coordinates(45.50, -73.57);
        City montreal = new City("Montreal", coordinates);
        Suspects suspects = new Suspects();
        Suspect suspect = new Suspect("Merey Laroc",new Feature("Female"),new Feature("Mountain Climbing"),new Feature("Brown"),new Feature("Jewelry"),new Feature("Limousine"));
        suspects.add(suspect);
        Clue clue = new Clue("Pista Banco Facil","Pista Banco Facil","Pista Banco Facil");
        Rookie rookie = new Rookie();
        Bank bank = new Bank(clue);
        Cities cities = new Cities();
        cities.add(montreal);
        StolenItem stolenItem = new StolenItem("Tesoro Nacional Montreal","Comun","Montreal");
        cities.startCity(stolenItem);
        suspects.randomSuspect(cities, 5);
        rookie.takeCase(montreal);
        montreal.setSuspect(suspect);
        rookie.travel(montreal);
        Assertions.assertTrue(suspect.isGender(new Feature("Female")));
        Assertions.assertEquals(stolenItem.getName(),"Tesoro Nacional Montreal");
        Assertions.assertEquals(rookie.enter(bank),"Pista Banco Facil");
    }

    @Test
    public void Case02DetectiveVisitsBankAndLibraryInMontreal() throws IOException {
        Police detective = new Detective();
        Clue clueBank = new Clue("Pista Banco Facil","Pista Banco Media","Pista Banco Dificil");
        Clue clueLibrary = new Clue("Pista Libreria Facil","Pista Libreria Media","Pista Libreria Dificil");
        Bank bank = new Bank(clueBank);
        Library library = new Library(clueLibrary);
        Coordinates coordinates = new Coordinates(45.50, -73.57);
        City montreal = new City("Montreal", coordinates);
        Cities cities = new Cities();
        cities.add(montreal);
        StolenItem stolenItem = new StolenItem("Tesoro Nacional Montreal","Comun","Montreal");
        cities.startCity(stolenItem);
        detective.takeCase(cities.find(stolenItem.origin()));
        Assertions.assertEquals(detective.getCurrentCity(),montreal);
        Assertions.assertEquals(detective.enter(bank),"Pista Banco Media");
        Assertions.assertEquals(detective.enter(library),"Pista Libreria Media");
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
        Detective detective = new Detective();
        Clue clueAirport = new Clue("Pista Aeropuerto Facil","Pista Aeropuerto Media","Pista Aeropuerto Dificil");
        Clue cluePort = new Clue("Pista Puerto Facil","Pista Puerto Media","Pista Puerto Dificil");
        Bank spyAirport = spy(new Bank(clueAirport));
        Library spyPort = spy(new Library(cluePort));
        IntStream.range(0, 5).forEach(i -> {
            detective.enter(spyAirport);
        });
        IntStream.range(0, 55).forEach(i -> {
            detective.enter(spyPort);
        });
        verify(spyAirport,times(5)).deployClue(any(Detective.class));
        verify(spyPort,times(55)).deployClue(any(Detective.class));
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


