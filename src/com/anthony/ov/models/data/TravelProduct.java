package com.anthony.ov.models.data;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.List;

public class TravelProduct {

    private final String name;

    private final double discountFactor;

    private final double balanceRequirementDiscountFactor;

    private final boolean isFirstClass;

    private final List<DayOfWeek> validWeekDays;

    private final List<MonthDay> validYearDays;

    public TravelProduct(String name, double discountFactor, double balanceRequirementDiscountFactor,
                         boolean isFirstClass, List<DayOfWeek> validWeekDays, List<MonthDay> validYearDays) {
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

    public List<DayOfWeek> getValidWeekDays() {
        return validWeekDays;
    }

    public List<MonthDay> getValidYearDays() {
        return validYearDays;
    }

    public boolean isValidDay() {
        LocalDate now = LocalDate.now();
        DayOfWeek currentDay = now.getDayOfWeek();
        for (DayOfWeek day : validWeekDays) {
            if (day == currentDay) {
                return true;
            }
        }
        MonthDay currentMonthDay = MonthDay.from(now);
        for (MonthDay monthDay : validYearDays) {
            if (monthDay.equals(currentMonthDay)) {
                return true;
            }
        }
        return false;
    }
}
