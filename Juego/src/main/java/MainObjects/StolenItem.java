package MainObjects;

public class StolenItem {

    String name, value, city;

    public StolenItem() {};

    public String getItem() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getCityName() { return city; }

    public boolean value(String index) {
        return (value.equals(index));
    }
}
