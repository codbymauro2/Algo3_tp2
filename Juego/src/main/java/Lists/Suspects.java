package Lists;

import MainObjects.Suspect;

import java.util.ArrayList;

public class Suspects {

    ArrayList<Suspect> suspectsList = new ArrayList<>();
    ArrayList<Suspect> possibleSuspectsList = new ArrayList<>();

    public void add(Suspect suspect) {
        suspectsList.add(suspect);
    }

    public int size() {
        return possibleSuspectsList.size();
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
        suspectsList.forEach( suspect -> {
            possibleSuspectsList.add(suspect);
        });
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
}
