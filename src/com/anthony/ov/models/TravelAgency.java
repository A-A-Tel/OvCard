package com.anthony.ov.models;

public class TravelAgency {

    private final String name;

    private final double firstClassFactor;

    private final double[] minimumBalances;

    private final double[] travelFees;

    public TravelAgency(String name, double firstClassFactor,double[] minimumBalances, double[] travelFees) {
        this.name = name;
        this.firstClassFactor = firstClassFactor;
        this.minimumBalances = minimumBalances;
        this.travelFees = travelFees;
    }

    public String getName() {
        return name;
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
}
