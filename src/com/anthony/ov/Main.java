package com.anthony.ov;

import com.anthony.ov.models.cards.AnonymousCard;
import com.anthony.ov.models.data.Location;
import com.anthony.ov.models.data.TransportType;
import com.anthony.ov.models.data.TravelAgency;
import com.anthony.ov.models.scanners.CardGate;
import com.anthony.ov.models.scanners.CardPole;

public class Main {
    public static void main(String[] args) {

        TravelAgency ns = new TravelAgency("Nederlandse Spoorwegen", 0.075, new double[]{-1, 20, -1, -1}, new double[]{-1, 0.169, -1, -1});
        TravelAgency arriva = new TravelAgency("Arriva", 0.07, new double[]{4, 15, -1, -1}, new double[]{0.192, 0.228, -1, -1});

        Location amsterdam = new Location(4.9041, 52.3676, "Amsterdam");
        Location rotterdam = new Location(4.4777, 51.9244, "Rotterdam");

        CardGate amsterdamGate = new CardPole("0", TransportType.TRAIN, amsterdam, ns);
        CardGate rotterdamGate = new CardPole("1", TransportType.TRAIN, rotterdam, ns);

        AnonymousCard card = new AnonymousCard(30);

        amsterdamGate.checkIn(card);
        rotterdamGate.checkOut(card);

        System.out.println(card);
    }
}
