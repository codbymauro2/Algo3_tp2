package Lists;

import MainObjects.StolenItems;

import java.util.ArrayList;

public class StolenItemsList {

    ArrayList<StolenItems> stolenItemsList = new ArrayList<StolenItems>();

    public void add(StolenItems stolenItem) {
        this.stolenItemsList.add(stolenItem);
    }

    public void assign(Integer difficulty) {
        switch (difficulty) {
            case 0:
                filter("Comun");
                break;
        }
    }

    private void filter(String value) {
        System.out.println((stolenItemsList.get(0).value(value)));
    }

    public void show(){
        System.out.println(stolenItemsList.size());;
    }

    public StolenItems get(int index){
        return stolenItemsList.get(index);
    }
}