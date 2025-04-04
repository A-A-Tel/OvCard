package com.anthony.ov.models.scanners;

import com.anthony.ov.models.cards.AccessCard;
import com.anthony.ov.models.cards.AnonymousCard;
import com.anthony.ov.models.cards.PersonalCard;
import com.anthony.ov.models.data.Location;
import com.anthony.ov.models.data.TransportType;
import com.anthony.ov.models.data.TravelAgency;
import com.anthony.ov.models.data.TravelProduct;

import java.time.LocalDateTime;

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

    public double calculateTravelFee(AnonymousCard card) {

        Location location = card.getCheckInHistory().getLast().location;

        int km = this.location.calculateDistance(location);
        double fee = km * agency.getTravelFee(transportType);

        if (card.isFirstClass()) {
            fee *= agency.firstClassFactor();
        }

        if (card.getClass() == PersonalCard.class) {

            TravelProduct product = ((PersonalCard) card).getActiveTravelProduct();

            if (product != null && product.isValidDay() && card.isFirstClass() == product.isFirstClass()) {
                fee -= fee * product.getDiscountFactor();
            }
        }
        return Math.round(fee * 100) / 100.0;
    }

    public String getId() {
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

            if (isValidCheckIn(anonCard)) {
                anonCard.checkIn(this);
                System.out.println("You have successfully checked in!");
            }
        }
    }

    public void checkOut(AccessCard card) {

        if (card.getClass().equals(AccessCard.class)) {
            System.out.println("Access granted");

        } else {
            AnonymousCard anonCard = (AnonymousCard) card;

            if (isValidCheckOut(anonCard)) {

                double fee = calculateTravelFee(anonCard);
                anonCard.checkOut(this, fee);
                System.out.println("You have successfully checked out!");
            }
        }
    }

    private boolean isValidCheckIn(AnonymousCard card) {

        if (card.isCheckedIn()) {
            System.out.println("You are checked in already!");
            return false;
        }

        if (card.getExpireDate().isBefore(LocalDateTime.now())) {
            System.out.println("Your card has expired!");
            return false;
        }

        double minimumBalance = agency.getMinimumBalance(transportType);

        if (card.getClass().equals(PersonalCard.class)) {

            TravelProduct product = ((PersonalCard) card).getActiveTravelProduct();

            if (product != null) {
                minimumBalance -= minimumBalance * product.getBalanceRequirementDiscountFactor();
            }
        }

        if (card.getBalance() < minimumBalance) {
            System.out.println("You do not have enough money!");
            return false;
        }

        return true;
    }

    private boolean isValidCheckOut(AnonymousCard card) {

        if (!card.isCheckedIn()) {
            System.out.println("You are not checked in! Please wait until someone comes to help.");
            return false;
        }

        TravelAgency agency = card.getCheckInHistory().getLast().agency;

        if (!this.agency.equals(agency)) {
            System.out.println("You are checked in at a different agency!");
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "CardGate{" +
                "id='" + id + '\'' +
                ", transportType=" + transportType +
                ", location=" + location +
                ", agency=" + agency +
                '}';
    }
}
