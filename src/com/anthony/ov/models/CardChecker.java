package com.anthony.ov.models;

import java.util.Objects;

public class CardScanner {
    private final String id;
    private final TransportType transportType;
    private final Location location;
    private final TravelAgency agency;

    public CardScanner(String id, TransportType transportType, Location location, TravelAgency agency) {
        this.id = id;
        this.transportType = transportType;
        this.location = location;
        this.agency = agency;
    }



    public double calculateTravelFee(CardScanner scanner, boolean isFirstClass) {

        int distance = location().calculateDistance(scanner.location());

        double travelFee = distance * agency().getTravelFee(getTransportType());
        travelFee = Math.round(travelFee * 100) / 100.0;

        if (isFirstClass) {
            travelFee = Math.round(
                    (
                            (
                                    Math.round(travelFee * 100 * agency().getFirstClassFactor()) / 100.0
                            ) + travelFee
                    ) * 100
            ) / 100.0;
        }

        return travelFee;
    }

    public String id() {
        return id;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public Location location() {
        return location;
    }

    public TravelAgency agency() {
        return agency;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CardScanner) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.transportType, that.transportType) &&
                Objects.equals(this.location, that.location) &&
                Objects.equals(this.agency, that.agency);
    }

    @Override
    public String toString() {
        return "CardScanner[" +
                "id=" + id + ", " +
                "transportType=" + transportType + ", " +
                "location=" + location + ", " +
                "agency=" + agency + ']';
    }

}
