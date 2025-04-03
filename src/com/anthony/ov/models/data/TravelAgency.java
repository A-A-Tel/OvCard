package com.anthony.ov.models.data;

import java.util.Arrays;
import java.util.Objects;

public class TravelAgency {
    private final String name;
    private final double firstClassFactor;
    private final double[] minimumBalances;
    private final double[] travelFees;

    public TravelAgency(String name, double firstClassFactor, double[] minimumBalances, double[] travelFees) {
        this.name = name;
        this.firstClassFactor = firstClassFactor;
        this.minimumBalances = minimumBalances;
        this.travelFees = travelFees;
    }

    public double getFirstClassFactor() {
        return firstClassFactor;
    }

    public double getMinimumBalance(TransportType type) {
        return minimumBalances[type.ordinal()];
    }

    public double getTravelFee(TransportType type) {
        return travelFees[type.ordinal()];
    }

    public String name() {
        return name;
    }

    public double firstClassFactor() {
        return firstClassFactor;
    }

    public double[] minimumBalances() {
        return minimumBalances;
    }

    public double[] travelFees() {
        return travelFees;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        TravelAgency that = (TravelAgency) obj;
        return Objects.equals(this.name, that.name) &&
                Double.doubleToLongBits(this.firstClassFactor) == Double.doubleToLongBits(that.firstClassFactor) &&
                Arrays.equals(this.minimumBalances, that.minimumBalances) &&
                Arrays.equals(this.travelFees, that.travelFees);
    }

    @Override
    public String toString() {
        return "TravelAgency[" +
                "name=" + name + ", " +
                "firstClassFactor=" + firstClassFactor + ", " +
                "minimumBalances=" + Arrays.toString(minimumBalances) + ", " +
                "travelFees=" + Arrays.toString(travelFees) + ']';
    }

}