package Vista;

import Modelo.MainObjects.City;
import Modelo.MainObjects.Coordinates;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class MapView {

    private final Canvas canvas;
    private final ArrayList<City> travelCities;
    private final City currentCity;
    private final int CENTER_LONGITUDE = 364;
    private final int CENTER_LATITUDE = 250;

    public MapView(Canvas canvas, ArrayList<City> travelCities, City currentCity) {
        this.canvas = canvas;
        this.travelCities = travelCities;
        this.currentCity = currentCity;
        Image image = new Image("/images/mapImage.png", 728, 410, false, false);
        canvas.getGraphicsContext2D().drawImage(new Image("/images/mapImage.png"), 0, 0, 728, 410);
        travelCities.forEach( city -> {
            drawCities(city);
        });
        canvas.getGraphicsContext2D().setFill(Color.rgb(255,255,255));
        drawCities(currentCity);
    }

    public void update() {

    }


    public void drawCities(City city) {
        Coordinates coordinates = city.getCoordinates();
        canvas.getGraphicsContext2D().fillOval(CENTER_LONGITUDE + (coordinates.getLongitude() * 2.55), CENTER_LATITUDE + (coordinates.getLatitude() * -2.55 ), 10, 10);
        canvas.getGraphicsContext2D().setFont(Font.font("garamond", 15 ));
        canvas.getGraphicsContext2D().fillText(city.getName(),CENTER_LONGITUDE - 10 + (coordinates.getLongitude() * 2.55), CENTER_LATITUDE - 10 + (coordinates.getLatitude() * -2.55 ));
    }

}
