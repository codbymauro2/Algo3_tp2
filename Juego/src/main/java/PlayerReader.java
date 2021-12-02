import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class PlayerReader {

    Object json = JsonParser.parseReader(new FileReader("Players.json"));
    JsonArray jsonArray = (JsonArray) json;
    Gson gson = new Gson();
    ArrayList<Player> playerlist;

    public PlayerReader(ArrayList<Player> playerlist) throws FileNotFoundException {
        this.playerlist = playerlist;
    }

    public void read() {
        jsonArray.forEach( s -> {
            Player player = gson.fromJson(s.getAsJsonObject(), Player.class);
            playerlist.add(player);
        });
    }
}
