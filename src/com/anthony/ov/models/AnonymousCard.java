package com.anthony.ov.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class AnonymousCard {

    double balance;

    boolean firstClass;

    boolean checkedIn;

    String cardId;

    LocalDateTime expirationDate;

    ArrayList<CardScanner> checkInHistory;
}
