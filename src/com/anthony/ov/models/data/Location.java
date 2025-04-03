package com.anthony.ov.models.data;

public class Location {

    private final double longitude;
    private final double latitude;

    private final String name;

    public Location(double longitude, double latitude, String name) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
    }

    public double getLon() {
        return longitude;
    }

    public double getLat() {
        return latitude;
    }

    public String getName() {
        return name;
    }


    // This calculates the distances of two lon/lat pairs with the Haversine method
    // It rounds up to maximize the travel cost :)
    public int calculateDistance(Location location) {

        double lon1 = getLon();
        double lat1 = getLat();
        double lon2 = location.getLon();
        double lat2 = location.getLat();

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double rLat1 = Math.toRadians(lat1);
        double rLat2 = Math.toRadians(lat2);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(rLat1) * Math.cos(rLat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (int) Math.ceil(6371.0 * c);
    }

    @Override
    public String toString() {
        return "Location{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", name='" + name + '\'' +
                '}';
    }
}
