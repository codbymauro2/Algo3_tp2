import Lists.Suspects;
import MainObjects.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.Answer1;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
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
    public void Case03() {
        City mexico = new City("Mexico",19.43,-99.13);
        StolenItem stolenItem = new StolenItem("Tesoro Nacional","Valioso","Montreal");
        Suspect mereyLaroc = new Suspect("Merey Laroc", "Female", "Mountain Climbing", "Brown", "Jewelry", "Limousine");
        Suspect nickBrunch = new Suspect("Nick Brunch","Male", "Prestamos del FMI", "Blond", "Ring", "Motorcycle");
        Suspect mauricioMacri = new Suspect("Mauricio Macri", "Male", "Prestamos del FMI", "Black", "Ring", "Motorcycle");
        Suspect cristinaFernandez = new Suspect("Cristina Fernandez","Female","Prestamos del FMI","Red","Tattoo","Car");
        Suspect albertoFernandez = new Suspect("Alberto Fernandez", "Male", "Mountain Climbing","Brown", "Tattoo", "Motorcycle");
        Suspect mamaDePeti = new Suspect("MamaDePeti","Female","Mountain Climbing","Red","Tatto","Motorcycle");
        Suspects suspects = new Suspects();
        suspects.add(mereyLaroc);
        suspects.add(nickBrunch);
        suspects.add(mauricioMacri);
        suspects.add(albertoFernandez);
        suspects.add(cristinaFernandez);
        suspects.add(mamaDePeti);
        PoliceStation policeStation = spy(new PoliceStation(suspects));
        Investigator investigator = new Investigator();
        investigator.takeCase(mexico);
        ArrayList<String> features = new ArrayList<>();
        features.add("Male");
        features.add("");
        features.add("Black");
        features.add("");
        features.add("");
        investigator.giveFeatures(features);
        investigator.enter(policeStation);
        Assertions.assertEquals(policeStation.getPossibleSuspectsSize(),1);
    }

    @Test
    public void Case04() {

        Suspect suspect = new Suspect("Merey Laroc", "Female", "Mountain Climbing", "Brown", "Jewelry", "Limousine");
    }
    
}
