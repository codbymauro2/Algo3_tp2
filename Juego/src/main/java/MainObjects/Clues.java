package java.MainObjects;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Clues {

    ArrayList<String> economicClues = new ArrayList<String>();
    ArrayList<String> culturalClues = new ArrayList<String>();
    ArrayList<String> migrationClues = new ArrayList<String>();

    public String getEconomicClue() {
        int num = ThreadLocalRandom.current().nextInt(economicClues.size());
        return economicClues.get(num);
    }


    public String getMigrationClue() {
        int num = ThreadLocalRandom.current().nextInt(culturalClues.size());
        return migrationClues.get(num);
    }

    public String getCulturalClue() {
        int num = ThreadLocalRandom.current().nextInt(migrationClues.size());
        return culturalClues.get(num);
    }
}
