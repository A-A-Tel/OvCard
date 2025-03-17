package com.anthony.ov.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class AnonymousCard {

    private double balance;

    private boolean firstClass;

    private boolean checkedIn;

    private final String cardId;

    private final LocalDateTime expirationDate;

    private final ArrayList<CardScanner> checkInHistory;

    public AnonymousCard(double balance) {
        this.balance = balance;

        firstClass = false;
        checkedIn = false;

        StringBuilder idBuilder = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < 16; i++) {
            idBuilder.append(rnd.nextInt(10));
        }
        this.cardId = idBuilder.toString();

        expirationDate = LocalDateTime.now().plusYears(5);
        checkInHistory = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public boolean isFirstClass() {
        return firstClass;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public String getCardId() {
        return cardId;
    }

    public LocalDateTime getExpireDate() {
        return expirationDate;
    }

    public ArrayList<CardScanner> getCheckInHistory() {
        return checkInHistory;
    }

    public void checkIn(CardScanner scanner) {


        if (isCheckedIn()) {

            double fee = scanner.calculateTravelFee(checkInHistory.getLast());

            if (isFirstClass()) {
                fee += fee * scanner.getAgency().getFirstClassFactor();
            }

            balance -= fee;
        }

        checkInHistory.add(scanner);
        checkedIn = !checkedIn;
    }

    @Override
    public String toString() {
        return "\r\nAnonymousCard:" +
                "\r\n    ID: " + cardId +
                "\r\n    Balance: " + balance +
                "\r\n    IsFirstClass: " + firstClass +
                "\r\n    IsCheckedIn: " + checkedIn +
                "\r\n    ExpireDate: " + expirationDate;
    }
}
