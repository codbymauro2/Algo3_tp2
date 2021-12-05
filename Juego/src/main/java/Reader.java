import com.google.gson.JsonElement;

public interface Reader {

    public void read();

    public boolean checkFiles(JsonElement json);

}
