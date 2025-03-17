package com.anthony.ov.models;

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

    public int calculateDistance(Location location) {

        double lon1 = longitude;
        double lat1 = latitude;
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
        return "\r\nLocation: " +
                "\r\n    Name: " + name +
                "\r\n    Longitude: " + longitude
                + "\r\n    Latitude: " + latitude;
    }
}
