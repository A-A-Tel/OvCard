package com.anthony.ov;

import com.anthony.ov.models.*;

public class Main {
    public static void main(String[] args) {

        TravelAgency ns = new TravelAgency("Nederlandse Spoorwegen", 0.075, new double[]{0, 20, 0, 0}, new double[]{0, 0.169, 0, 0});
        TravelAgency arriva = new TravelAgency("Arriva", 0.07, new double[]{0, 15, 0, 0}, new double[]{0, 0.228, 0, 0});

        Location amsterdam = new Location(4.9041, 52.3676, "Amsterdam");
        Location rotterdam = new Location(4.4777, 51.9244, "Rotterdam");

        CardGate amsterdamGate = new CardPole("0", TransportType.TRAIN, amsterdam, ns);
        CardGate rotterdamGate = new CardPole("1", TransportType.TRAIN, rotterdam, ns);

        AnonymousCard card = new AnonymousCard(30);

        amsterdamGate.checkIn(card);
        rotterdamGate.checkOut(card);

        System.out.println(card);
        System.out.println();
        System.out.println(card.getCheckInHistory());
    }
}
