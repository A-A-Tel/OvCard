package com.anthony.ov.models.scanners;

import com.anthony.ov.models.cards.AnonymousCard;
import com.anthony.ov.models.cards.PersonalCard;
import com.anthony.ov.models.data.TravelProduct;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class CardService {

    private AnonymousCard activeCard;

    public void scanCard(AnonymousCard card) {
        if (card.getExpireDate().isBefore(LocalDateTime.now())) {
            System.out.println("Your card has expired!");
        } else {
            activeCard = card;
        }
    }

    public void increaseBalance(double amount) {
        if (activeCard == null) {
            System.out.println("No active card!");

        } else {
            activeCard.increaseBalance(amount);
        }
    }

    public void setFirstClass(boolean firstClass) {
        if (activeCard == null) {
            System.out.println("No active card!");

        } else {
            activeCard.setFirstClass(firstClass);
        }
    }

    public void setTravelProduct() {
        if (activeCard == null) {
            System.out.println("No active card!");

        } else if (!activeCard.getClass().equals(PersonalCard.class)) {
            System.out.println("Card is not a personal card!");

        } else {
            Scanner scanner = new Scanner(System.in);
            PersonalCard card = (PersonalCard) activeCard;
            ArrayList<TravelProduct> products = card.getTravelProducts();

            outputTravelProducts(products);
            System.out.println("Please enter the index of the travel product...");
            int index;
            while (true) {

                try {
                    index = Integer.parseInt(scanner.next());
                    if (index >= products.size()) {
                        System.out.println("Travel product index out of bounds!");
                    } else {
                        break;
                    }
                } catch (NumberFormatException _) {
                    System.out.println("That is not a number!");
                }
            }
            card.setActiveTravelProduct(products.get(index));
            System.out.println("Active travel product is now " + card.getActiveTravelProduct().getName());
        }
    }

    public void removeActiveTravelProduct() {
        if (activeCard == null) {
            System.out.println("No active card!");

        } else if (!activeCard.getClass().equals(PersonalCard.class)) {
            System.out.println("Card is not a personal card!");
        } else {
            PersonalCard card = (PersonalCard) activeCard;
            card.setActiveTravelProduct(null);
            System.out.println("Active travel product successfully removed!");
        }
    }

    private void outputTravelProducts(ArrayList<TravelProduct> products) {

        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + " - " + products.get(i).getName());
        }
        System.out.println();
    }

    public void closeSession() {
        activeCard = null;
        System.out.println("Have a nice day!");
    }

}
