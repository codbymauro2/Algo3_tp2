package Readers;
import com.google.gson.JsonElement;

public interface Reader {

    public void read();

    public void storeData();

    public boolean checkFiles(JsonElement json);

}
