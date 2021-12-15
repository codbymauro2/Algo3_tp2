package MainObjects;

import Lists.Suspects;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class PoliceStation {

    Suspects suspects;
    ArrayList<Suspect> possibleSuspects;
    ArrayList<String> features;
    Player player;
    Planisphere planisphere;

    public PoliceStation(Suspects suspects, Planisphere planisphere){
        this.planisphere = planisphere;
        this.suspects = suspects;
        this.startFeatures();
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

    public Police assignCase(Player player){
        this.player = player;
        int casesWon = this.player.totalCasesWon();

        if(casesWon >= 0 && casesWon < 5)
            return new Rookie(this,this.planisphere);
        else if(casesWon >= 5 && casesWon < 10)
            return new Detective(this,this.planisphere);
        else if(casesWon >= 10 && casesWon < 20)
            return new Investigator(this,this.planisphere);

        return new Sergeant(this,this.planisphere);
    }

    public City caseFrom() {
        return planisphere.getOrigin();
    }
}