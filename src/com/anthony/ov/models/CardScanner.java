package com.anthony.ov.models;

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

    public String getId() {
        return id;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public Location getLocation() {
        return location;
    }

    public TravelAgency getAgency() {
        return agency;
    }

    public void scanCard(AnonymousCard card) {

        if (!card.isCheckedIn() && card.getBalance() < agency.getMinimumBalance(transportType)) {

            System.out.println("Not enough balance for this transport");
        } else {

            card.checkIn(this);
        }
    }

    public double calculateTravelFee(CardScanner scanner) {

        int distance = location.calculateDistance(scanner.location);

        System.out.println(distance);

        double travelFee = distance * agency.getTravelFee(transportType);
        travelFee = Math.round(travelFee * 100) / 100.0;

        return travelFee;
    }
}
