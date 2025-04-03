package com.anthony.ov.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class AnonymousCard extends AccessCard {

    protected double balance;

    protected boolean firstClass;

    protected boolean checkedIn;

    protected final LocalDateTime expirationDate;

    protected final ArrayList<CardGate> checkInHistory;

    public AnonymousCard(double balance) {
        this.balance = balance;

        firstClass = false;
        checkedIn = false;

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

    public void setFirstClass(boolean firstClass) {
        this.firstClass = firstClass;
    }

    public LocalDateTime getExpireDate() {
        return expirationDate;
    }

    public ArrayList<CardGate> getCheckInHistory() {
        return checkInHistory;
    }

    public void checkIn(CardGate scanner) {

        checkInHistory.add(scanner);
        checkedIn = true;
    }

    public void checkOut(CardGate scanner, double fee) {

        balance -= Math.round(fee * 100) / 100.0;

        checkInHistory.add(scanner);
        checkedIn = false;
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
