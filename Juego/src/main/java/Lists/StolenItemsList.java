package Lists;

import MainObjects.StolenItems;

import java.util.ArrayList;
import java.util.List;

public class StolenItemsList {

    ArrayList<StolenItems> stolenItemsList = new ArrayList<>();

    public void add(StolenItems stolenItem) {
        this.stolenItemsList.add(stolenItem);
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
        List<StolenItems> aux = new ArrayList<>();
        for (StolenItems s : stolenItemsList) {
            if (s.value(value)) {
                aux.add(s);
            }
        }
        stolenItemsList = (ArrayList<StolenItems>) aux;
    }

    public void show() {
        for (StolenItems stolenItems : stolenItemsList) {
            System.out.println(stolenItems.getValue());
        }
    }
}

