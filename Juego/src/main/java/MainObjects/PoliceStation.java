package MainObjects;

import Lists.Suspects;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class PoliceStation {

    Suspects suspects;
    ArrayList<Suspect> possibleSuspects;
    ArrayList<String> features;

    public PoliceStation(Suspects suspects){
        this.suspects = suspects;
        startFeatures();
    }

    public void getSuspects(ArrayList<String> features) {
        ArrayList<Suspect> possibleSuspects = suspects.filter(features);
        possibleSuspects.forEach(suspect -> {
            System.out.println(suspect.getName());
        });
        this.possibleSuspects = possibleSuspects;
    }

    public int getPossibleSuspectsSize() {
        return possibleSuspects.size();
    }

    public void obtainFeatures(String[] features) {
        updateFeatures(features);
    }

    private void updateFeatures(String[] features) {
        this.features.set(0, features[0]);
        this.features.set(1, features[1]);
        this.features.set(2, features[2]);
        this.features.set(3, features[3]);
        this.features.set(4, features[4]);
    }

    private void startFeatures() {
        features = new ArrayList<>();
        IntStream.range(0, 5).forEach(i -> {
            features.add("");
        });
    }

    public ArrayList<Suspect> findSuspects() {
        return suspects.filter(features);
    }

    public Police assignCase(Police police, int casesWon) {
        Police selectedPolice = null;
        if(casesWon >= 0 && casesWon < 5)
            selectedPolice = new Rookie();
        else if(casesWon >= 5 && casesWon < 10)
            selectedPolice = new Detective();
        else if(casesWon >= 10)
            selectedPolice = new Investigator();

        return selectedPolice;
    }
}