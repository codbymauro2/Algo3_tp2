package MainObjects;

public class Coordinates {
    private final double latitude;
    private final double longitude;
    private final double radioEarth;

    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radioEarth = 6371.0;
    }

    public int distance(Coordinates coordinates) {
        return coordinates.calculateDistance(latitude, longitude);
    }

    private int calculateDistance(double otherLatitude, double otherLongitude) {
        double DistanceLatitude = Math.toRadians(otherLatitude - latitude);
        double DistanceLongitude = Math.toRadians(otherLongitude - longitude);
        double value1 = Math.pow(Math.sin(DistanceLatitude/2),2) + Math.pow(Math.sin(DistanceLongitude/2),2) * Math.cos(Math.toRadians(otherLatitude)) * Math.cos(Math.toRadians(latitude));
        double value2 = 2 * Math.asin(Math.sqrt(value1));
        double distance = radioEarth * value2;
        return (int) Math.round(distance);
    }

}
