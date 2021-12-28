import Modelo.Lists.Cities;
import Modelo.Lists.Suspects;
import Modelo.MainObjects.*;
import Modelo.MainObjects.Buildings.Bank;
import Modelo.MainObjects.Polices.Detective;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.spy;

public class TestTimeReduced {
    @Test
    public void test01TimeReducedEnteringBuilding() {
        Cities cities = new Cities();

        City lima = new City("Lima", new Coordinates(45.50, -73.57));
        cities.add(lima);
        City dublin = new City("Dublin", new Coordinates(45.50, -73.57));
        cities.add(dublin);

        StolenItem stolenItem = new StolenItem("Incan Gold Mask", "Valioso", "Lima");
        cities.startCity(stolenItem);
        Suspects suspects = new Suspects();
        Suspect suspect = spy(new Suspect("Merey Laroc", new Feature("Female"), new Feature("Mountain Climbing"), new Feature("Brown"), new Feature("Jewelry"), new Feature("Limousine")));
        suspects.add(suspect);
        cities.setSuspect(suspect);
        suspects.randomSuspect(cities, 3);

        Clue clueBank = new Clue("Pista de banco facil", "Pista de banco media", "Pista de banco dificil");
        Bank bank = new Bank(clueBank);
        dublin.setBank(bank);

        PoliceStation policeStation = new PoliceStation(suspects);
        policeStation.setSuspect();
        Detective detective = new Detective(policeStation);
        detective.setCurrentCity(lima);

        Assertions.assertEquals("Monday 9hs", detective.getTimeLeft());
        System.out.println(detective.getTimeLeft());

        detective.enter(bank);
        System.out.println("\n");
        System.out.println(detective.getTimeLeft());
        Assertions.assertEquals("Monday 10hs", detective.getTimeLeft());

        detective.enter(bank);
        System.out.println("\n");
        System.out.println(detective.getTimeLeft());
        Assertions.assertEquals("Monday 12hs", detective.getTimeLeft());

        detective.enter(bank);
        System.out.println("\n");
        System.out.println(detective.getTimeLeft());
        Assertions.assertEquals("Monday 15hs", detective.getTimeLeft());
    }


}