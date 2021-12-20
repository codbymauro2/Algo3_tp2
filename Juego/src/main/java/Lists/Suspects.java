package Lists;

import MainObjects.Feature;
import MainObjects.Suspect;

import java.util.ArrayList;
import java.util.Random;

public class Suspects {

    private ArrayList<Suspect> suspectsList = new ArrayList<>();
    private ArrayList<Suspect> possibleSuspectsList = new ArrayList<>();
    private Suspect robber;

    public void add(Suspect suspect) {
        suspectsList.add(suspect);
    }

    public int size() {
        return suspectsList.size();
    }

    public Suspect get(int i) {
        return suspectsList.get(i);
    }

    private ArrayList<Suspect> filterByGender(Feature feature) {
        ArrayList<Suspect> aux = new ArrayList<>();
        possibleSuspectsList.forEach( s -> {
            if( feature.notDefinite() || s.isGender(feature))
                aux.add(s);
        });

        return aux;
    }

    private ArrayList<Suspect> filterByHobby(Feature feature) {
        ArrayList<Suspect> aux = new ArrayList<>();
        possibleSuspectsList.forEach( s -> {
            if( feature.notDefinite() || s.hasHobby(feature))
                aux.add(s);
        });

        return aux;
    }

    private ArrayList<Suspect> filterByHair(Feature feature) {
        ArrayList<Suspect> aux = new ArrayList<>();
        possibleSuspectsList.forEach( s -> {
            if( feature.notDefinite() || s.hasHair(feature))
                aux.add(s);
        });

        return aux;
    }


    private ArrayList<Suspect> filterByAccessory(Feature feature) {
        ArrayList<Suspect> aux = new ArrayList<>();
        possibleSuspectsList.forEach(s -> {
            if (feature.notDefinite() || s.hasAccessory(feature))
                aux.add(s);
        });
        return aux;
    }

    private ArrayList<Suspect> filterByVehicle(Feature feature) {
        ArrayList<Suspect> aux = new ArrayList<>();
        possibleSuspectsList.forEach(s -> {
            if (feature.notDefinite() || s.hasVehicle(feature))
                aux.add(s);
        });
        return aux;
    }

    private void fillPossibleSuspects() {
        possibleSuspectsList = new ArrayList<>();
        possibleSuspectsList.addAll(suspectsList);
    }

    public ArrayList<Suspect> filter(ArrayList<Feature> features) {
        fillPossibleSuspects();
        this.possibleSuspectsList = this.filterByGender(features.get(0));
        this.possibleSuspectsList = this.filterByHobby(features.get(1));
        this.possibleSuspectsList = this.filterByHair(features.get(2));
        this.possibleSuspectsList = this.filterByAccessory(features.get((3)));
        this.possibleSuspectsList = this.filterByVehicle(features.get(4));
        return  possibleSuspectsList;
    }


    public void randomSuspect(Cities cities, int difficulty) {
      Random random = new Random();
      int randomInt = random.nextInt(suspectsList.size());
      this.robber = suspectsList.get(randomInt);
      this.robber.convertToRobber();
      this.robber.createPath(cities, difficulty);
    }

    public Suspect getRobber() {
        return robber;
    }


}
