package com.anthony.ov.models;

import java.util.Objects;

public class CardGate {
    private final String id;
    private final TransportType transportType;
    private final Location location;
    private final TravelAgency agency;

    public CardGate(String id, TransportType transportType, Location location, TravelAgency agency) {
        this.id = id;
        this.transportType = transportType;
        this.location = location;
        this.agency = agency;
    }

    public double calculateTravelFee(CardGate scanner, boolean isFirstClass) {

        int distance = location.calculateDistance(scanner.location);

        double travelFee = distance * agency.getTravelFee(getTransportType());
        travelFee = Math.round(travelFee * 100) / 100.0;

        if (isFirstClass) {
            travelFee = Math.round(
                    (
                            (
                                    Math.round(travelFee * 100 * agency.getFirstClassFactor()) / 100.0
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

    public void checkIn(AccessCard card) {

        if (card.getClass().equals(AccessCard.class)) {
            System.out.println("Access granted");
        } else {

            AnonymousCard anonCard = (AnonymousCard) card;

            if (anonCard.isCheckedIn()) {
                System.out.println("You are checked in already!");
            } else if (anonCard.getBalance() < agency.getMinimumBalance(transportType)) {
                System.out.println("You do not have enough money!");
            } else {
                anonCard.checkIn(this);
                System.out.println("You have successfully checked in!"  );
            }
        }
    }

    public void checkOut(AccessCard card) {

        if (card.getClass().equals(AccessCard.class)) {
            System.out.println("Access granted");

        } else {
            AnonymousCard anonCard = (AnonymousCard) card;

            if (!anonCard.isCheckedIn()) {
                System.out.println("You are not checked in!");

            } else {
                CardGate checker = anonCard.getCheckInHistory().getLast();

                if (!agency.equals(checker.agency)) {

                    System.out.println("You are checked in at a different agency!");

                } else {

                    double fee = calculateTravelFee(checker, anonCard.isFirstClass());
                    anonCard.checkOut(this, fee);
                    System.out.println("You have checked out " + fee);
                }
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CardGate) obj;
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
