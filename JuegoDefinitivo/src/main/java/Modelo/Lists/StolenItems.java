package Modelo.Lists;

import Modelo.MainObjects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StolenItems {

    private ArrayList<StolenItem> stolenItemList;

    public StolenItems(){
        this.stolenItemList = new ArrayList<>();
    }

    public void add(StolenItem stolenItem) {
        this.stolenItemList.add(stolenItem);
    }

    private StolenItem selectRandomElement(){
        Random random = new Random();
        int randomInt = random.nextInt(this.stolenItemList.size());
        return stolenItemList.get(randomInt);
    }

    public StolenItem assign(int difficulty) {
        switch (difficulty) {
            case 1 -> filter("Comun");
            case 2 -> filter("Valioso");
            case 3 -> filter("Muy Valioso");
            default -> {
            }
        }
        return selectRandomElement();
    }

    private void filter(String value) {
        List<StolenItem> aux = new ArrayList<>();
        for (StolenItem s : stolenItemList) {
            if (s.value(value)) {
                aux.add(s);
            }
        }
        stolenItemList = (ArrayList<StolenItem>) aux;
    }

    public void show() {
        for (StolenItem stolenItem : stolenItemList) {
            System.out.println(stolenItem.getValue());
        }
    }

    public int size() {
        return stolenItemList.size();
    }

    public StolenItem get(int i) {
        return(stolenItemList.get(i));
    }

}

