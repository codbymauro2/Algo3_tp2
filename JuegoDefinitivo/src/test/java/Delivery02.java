
import Modelo.Lists.StolenItems;
import Modelo.Lists.Cities;
import Modelo.Lists.Suspects;
import Modelo.MainObjects.*;
import Modelo.MainObjects.Buildings.Bank;
import Modelo.Readers.CityReader;
import Modelo.Readers.SuspectReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.stream.IntStream;

import static org.mockito.Mockito.*;


public class Delivery02 {
    private Police police;
    private Player player;
    private Cities cities;
    private CityReader cityReader;
    private StolenItem stolenItem;
    private PoliceStation policeStation;
    private Suspects suspects;
    private SuspectReader suspectReader;
    private StolenItems stolenItems;

    @Test
    public void Case01DetectiveIsStabbedAndSleeps() {
        Police detective = new Rookie();
        Knife knife = new Knife();
        Assertions.assertEquals(detective.getTimeLeftInHours(), 152);
        detective.beAttacked(knife);
        Assertions.assertEquals(detective.getTimeLeftInHours(), 150);
        detective.sleep();
        Assertions.assertEquals(detective.getTimeLeftInHours(), 142);
        detective.beAttacked(knife);
        Assertions.assertEquals(detective.getTimeLeftInHours(), 141);

    }

    @Test
    public void Case02InvestigatorTakesCaseAndTravelsFromMontrealToMexico() {
        Coordinates mexicoCoordinates = new Coordinates(19.43, -99.13);
        City mexico = new City("Mexico",mexicoCoordinates);
        StolenItem stolenItem = new StolenItem("Tesoro Nacional", "Valioso", "Montreal");
        Investigator investigator = new Investigator();
        Coordinates montrealCoordinates = new Coordinates(45.50, -73.57);
        City montreal = new City(stolenItem.origin(), montrealCoordinates);
        investigator.takeCase(montreal);
        Assertions.assertTrue(investigator.isInCity(montreal));
        investigator.travel(mexico);
        Assertions.assertTrue(investigator.isInCity(mexico));
    }

    @Test
    public void Case03SuspectsFilteredByClues() throws FileNotFoundException {
        Suspects suspects = new Suspects();
        Suspect suspect = spy(new Suspect("Merey Laroc", new Feature("Female"), new Feature("Mountain Climbing"),new Feature("Brown"), new Feature("Jewelry"), new Feature("Limousine")));
        suspects.add(suspect);
        cities = new Cities();
        CityReader cityReader = new CityReader(cities);
        cityReader.read();
        stolenItems = new StolenItems();
        stolenItems.add(new StolenItem("Nombre","valor","Mexico"));
        PoliceStation policeStation = spy(new PoliceStation(suspects,cities));
        policeStation.obtainFeatures(new Feature("Female"),new Feature(""),new Feature("Brown"),new Feature(""), new Feature("Limousine"));
        ArrayList<Suspect> possibleSuspects = policeStation.findSuspects();
        Assertions.assertEquals(possibleSuspects.size(), 1);
    }

    @Test
    public void Case04ArrestMadeWithoutWarrantShouldFail() {
        Suspect suspect = spy(new Suspect("Merey Laroc", new Feature("Female"), new Feature("Mountain Climbing"),new Feature("Brown"), new Feature("Jewelry"), new Feature("Limousine")));
        suspect.convertToRobber();
        Police police = new Detective();
        police.arrest(suspect);
        verify(suspect, times(0)).arrest();
    }

    @Test
    public void Case05DetectiveWithSixArrestsInvestigatesAndCatchesTheif() throws FileNotFoundException {

        this.player = new Player("Mauro",6);

        Cities cities = new Cities();
        Coordinates coordinates = new Coordinates(45.50, -73.57);
        City lima = new City("Lima", coordinates);
        City mexico = new City("Mexico", coordinates);
        City montreal = new City("Montreal", coordinates);
        City baghdad = new City("Baghdad",coordinates);
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
        Suspect suspect = spy(new Suspect("Merey Laroc", new Feature("Female"), new Feature("Mountain Climbing"), new Feature("Brown"), new Feature("Jewelry"), new Feature("Limousine")));
        suspects.add(suspect);

        cities.setSuspect(suspect);
        suspects.randomSuspect(cities, 5);

        PoliceStation policeStation = new PoliceStation(suspects, cities);

        IntStream.range(0, 6).forEach(i -> {
            this.police = policeStation.assignRange(this.player);
            City endCity = suspect.getPath().get(suspect.getPath().size() - 1);
            this.police.setCurrentCity(endCity);
            this.police.travel(endCity);
            this.police.investigate(new Feature("Female"),new Feature(""),new Feature("Brown"),new Feature(""),new Feature("Limousine"));
            this.police.arrest(suspects.getRobber());
            player.addFinishedCase(this.police.finishedCases());
        });

        Assertions.assertEquals(12,player.totalCasesWon());
        Assertions.assertNotEquals(Detective.class,police.getClass());

        cities.add(lima);
        cities.add(mexico);
        cities.add(montreal);
        cities.add(baghdad);
        cities.add(beijing);

        this.police = policeStation.assignRange(this.player);
        police.setCurrentCity(cities.find(stolenItem.origin()));
        police.travel(lima);

        for (int i = 0; i < 5; i++) {
            Clue clueBank = new Clue("Pista de banco facil", "Pista de banco media", "Pista de banco dificil");
            Bank bank = new Bank(clueBank);
            police.enter(bank);
            City nextCity = suspect.getPath().get(i);
            police.travel(nextCity);
            //El policia deduce las pistas y viaja a la siguiente ciudad correctamente
        }

        police.investigate(new Feature("Female"), new Feature(""), new Feature("Brown"), new Feature(""), new Feature("Limousine"));
        police.arrest(suspect);
        player.addFinishedCase(police.finishedCases());

        Assertions.assertEquals(13,player.totalCasesWon());
    }





}
