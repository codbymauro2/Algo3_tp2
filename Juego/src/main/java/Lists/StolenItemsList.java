package Lists;

import MainObjects.StolenItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StolenItemsList {

    ArrayList<StolenItems> stolenItemsList = new ArrayList<StolenItems>();

    public void add(StolenItems stolenItem) {
        this.stolenItemsList.add(stolenItem);
    }

    public void assign(Integer difficulty) {
        switch (difficulty) {
            case 1:
                filter("Comun");
                break;
            case 2:
                filter("Valioso");
                break;
            case 3:
                filter("Muy Valioso");
                break;
            default:
                break;
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

    public void show(){
        for(int i=0; i < stolenItemsList.size(); i++){
            System.out.println(stolenItemsList.get(i).getValue());
            };
        }

    public StolenItems get(int index){
        return stolenItemsList.get(index);
    }
}