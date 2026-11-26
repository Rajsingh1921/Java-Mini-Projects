package com.university.java.semester5.designpatterns.factory;

class Location {
    String city;
    double lat, lng;

    Location(String city, double lat, double lng) {
        this.city = city;
        this.lat = lat;
        this.lng = lng;
    }

    // This is not real GPS distance, just a simple check for the demo.
    // 1 degree is roughly 111 km, so 0.2 degree is about 20 km,
    // which is good enough to say "same city".
    boolean isNear(Location other) {
        return Math.abs(this.lat - other.lat) <= 0.2
                && Math.abs(this.lng - other.lng) <= 0.2;
    }
}
