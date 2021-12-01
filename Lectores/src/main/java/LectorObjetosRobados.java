import com.google.gson.*;
import java.io.*;
import java.util.ArrayList;

public class LectorObjetosRobados {

    Object obj = JsonParser.parseReader(new FileReader("ObjetosRobados.json"));
    JsonArray jo = (JsonArray) obj;
    Gson gson = new Gson();
    ArrayList<ObjetoRobado> objetoRobados = new ArrayList<ObjetoRobado>();

    public LectorObjetosRobados() throws FileNotFoundException {
    }

    public void leer() {
        jo.forEach( s -> {
            ObjetoRobado objetoRobado = gson.fromJson(s.getAsJsonObject(),ObjetoRobado.class);
            objetoRobados.add(objetoRobado);
        });
    }
}
