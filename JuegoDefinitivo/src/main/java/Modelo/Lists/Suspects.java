package Modelo.Lists;


import Modelo.MainObjects.Suspect;
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

    private ArrayList<Suspect> filterByGender(String gender) {
        ArrayList<Suspect> aux = new ArrayList<>();
        possibleSuspectsList.forEach( s -> {
            if( gender.isEmpty() || s.isGender(gender))
                aux.add(s);
        });

        return aux;
    }

    private ArrayList<Suspect> filterByHobby(String hobby) {
        ArrayList<Suspect> aux = new ArrayList<>();
        possibleSuspectsList.forEach( s -> {
            if( hobby.isEmpty() || s.hasHobby(hobby))
                aux.add(s);
        });

        return aux;
    }

    private ArrayList<Suspect> filterByHair(String hair) {
        ArrayList<Suspect> aux = new ArrayList<>();
        possibleSuspectsList.forEach( s -> {
            if( hair.isEmpty() || s.hasHair(hair))
                aux.add(s);
        });

        return aux;
    }


    private ArrayList<Suspect> filterByAccessory(String accessory) {
        ArrayList<Suspect> aux = new ArrayList<>();
        possibleSuspectsList.forEach(s -> {
            if (accessory.isEmpty() || s.hasAccessory(accessory))
                aux.add(s);
        });
        return aux;
    }

    private ArrayList<Suspect> filterByVehicle(String vehicle) {
        ArrayList<Suspect> aux = new ArrayList<>();
        possibleSuspectsList.forEach(s -> {
            if (vehicle.isEmpty() || s.hasVehicle(vehicle))
                aux.add(s);
        });
        return aux;
    }

    private void fillPossibleSuspects() {
        possibleSuspectsList = new ArrayList<>();
        possibleSuspectsList.addAll(suspectsList);
    }

    public ArrayList<Suspect> filter(ArrayList<String> features) {
        fillPossibleSuspects();
        this.possibleSuspectsList = this.filterByGender(features.get(0));
        this.possibleSuspectsList = this.filterByHobby(features.get(1));
        this.possibleSuspectsList = this.filterByHair(features.get(2));
        this.possibleSuspectsList = this.filterByAccessory(features.get((3)));
        this.possibleSuspectsList = this.filterByVehicle(features.get(4));
        return  possibleSuspectsList;
    }


    public void randomSuspect() {
      Random random = new Random();
      int randomInt = random.nextInt(suspectsList.size());
      this.robber = suspectsList.get(randomInt);
      this.robber.convertToRobber();
    }

    public Suspect getRobber() {
        return robber;
    }


}
