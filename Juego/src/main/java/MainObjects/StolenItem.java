package MainObjects;

public class StolenItem {

    String name, value, city;

    public StolenItem(String name, String value, String city) {
        this.name = name;
        this.value = value;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public boolean value(String index) {
        return (value.equals(index));
    }

    public String origin() {
        return city;
    }
}
