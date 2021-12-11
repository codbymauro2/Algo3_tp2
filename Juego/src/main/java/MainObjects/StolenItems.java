package MainObjects;

public class StolenItems {

    String name, value, city;

    public StolenItems() {};

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public boolean value(String index) {
        return (value.equals(index));
    }
}
