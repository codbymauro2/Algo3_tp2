import Lists.Cities;
import Lists.Suspects;
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

    @Test
    public void Case01() {
        Rookie detective = new Rookie();
        Knife knife = new Knife();
        Assertions.assertEquals(detective.getTimeLeft(),176);
        detective.beAttacked(knife);
        Assertions.assertEquals(detective.getTimeLeft(),174);
        detective.sleep();
        Assertions.assertEquals(detective.getTimeLeft(),166);
    }

    @Test
    public void Case02() {
        City mexico = new City("Mexico",19.43,-99.13);
        StolenItem stolenItem = new StolenItem("Tesoro Nacional","Valioso","Montreal");
        Investigator investigator = new Investigator();
        City montreal = new City(stolenItem.origin(),45.50, -73.57);
        investigator.takeCase(montreal);
        Assertions.assertEquals(investigator.isInCity(montreal),true);
        investigator.travel(mexico);
        Assertions.assertEquals(investigator.isInCity(mexico),true);
    }

    @Test
    public void Case03() throws FileNotFoundException {
        Suspects suspects = new Suspects();
        SuspectReader suspectReader = new SuspectReader(suspects);
        suspectReader.read();
        PoliceStation policeStation = spy(new PoliceStation(suspects));
        policeStation.obtainFeatures(new String[]{"Female", "", "Brown", "", "Motorcyle"});
        ArrayList<Suspect> possibleSuspects = policeStation.findSuspects();
        Assertions.assertEquals(possibleSuspects.size(),1);
    }

    @Test
    public void Case04() {
        Suspect suspect = spy(new Suspect("Merey Laroc", "Female", "Mountain Climbing", "Brown", "Jewelry", "Limousine"));
        suspect.convertToRobber();
        Police police = new Detective();
        police.arrest(suspect);
        verify(suspect,times(0)).arrest();
    }

    @Test
    public void Case05() throws FileNotFoundException {
        Suspect suspect = spy(new Suspect("Merey Laroc", "Female", "Mountain Climbing", "Brown", "Jewelry", "Limousine"));
        Police police = new Detective();
        suspect.convertToRobber();
        police.emitWarrant(suspect);
        for(int i=0;i<=5;i++) police.arrest(suspect);
        verify(suspect,times(6)).arrest();

        PoliceStation policeStation = new PoliceStation(new Suspects());
        police = policeStation.assignCase(police, police.casesWon());

        StolenItem stolenItem = new StolenItem("Incan Gold Mask", "Valioso", "Lima");
        Cities cities = new Cities();
        CityReader cityReader = new CityReader(cities);
        cityReader.read();
        City currentCity = cities.find(stolenItem.origin());
        Planisphere map = new Planisphere(cities,stolenItem);
        City nextCity = currentCity.getNextCity();
        System.out.println(nextCity.getName());
    }
    
}
