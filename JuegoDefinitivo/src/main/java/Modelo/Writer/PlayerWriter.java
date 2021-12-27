package Modelo.Writer;

import Modelo.Lists.Players;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class PlayerWriter {

    private Players players;
    private Gson gson;

    public PlayerWriter(Players players){
        this.gson = new Gson();
        this.players = players;
    }

    public void write() throws FileNotFoundException {

        try (FileOutputStream fos = new FileOutputStream("Players.json");
             OutputStreamWriter isr = new OutputStreamWriter(fos,
                     StandardCharsets.UTF_8)) {
            gson.toJson(players.getPlayers(), isr);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }
