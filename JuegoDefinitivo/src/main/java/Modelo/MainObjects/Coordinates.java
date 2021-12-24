package Modelo.MainObjects;

import java.util.Objects;

public class Coordinates {

    private double latitude;
    private double longitude;
    private double radioEarth;

    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radioEarth = 6371;
    }

    public Coordinates() {
        this.radioEarth = 6371;
    }

    public double distanceKms(Coordinates coordinates) {
        return coordinates.calculateDistanceKms(latitude, longitude);
    }

    private double calculateDistanceKms(double otherLatitude, double otherLongitude) {
        double dLat = Math.toRadians(otherLatitude - latitude);
        double dLng = Math.toRadians(otherLongitude - longitude);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(otherLatitude));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double distancia = this.radioEarth * va2;

        return Math.round(distancia);
    }

    @Override
    public boolean equals(Object coordinates){
        return (Objects.equals(this.latitude, ((Coordinates) coordinates).getLatitude()) && Objects.equals(this.longitude, ((Coordinates) coordinates).getLongitude()));
    }

    private double getLatitude() {
        return latitude;
    }

    private double getLongitude() {
        return longitude;
    }



}
