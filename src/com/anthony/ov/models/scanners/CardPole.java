package com.anthony.ov.models.scanners;

import com.anthony.ov.models.cards.AnonymousCard;
import com.anthony.ov.models.data.Location;
import com.anthony.ov.models.data.TransportType;
import com.anthony.ov.models.data.TravelAgency;

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
