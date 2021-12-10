package MainObjects;

public class Suspect {

    private String Name, Gender, Hobby, Hair, Accessory, Vehicle;
    public Suspect() {};

    public Suspect(String name, String gender, String Hobby, String Hair, String Accessory, String Vehicle) {
        this.Name = name;
        this.Gender = gender;
        this.Hobby = Hobby;
        this.Accessory = Accessory;
        this.Vehicle = Vehicle;
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


    public String gender() {
        return Gender;
    }

}
