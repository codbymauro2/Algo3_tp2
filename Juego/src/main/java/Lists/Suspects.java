package Lists;

import MainObjects.Suspect;

import java.util.ArrayList;

public class Suspects {
    ArrayList<Suspect> suspectsList = new ArrayList<Suspect>();

    public void add(Suspect suspect) {
        suspectsList.add(suspect);
    }

    public int size() {
        return suspectsList.size();
    }

    public Suspect get(int i) {
        return suspectsList.get(i);
    }
}
