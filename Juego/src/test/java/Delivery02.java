import Lists.Cities;
import Lists.Suspects;
import MainObjects.Buildings.Bank;
import MainObjects.Buildings.Library;
import MainObjects.*;
import Readers.CityReader;
import Readers.SuspectReader;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.stream.IntStream;

import static org.mockito.Mockito.*;

public class Delivery02 {

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
    public void Case01DetectiveIsStabbedAndSleeps() {
        Rookie detective = new Rookie();
        Knife knife = new Knife();
        Assertions.assertEquals(detective.getTimeLeftInHours(), 152);
        detective.beAttacked(knife);
        Assertions.assertEquals(detective.getTimeLeftInHours(), 150);
        detective.sleep();
        Assertions.assertEquals(detective.getTimeLeftInHours(), 142);
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
        SuspectReader suspectReader = new SuspectReader(suspects);
        suspectReader.read();
        PoliceStation policeStation = spy(new PoliceStation(suspects, planisphere));
        policeStation.obtainFeatures(new String[]{"Female", "", "Brown", "", "Motorcycle"});
        ArrayList<Suspect> possibleSuspects = policeStation.findSuspects();
        Assertions.assertEquals(possibleSuspects.size(), 1);
    }

    @Test
    public void Case04ArrestMadeWithoutWarrantShouldFail() {
        Suspect suspect = spy(new Suspect("Merey Laroc", "Female", "Mountain Climbing", "Brown", "Jewelry", "Limousine"));
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
        Suspect suspect = spy(new Suspect("Merey Laroc", "Female", "Mountain Climbing", "Brown", "Jewelry", "Limousine"));
        suspects.add(suspect);

        cities.setSuspect(suspect);
        suspects.randomSuspect();

        Planisphere planisphere = new Planisphere(cities);
        PoliceStation policeStation = new PoliceStation(suspects, planisphere);

        IntStream.range(0, 6).forEach(i -> {
            this.police = policeStation.assignCase(this.player);
            this.police.investigate(new String[]{"Female", "", "Brown", "", "Limousine"});
            this.police.arrest(suspects.getRobber());
            player.addFinishedCase(this.police.finishedCases());
        });

        Assertions.assertEquals(12,player.totalCasesWon());
        Assertions.assertNotEquals(Detective.class,police.getClass());
        this.police = policeStation.assignCase(this.player);
        police.takeCase(cities.find(stolenItem.origin()));

        Clue clueLimaBank = new Clue("Pista de banco facil", "Pista de banco media", "Pista de banco dificil");
        Bank bankLima = new Bank(clueLimaBank);
        police.enter(bankLima);
        //El policia deduce las pistas y viaja a la siguiente ciudad correctamente

        police.travel(planisphere.getCity("Mexico"));

        Clue clueMexicoLibrary = new Clue("Pista de library facil", "Pista de library media", "Pista de library dificil");
        Library libraryMexico = new Library(clueMexicoLibrary);
        police.enter(libraryMexico);
        //El policia deduce las pistas y viaja a la siguiente ciudad correctamente

        police.investigate(new String[]{"Female", "", "Brown", "", "Limousine"});

        police.arrest(suspect);
        player.addFinishedCase(police.finishedCases());

        Assertions.assertEquals(13,player.totalCasesWon());
    }





}


