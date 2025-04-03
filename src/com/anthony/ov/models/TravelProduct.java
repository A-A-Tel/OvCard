package com.anthony.ov.models;

import java.time.DayOfWeek;
import java.time.MonthDay;
import java.util.ArrayList;

public class TravelProduct {

    private final String name;

    private final double discountFactor;

    private final double balanceRequirementDiscountFactor;

    private final boolean isFirstClass;

    private final ArrayList<DayOfWeek> validWeekDays;

    private final ArrayList<MonthDay> validYearDays;

    public TravelProduct(String name, double discountFactor, double balanceRequirementDiscountFactor,
                         boolean isFirstClass, ArrayList<DayOfWeek> validWeekDays, ArrayList<MonthDay> validYearDays) {
        this.name = name;
        this.discountFactor = discountFactor;
        this.balanceRequirementDiscountFactor = balanceRequirementDiscountFactor;
        this.isFirstClass = isFirstClass;
        this.validWeekDays = validWeekDays;
        this.validYearDays = validYearDays;
    }

    public String getName() {
        return name;
    }

    public double getDiscountFactor() {
        return discountFactor;
    }

    public double getBalanceRequirementDiscountFactor() {
        return balanceRequirementDiscountFactor;
    }

    public boolean isFirstClass() {
        return isFirstClass;
    }

    public ArrayList<DayOfWeek> getValidWeekDays() {
        return validWeekDays;
    }

    public ArrayList<MonthDay> getValidYearDays() {
        return validYearDays;
    }
}
