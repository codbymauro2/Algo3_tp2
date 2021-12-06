package MainObjects;

public class StolenItems {

    String name, value, city;

    public StolenItems() {};

    public String getName() {
        return name;
    }

    public boolean difficulty(String value) {
        return (this.value == value);
    }

    public String getValue() {
        return value;
    }

    public boolean value(String index) {
        return value == index;
    }
}
