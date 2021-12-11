package MainObjects;

import Lists.Suspects;

import java.util.ArrayList;

public class PoliceStation {

    Suspects suspects;
    ArrayList<Suspect> possibleSuspects;

    public PoliceStation(Suspects suspects){
        this.suspects = suspects;
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
}