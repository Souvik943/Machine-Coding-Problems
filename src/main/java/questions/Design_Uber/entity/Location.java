package questions.Design_Uber.entity;

public class Location {
    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //Euclidean Distance (approximated)
    public double distanceTo(Location otherLocation) {
        double dx = otherLocation.latitude - this.latitude;
        double dy = otherLocation.longitude - this.longitude;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }
}
