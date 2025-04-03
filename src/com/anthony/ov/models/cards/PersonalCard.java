package com.anthony.ov.models.cards;

import com.anthony.ov.models.data.TravelProduct;

import java.util.ArrayList;

public class PersonalCard extends AnonymousCard {

    private final String name;

    private final ArrayList<TravelProduct> travelProducts;

    private TravelProduct activeTravelProduct;

    public PersonalCard(double balance, String name) {
        super(balance);
        this.name = name;
        this.travelProducts = new ArrayList<>();
    }

    public void addTravelProduct(TravelProduct travelProduct) {
        travelProducts.add(travelProduct);
    }

    public String getName() {
        return name;
    }

    public ArrayList<TravelProduct> getTravelProducts() {
        return travelProducts;
    }

    public TravelProduct getActiveTravelProduct() {
        return activeTravelProduct;
    }

    public void setActiveTravelProduct(TravelProduct activeTravelProduct) {
        this.activeTravelProduct = activeTravelProduct;
    }

    @Override
    public String toString() {
        return "PersonalCard{" +
                "cardId='" + cardId + '\'' +
                ", checkInHistory=" + checkInHistory +
                ", expirationDate=" + expirationDate +
                ", checkedIn=" + checkedIn +
                ", firstClass=" + firstClass +
                ", balance=" + balance +
                ", travelProducts=" + travelProducts +
                ", name='" + name + '\'' +
                '}';
    }
}
