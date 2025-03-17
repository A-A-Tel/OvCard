package com.anthony.ov;

import com.anthony.ov.models.Location;

public class Main {
    public static void main(String[] args) {

        Location amsterdam = new Location(4.9041, 52.3676, "Amsterdam");
        Location rotterdam = new Location(4.4777, 51.9244, "Rotterdam");

        System.out.println(amsterdam.calculateDistance(rotterdam));
    }
}
