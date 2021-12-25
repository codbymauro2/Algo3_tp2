package Modelo.MainObjects;

import Modelo.Lists.Cities;
import Modelo.Lists.Suspects;
import Modelo.MainObjects.Buildings.Building;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class PoliceStation {

    private Suspects suspects;
    private Suspect thief;
    private ArrayList<Suspect> possibleSuspects;
    private ArrayList<Feature> features;
    private Player player;
    private StolenItem stolenItem;
    private Cities cities;

    public PoliceStation(Suspects suspects, Cities cities) {
        this.cities = cities;
        this.suspects = suspects;
        this.startFeatures();
        this.thief = suspects.getRobber();
        this.thief.createFeatureClues();
        this.possibleSuspects = new ArrayList<>();
    }

    public ArrayList<Suspect> getSuspects(ArrayList<Feature> features) {
        ArrayList<Suspect> possibleSuspects = suspects.filter(features);
        this.possibleSuspects = possibleSuspects;
        return this.possibleSuspects;
    }

    public int getPossibleSuspectsSize() {
        return possibleSuspects.size();
    }

    public void obtainFeatures(Feature feature1, Feature feature2, Feature feature3, Feature feature4, Feature feature5) {
        updateFeatures(feature1, feature2, feature3, feature4, feature5);
    }

    private void updateFeatures(Feature feature1, Feature feature2, Feature feature3, Feature feature4, Feature feature5) {
        this.features.set(0, feature1);
        this.features.set(1, feature2);
        this.features.set(2, feature3);
        this.features.set(3, feature4);
        this.features.set(4, feature5);
    }

    private void startFeatures() {
        features = new ArrayList<>();
        IntStream.range(0, 5).forEach(i -> {
            features.add(new Feature(""));
        });
    }

    public ArrayList<Suspect> findSuspects() {;
        this.possibleSuspects = suspects.filter(features);
        return this.possibleSuspects;
    }

    public Police assignRange(Player player) {

        this.player = player;
        int casesWon = this.player.totalCasesWon();

        if (casesWon >= 0 && casesWon < 5)
            return new Rookie(this);
        else if (casesWon >= 5 && casesWon < 10)
            return new Detective(this);
        else if (casesWon >= 10 && casesWon < 20)
            return new Investigator(this);
        return new Sergeant(this);

    }

    public Suspect getRobber() {
        return suspects.getRobber();
    }

    public void completeCase() {
        this.player.addFinishedCase(1);
    }

    public Suspect getThief() {
        return this.thief;
    }
}