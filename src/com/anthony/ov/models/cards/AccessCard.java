package com.anthony.ov.models.cards;

import java.util.Random;

public class AccessCard {
    protected final String cardId;

    public AccessCard() {

        StringBuilder idBuilder = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < 16; i++) {
            idBuilder.append(rnd.nextInt(10));
        }
        this.cardId = idBuilder.toString();
    }

    public String getCardId() {
        return cardId;
    }
}
