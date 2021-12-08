package Lists;

import MainObjects.City;
import MainObjects.StolenItem;

import java.util.ArrayList;
import java.util.List;

public class StolenItems {

    ArrayList<StolenItem> stolenItemList = new ArrayList<>();

    public void add(StolenItem stolenItem) {
        this.stolenItemList.add(stolenItem);
    }

    public void assign(Integer difficulty) {
        switch (difficulty) {
            case 1 -> filter("Comun");
            case 2 -> filter("Valioso");
            case 3 -> filter("Muy Valioso");
            default -> {
            }
        }
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

