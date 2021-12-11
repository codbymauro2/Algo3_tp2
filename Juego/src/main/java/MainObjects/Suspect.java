package MainObjects;

public class Suspect {

    private String Name, Gender, Hobby, Hair, Accessory, Vehicle;
    public Suspect() {};

    public Suspect(String name, String gender, String hobby, String hair, String accessory, String vehicle) {
        this.Name = name;
        this.Gender = gender;
        this.Hobby = hobby;
        this.Hair = hair;
        this.Accessory = accessory;
        this.Vehicle = vehicle;
    }

    public Suspect(String[] array) {
        this.Name = array[0];
        this.Gender = array[1];
        this.Hobby = array[2];
        this.Accessory = array[3];
        this.Vehicle = array[4];
    }

    public String getName() {
        return Name;
    }

    public boolean hasHair(String hair) {
        return this.Hair.equals(hair);
    }

    public boolean hasHobby(String hobby) {
        return this.Hobby.equals(hobby);
    }

    public boolean isGender(String gender) { return this.Gender.equals(gender); }

    public boolean hasAccessory(String accessory) { return this.Accessory.equals(accessory); }

    public boolean hasVehicle(String vehicle) { return this.Vehicle.equals(vehicle); }
}
