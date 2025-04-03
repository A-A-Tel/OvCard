package com.anthony.ov.models;

public class CardPole extends CardGate {

    public CardPole(String id, TransportType transportType, Location location, TravelAgency agency) {
        super(id, transportType, location, agency);
    }

    public void checkCard(AnonymousCard card) {

        if (card.isCheckedIn()) {
            super.checkOut(card);
        } else {
            super.checkIn(card);
        }
    }
}
