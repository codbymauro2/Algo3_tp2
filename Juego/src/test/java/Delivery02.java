import Lists.Cities;
import Lists.Suspects;
import MainObjects.*;
import MainObjects.Buildings.Bank;
import Readers.CityReader;
import Readers.SuspectReader;
import org.junit.After;
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
    public void Case01() {
        Rookie detective = new Rookie();
        Knife knife = new Knife();
        Assertions.assertEquals(detective.getTimeLeft(), 152);
        detective.beAttacked(knife);
        Assertions.assertEquals(detective.getTimeLeft(), 150);
        detective.sleep();
        Assertions.assertEquals(detective.getTimeLeft(), 142);
    }

    @Test
    public void Case02() {
        City mexico = new City("Mexico", 19.43, -99.13);
        StolenItem stolenItem = new StolenItem("Tesoro Nacional", "Valioso", "Montreal");
        Investigator investigator = new Investigator();
        City montreal = new City(stolenItem.origin(), 45.50, -73.57);
        investigator.takeCase(montreal);
        Assertions.assertEquals(investigator.isInCity(montreal), true);
        investigator.travel(mexico);
        Assertions.assertEquals(investigator.isInCity(mexico), true);
    }

    @Test
    public void Case03() throws FileNotFoundException {
        Suspects suspects = new Suspects();
        SuspectReader suspectReader = new SuspectReader(suspects);
        suspectReader.read();
        PoliceStation policeStation = spy(new PoliceStation(suspects, planisphere));
        policeStation.obtainFeatures(new String[]{"Female", "", "Brown", "", "Motorcyle"});
        ArrayList<Suspect> possibleSuspects = policeStation.findSuspects();
        Assertions.assertEquals(possibleSuspects.size(), 1);
    }

    @Test
    public void Case04() {
        Suspect suspect = spy(new Suspect("Merey Laroc", "Female", "Mountain Climbing", "Brown", "Jewelry", "Limousine"));
        suspect.convertToRobber();
        Police police = new Detective();
        police.arrest(suspect);
        verify(suspect, times(0)).arrest();
    }

    @Test
    public void Case05() throws FileNotFoundException {

        this.player = new Player("Mauro",0);
        this.police = new Detective();

        Cities cities = new Cities();
        City lima = new City("Lima", 19.43, -99.13);
        City mexico = new City("Mexico", 19.43, -99.13);
        City montreal = new City("Montreal", 19.43, -99.13);
        City baghdad = new City("Baghdad", 19.43, -99.13);
        City beijing = new City("Beijing", 19.43, -99.13);

        cities.add(lima);
        cities.add(mexico);
        cities.add(montreal);
        cities.add(baghdad);
        cities.add(beijing);

        StolenItem stolenItem = new StolenItem("Incan Gold Mask","Valioso","Lima");
        cities.startCity(stolenItem);
        Assertions.assertEquals(cities.getStartCity().getName(),"Lima");

        Suspects suspects = new Suspects();
        Suspect suspect = spy(new Suspect("Merey Laroc", "Female", "Mountain Climbing", "Brown", "Jewelry", "Limousine"));
        suspects.add(suspect);

        Planisphere planisphere = new Planisphere(cities);
        PoliceStation policeStation = new PoliceStation(suspects, planisphere);
        suspect.convertToRobber();

        IntStream.range(0, 6).forEach(i -> {
            this.police = policeStation.assignCase(this.player);
            this.police.emitWarrant(suspect);
            this.police.arrest(suspect);
            player.addFinishedCase(this.police.finishedCases());
        });

        Assertions.assertEquals(police.getClass(),Detective.class);

        this.police = policeStation.assignCase(this.player);
        police.takeCase(cities.find(stolenItem.origin()));

        City nextCity = police.getCurrentCity();
        Bank bank = new Bank();
        police.enter(bank); 
    }

    @After
    public void setUp() throws FileNotFoundException {
        this.player = new Player("Mauro",6);
        this.cities = new Cities();
        this.cityReader = new CityReader(cities);
        this.cityReader.read();
        this.stolenItem = new StolenItem("Incan Gold Mask","Valioso","Lima");
        this.cities.startCity(stolenItem);
        this.planisphere = new Planisphere(cities);
        this.suspects = new Suspects();
        this.suspectReader = new SuspectReader(suspects);
        this.suspectReader.read();
        this.policeStation = new PoliceStation(suspects, planisphere);
        this.police = policeStation.assignCase(this.player);
    }

    @Test
    public void Case06() {






    }



}


