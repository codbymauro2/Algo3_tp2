import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class SuspectReader {

    Object json = JsonParser.parseReader(new FileReader("Sospechosos.json"));
    JsonArray jsonArray = (JsonArray) json;
    Gson gson = new Gson();
    ArrayList<Suspect> suspectList;

    public SuspectReader(ArrayList<Suspect> suspectList) throws FileNotFoundException {
        this.suspectList = suspectList;
    }

    public void read(){
        jsonArray.forEach( s -> {
            Suspect suspect = gson.fromJson(s.getAsJsonObject(), Suspect.class);
            suspectList.add(suspect);
        });


    }
}
