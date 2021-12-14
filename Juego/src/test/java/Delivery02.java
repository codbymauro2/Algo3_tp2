import Lists.Cities;
import Lists.Suspects;
import MainObjects.*;
import MainObjects.Buildings.Bank;
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
        PoliceStation policeStation = spy(new PoliceStation(suspects));
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

        this.player = new Player("Mauro",6);
        this.police = new Detective();
        Cities cities = new Cities();
        StolenItem stolenItem = new StolenItem("Incan Gold Mask","Valioso","Lima");
        cities.add(new City("Lima",17,18));
        Suspect suspect = spy(new Suspect("Merey Laroc", "Female", "Mountain Climbing", "Brown", "Jewelry", "Limousine"));
        Suspects suspects = new Suspects();
        PoliceStation policeStation = new PoliceStation(suspects);


        suspect.convertToRobber();

        IntStream.range(0, 6).forEach(i -> {
            this.police = policeStation.assignCase(this.player);
            this.police.emitWarrant(suspect);
            this.police.arrest(suspect);
            player.addFinishedCase(this.police.finishedCases());
        });


        Assertions.assertEquals(police.getClass(),Investigator.class);

        suspects.add(suspect);
        this.police = policeStation.assignCase(this.player);
        police.takeCase(cities.find(stolenItem.origin()));



    }

}


